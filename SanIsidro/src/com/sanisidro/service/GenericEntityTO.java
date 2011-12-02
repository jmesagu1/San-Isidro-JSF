package com.sanisidro.service;

import java.lang.reflect.Method;

public abstract class GenericEntityTO 
{	
	public static <S, T> T getEntity (T entity, S to) throws Exception
	{
		Class<? extends Object> cEntity = entity.getClass();
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
	
	public static <S, T> S getTO (T entity, S to) throws Exception
	{
		Class<? extends Object> cEntity = entity.getClass();
		Class<? extends Object> cTO = to.getClass();	
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
}
