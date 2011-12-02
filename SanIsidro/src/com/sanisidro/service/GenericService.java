package com.sanisidro.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericService 
{
	public static <T, S> S create (T entity, S to ) throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			entity = GenericEntityTO.getEntity(to);
			em.persist(entity);
			em.getTransaction().commit();
			to = GenericEntityTO.getTO(entity);
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}			
		}
		return to;	
	}
	
	public static <S> S find (Object entity, S to, Object pk)throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();			
			entity =  em.find(entity.getClass(), pk);			
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
		if (entity == null)
		{
			return null;
		}
		else
		{
			return GenericEntityTO.getTO(entity);
		}
	}	
	
	public static <S> S update (Object entity, S to) throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			entity = GenericEntityTO.getEntity(to);
			entity = em.merge(entity);
			em.getTransaction().commit();
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
		return GenericEntityTO.getTO(entity);
	}
	
	public static <T> void delete (Object entity, T to) throws  Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			entity = GenericEntityTO.getEntity(to);
			em.remove(entity);
			em.getTransaction().commit();
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
	}
}
