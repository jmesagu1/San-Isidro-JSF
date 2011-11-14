package com.sanisidro.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericService 
{
	public static <T, S> S create (T entity, S to ) throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			entity = GenericEntityTO.getEntity(entity, to);
			em.persist(entity);
			em.getTransaction().commit();
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}
		}
		return 	GenericEntityTO.getTO(entity, to);		
	}
	
	public static <T, S> S find (Object entity, S to, Object pk)throws Exception
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
		return GenericEntityTO.getTO(entity, to);
	}
}
