package com.sanisidro.service;

import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

import com.sanisidro.annotation.DTO;
import com.sanisidro.annotation.Model;

public abstract class GenericEntityTO 
{	
	public static <S, T> T getEntity (S to) throws Exception
	{
		boolean encontroClase = false;
		Class<? extends Object> cEntity = null;
		Annotation[] annotations = to.getClass().getAnnotations();
		for (int i = 0; !encontroClase && i < annotations.length; i++) 
		{
			if (annotations[i] instanceof DTO)
			{
				cEntity = ((DTO)annotations[i]).entityClass();
				encontroClase = true;
			}
		}
		if (encontroClase) 
		{
			T entity = (T) cEntity.newInstance();
			Class<? extends Object> cTO = to.getClass();			
			
			Method [] ms = cTO.getMethods();
			for (int i = 0; i < ms.length; i++)
			{
				if (ms [i].getName().contains("get") && !ms[i].getName().contains("Class") && !ms[i].getReturnType().toString().contains("TO"))
				{			
					String name = ms[i].getName();
					name = name.replace("get", "set");
					cEntity.getMethod(name, ms[i].getReturnType()).invoke(entity, new Object [] {ms[i].invoke(to, new Object[]{})});				
				}
			}		
			
			return entity;
		}
		else
		{
			throw new Exception("The object passed is not from a DTO marked class");
		}
	}
	
	public static <S, T> S getTO (T entity) throws Exception
	{
		boolean encontroClase = false;
		Class<? extends Object> cTO = null;
		Annotation[] annotations = entity.getClass().getAnnotations();
		for (int i = 0; !encontroClase && i < annotations.length; i++) 
		{
			if (annotations[i] instanceof Model)
			{
				cTO = ((Model)annotations[i]).dtoClass();
				encontroClase = true;
			}
		}
		if (encontroClase)
		{
			Class<? extends Object> cEntity = entity.getClass();	
			S ton = (S) cTO.newInstance();
			
			Method [] ms = cEntity.getMethods();
			for (int i = 0; i < ms.length; i++)
			{
				if (ms [i].getName().contains("get") && !ms[i].getName().contains("Class"))
				{			
					String name = ms[i].getName();
					name = name.replace("get", "set");
					cTO.getMethod(name, ms[i].getReturnType()).invoke(ton, new Object [] {ms[i].invoke(entity, new Object[]{})});				
				}
			}		
			
			return ton;
		}
		else
		{
			throw new Exception("The object passed is not from a Model marked class");
		}
	}
}
