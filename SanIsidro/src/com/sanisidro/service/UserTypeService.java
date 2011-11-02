package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.UserType;
import com.sanisidro.to.UserTypeTO;

public class UserTypeService implements IService{

	@Override
	public Object create(Object obj, EntityManager em) {
		UserTypeTO to = (UserTypeTO) obj;
		em.getTransaction().begin();
		UserType userType = new UserType();
		userType.setName(to.getName());
		em.persist(userType);
		to.setId(userType.getId());
		em.getTransaction().commit();
		return to;
	}

	@Override
	public boolean update(Object obj, EntityManager em) {
		boolean result = false;
		UserTypeTO to = (UserTypeTO) obj;
		em.getTransaction().begin();
		UserType userType = em.find(UserType.class, to.getId());
		if (userType != null) {
			userType.setName(to.getName());
			result = true;
		}
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Object getDetails(Object obj, EntityManager em) {
		UserTypeTO to = (UserTypeTO) obj;
		em.getTransaction().begin();
		UserType userType = em.find(UserType.class, to.getId());
		if (userType != null) {
			to.setName(userType.getName());
			return to;
		} else {
			return null;
		}
	}
	
	public List<UserTypeTO> getAllUserTypes() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select ut from UserType ut");
        List<UserType> rs = query.getResultList();
        List<UserTypeTO> result = new ArrayList<UserTypeTO>();
        for (UserType userType : rs) {
        	UserTypeTO to = new UserTypeTO();
        	to.setId(userType.getId());
			to.setName(userType.getName());
			result.add(to);
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}