package com.sanisidro.service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

import com.sanisidro.annotation.ModelField;

public abstract class GenericEntityTO 
{	
	public static <S, T> T getEntity (T entity, S to) throws Exception
	{
		if(to == null)
		{
			return null;
		}
		Class<? extends Object> cEntity = entity.getClass();
		Class<? extends Object> cTO = to.getClass();
		Method [] ms = cTO.getMethods();
		for (int i = 0; i < ms.length; i++)
		{
			String name = ms[i].getName();
			if (name.contains("get") && !name.contains("Class"))
			{			
				String fieldname = getFieldName(name);
				name = name.replace("get", "set");
				Field field = to.getClass().getDeclaredField(fieldname);
				Annotation annotation = field.getAnnotation(ModelField.class);
				if (annotation != null) {
					Class<? extends Object> cSubEntity = ((ModelField) annotation).entityClass();
					Object subEntity = getEntity(cSubEntity.newInstance(), ms[i].invoke(to, new Object[]{}));
					cEntity.getMethod(name, cSubEntity).invoke(entity, new Object[] { subEntity });
				} else {
					cEntity.getMethod(name, ms[i].getReturnType()).invoke(entity, new Object [] {ms[i].invoke(to, new Object[]{})});
				}
			}
		}		
		return entity;
	}
	
	public static <S, T> S getTO (T entity, S to) throws Exception
	{
		if (entity == null)
		{
			return null;
		}
		Class<? extends Object> cTO = to.getClass();
		Class<? extends Object> cEntity = entity.getClass();	
		S ton = (S) cTO.newInstance();
		
		Method [] ms = cEntity.getMethods();
		for (int i = 0; i < ms.length; i++)
		{
			String name = ms[i].getName();
			if (name.contains("get") && !name.contains("Class"))
			{
				String fieldname = getFieldName(name);
				name = name.replace("get", "set");
				Field field = to.getClass().getDeclaredField(fieldname);
				Annotation annotation = field.getAnnotation(ModelField.class);
				if (annotation != null) {
					Class<? extends Object> cSubTO = field.getType();
					Object subTO = getTO(ms[i].invoke(entity, new Object[]{}), cSubTO.newInstance());
					cTO.getMethod(name, cSubTO).invoke(ton, new Object [] {subTO});
				} else {
					cTO.getMethod(name, ms[i].getReturnType()).invoke(ton, new Object [] {ms[i].invoke(entity, new Object[]{})});
				}
			}
		}		
		
		return ton;
	}
	
	private static String getFieldName(String methodName) {
		String fieldname = methodName.substring(3);
		char inicial = Character.toLowerCase(fieldname.charAt(0));
		fieldname = inicial + fieldname.substring(1);
		return fieldname;
	}
}