package com.sanisidro.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CRUDService {
	
	public IService loadDataService(String className) {
		try {
	        IService ds = (IService) Class.forName(className).newInstance();
	        return ds;
	    } catch (Exception e) {
	        return null;
	    }
	}
	
	public Object create(String dataServiceClass, Object object) throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
        IService ds = loadDataService(dataServiceClass);
        em = emf.createEntityManager();
        Object result = ds.create(object, em);
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
	
	public boolean update(String dataServiceClass, Object object) {
		boolean result = false;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
	    try {
	        IService ds = loadDataService(dataServiceClass);
	        em = emf.createEntityManager();
	        result = ds.update(object, em);
	    } catch (Exception e) {
	    	result = false;
	        e.printStackTrace();
	    } finally {
	    	if (em != null) {
	    		em.close();
	    	}
	    }
	    return result;
	}
	
	public Object get(String dataServiceClass, Object object) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
	    try {
	        IService ds = loadDataService(dataServiceClass);
	        em = emf.createEntityManager();
	        ds.getDetails(object, em);
	        return object;
	    } catch (Exception e) {
	        return null;
	    } finally {
	    	if (em != null) {
	    		em.close();
	    	}
	    }
	}
}