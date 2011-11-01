package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.ServiceType;
import com.sanisidro.to.ServiceTypeTO;

public class ServiceTypeService implements IService
{
	@Override
	public Object create(Object obj, EntityManager em) {
		ServiceTypeTO to = (ServiceTypeTO) obj;
		em.getTransaction().begin();
		ServiceType serviceType = new ServiceType();
		serviceType.setDetail(to.getDetail());
		serviceType.setHasMeter(to.getHasMeter());
		em.persist(serviceType);
		to.setId(serviceType.getId());
		em.getTransaction().commit();
		return to;
	}

	@Override
	public boolean update(Object obj, EntityManager em) {
		boolean result = false;
		ServiceTypeTO to = (ServiceTypeTO) obj;
		em.getTransaction().begin();
		ServiceType serviceType = em.find(ServiceType.class, to.getId());
		if (serviceType != null) {
			serviceType.setDetail(to.getDetail());
			serviceType.setHasMeter(to.getHasMeter());
			result = true;
		}
		em.getTransaction().commit();
		return result;
	}

	@Override
	public Object getDetails(Object obj, EntityManager em) {
		ServiceTypeTO to = (ServiceTypeTO) obj;
		em.getTransaction().begin();
		ServiceType serviceType = em.find(ServiceType.class, to.getId());
		if (serviceType != null) {
			to.setDetail(serviceType.getDetail());
			to.setHasMeter(to.getHasMeter());
			return to;
		} else {
			return null;
		}
	}
	
	public List<ServiceTypeTO> getAllServiceTypes() throws Exception
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select st from ServiceType st");
        List<ServiceType> rs = query.getResultList();
        List<ServiceTypeTO> result = new ArrayList<ServiceTypeTO>();
        for (ServiceType serviceType : rs) {
        	ServiceTypeTO to = new ServiceTypeTO();
        	to.setId(serviceType.getId());
			to.setDetail(serviceType.getDetail());
			to.setHasMeter(serviceType.getHasMeter());
			result.add(to);
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}