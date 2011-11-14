package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.Fare;
import com.sanisidro.to.FareTO;

public class FareService implements IService {

	@Override
	public Object create(Object obj, EntityManager em) {
		FareTO to = (FareTO) obj;
		Fare fare = new Fare();
		fare.setName(to.getName());
		fare.setPrice(to.getPrice());
		em.getTransaction().begin();
		em.persist(fare);
		em.getTransaction().commit();
		to.setId(fare.getId());
		return to;
	}

	@Override
	public boolean update(Object obj, EntityManager em) {
		boolean result = false;
		FareTO to = (FareTO) obj;
		Fare fare = em.find(Fare.class, to.getId());
		if (fare != null) {
			em.getTransaction().begin();
			fare.setName(to.getName());
			fare.setPrice(to.getPrice());
			em.getTransaction().commit();
			result = true;
		}
		return result;
	}

	@Override
	public Object getDetails(Object obj, EntityManager em) {
		FareTO to = (FareTO) obj;
		Fare fare = em.find(Fare.class, to.getId());
		if (fare != null) {
			to.setName(fare.getName());
			to.setPrice(fare.getPrice());
			return to;
		} else {
			return null;
		}
	}
	
	public List<FareTO> getAllFares() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select f from Fare f");
        List<Fare> fares = query.getResultList();
        List<FareTO> result = new ArrayList<FareTO>();
        for (Fare fare : fares) {
        	FareTO to = new FareTO();
			to.setId(fare.getId());
			to.setName(fare.getName());
			to.setPrice(fare.getPrice());
			result.add(to);
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}