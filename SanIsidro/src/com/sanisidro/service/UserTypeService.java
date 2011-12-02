package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.UserType;
import com.sanisidro.to.UserTypeTO;

public class UserTypeService {
	
	public List<UserTypeTO> getAllUserTypes() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select ut from UserType ut");
        List<UserType> rs = query.getResultList();
        List<UserTypeTO> result = new ArrayList<UserTypeTO>();
        for (UserType userType : rs) {
        	UserTypeTO to = GenericEntityTO.getTO(userType); 
			result.add(to);
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}