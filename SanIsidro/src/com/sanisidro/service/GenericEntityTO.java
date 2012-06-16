package com.sanisidro.service;

import java.lang.annotation.Annotation;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.sanisidro.annotation.CollectionField;
import com.sanisidro.annotation.ModelField;

public abstract class GenericEntityTO 
{	
	public static <S, T> T getEntity (T entity, S to) throws Exception
	{
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
					Annotation annotation2 = field.getAnnotation(CollectionField.class);
					if (annotation2 != null) {
						Class<? extends Object> cSubEntity = ((CollectionField) annotation2).entityClass();
						List<Object> subTOs = (List<Object>) ms[i].invoke(to, new Object[]{});
						List<Object> subEntities = new ArrayList<Object>();
						for (int j = 0; j < subTOs.size(); j++) {
							Object subEntity = getEntity(cSubEntity.newInstance(), subTOs.get(j));
							subEntities.add(subEntity);
						}
						cEntity.getMethod(name, List.class).invoke(entity, new Object[] { subEntities });
					} else {
						cEntity.getMethod(name, ms[i].getReturnType()).invoke(entity, new Object [] {ms[i].invoke(to, new Object[]{})});
					}
				}
			}
		}		
		return entity;
	}
	
	private static <S, T> S getTO (T entity, Class<S> toClass, Map<Object, Object> instances) throws Exception
	{
		if (entity == null)
		{
			return null;
		}
		Class<? extends Object> cEntity = entity.getClass();	
		if (instances.containsKey(entity))
		{
			return (S) instances.get(cEntity);
		} 
		else 
		{
			S ton = toClass.newInstance();
			instances.put(entity, ton);
			Method [] ms = cEntity.getMethods();
			for (int i = 0; i < ms.length; i++)
			{
				String name = ms[i].getName();
				if (name.contains("get") && !name.contains("Class"))
				{
					String fieldname = getFieldName(name);
					name = name.replace("get", "set");
					Field field = toClass.getDeclaredField(fieldname);
					Annotation annotation = field.getAnnotation(ModelField.class);
					if (annotation != null) {
						Class<? extends Object> cSubTO = field.getType();
						Object subE = ms[i].invoke(entity, new Object[]{});
						if (instances.containsKey(subE)) 
						{
							toClass.getMethod(name, cSubTO).invoke(ton, instances.get(subE));
						}
						else
						{
							Object subTO = getTO(subE, cSubTO);
							toClass.getMethod(name, cSubTO).invoke(ton, new Object [] {subTO});	
						}
					} 
					else
					{
						Annotation annotation2 = field.getAnnotation(CollectionField.class);
						if (annotation2 != null) 
						{
							ParameterizedType listType = (ParameterizedType) field.getGenericType();
					        Class<? extends Object> cSubTO = (Class<? extends Object>) listType.getActualTypeArguments()[0];
							Collection subEntities =  (Collection) ms[i].invoke(entity, new Object[]{});
							Collection<Object> subTOs = subEntities.getClass().newInstance();
							Iterator iter = subEntities.iterator();
							while (iter.hasNext()) 
							{								
								Object subTO = getTO(iter.next(), cSubTO, instances);
								subTOs.add(subTO);
							}
							toClass.getMethod(name, List.class).invoke(ton, new Object [] { subTOs });
						} 
						else 
						{
							toClass.getMethod(name, ms[i].getReturnType()).invoke(ton, new Object [] {ms[i].invoke(entity, new Object[]{})});
						}
					}
				}
			}		
			return ton;
		}
	}
	

	public static <S, T> S getTO (T entity, Class<S> toClass) throws Exception
	{
		Map<Object, Object> instances = new LinkedHashMap<Object, Object>();		
		return getTO(entity, toClass, instances);
	}
	
	private static String getFieldName(String methodName) {
		String fieldname = methodName.substring(3);
		char inicial = Character.toLowerCase(fieldname.charAt(0));
		fieldname = inicial + fieldname.substring(1);
		return fieldname;
	}
}
