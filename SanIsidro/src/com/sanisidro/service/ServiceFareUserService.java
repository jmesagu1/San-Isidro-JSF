package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.ServiceFareUser;
import com.sanisidro.entity.ServiceFareUserPK;
import com.sanisidro.to.FareTO;
import com.sanisidro.to.ServiceFareUserTO;
import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.to.UserTypeTO;

public class ServiceFareUserService implements IService {

	@Override
	public Object create(Object obj, EntityManager em) {
		ServiceFareUserTO to = (ServiceFareUserTO) obj;
		em.getTransaction().begin();
		ServiceFareUser entity = new ServiceFareUser();
		entity.setIdFare(to.getFare().getId());
		entity.setIdServiceType(to.getServiceType().getId());
		entity.setIdUserType(to.getUserType().getId());
		em.persist(entity);
		em.getTransaction().commit();
		return to;
	}

	@Override
	public boolean update(Object obj, EntityManager em) {
		boolean result = false;
		ServiceFareUserTO to = (ServiceFareUserTO) obj;
		ServiceFareUserPK pk = new ServiceFareUserPK();
		pk.setIdFare(to.getFare().getId());
		pk.setIdServiceType(to.getServiceType().getId());
		pk.setIdUserType(to.getUserType().getId());
		ServiceFareUser entity = em.find(ServiceFareUser.class, pk);
		if (entity != null) {
			em.getTransaction().begin();
			entity.setIdFare(to.getFare().getId());
			entity.setIdServiceType(to.getServiceType().getId());
			entity.setIdUserType(to.getUserType().getId());
			em.persist(entity);
			em.getTransaction().commit();
			result = true;
		}
		return result;
	}

	/**
	 * Retrieves a fully detailed ServiceFareUserTO.
	 * 
	 * @param obj An instance of {@link ServiceFareUserPK}.
	 * @param em  The {@link EntityManager} responsible for the Persistence.
	 */
	@Override
	public Object getDetails(Object obj, EntityManager em) {
		ServiceFareUserPK pk = (ServiceFareUserPK) obj;
		ServiceFareUser entity = em.find(ServiceFareUser.class, pk);
		if (entity != null) {
			FareTO fare = new FareTO();
			fare.setId(entity.getIdFare());
			fare = (FareTO) new FareService().getDetails(fare, em);
			UserTypeTO userType = new UserTypeTO();
			userType.setId(entity.getIdUserType());
			userType = (UserTypeTO) new UserTypeService().getDetails(userType, em);
			ServiceTypeTO serviceType = new ServiceTypeTO();
			serviceType.setId(entity.getIdServiceType());
			serviceType = (ServiceTypeTO) new ServiceTypeService().getDetails(serviceType, em);
			
			ServiceFareUserTO to = new ServiceFareUserTO();
			to.setFare(fare);
			to.setUserType(userType);
			to.setServiceType(serviceType);
			return to;
		} else {
			return null;
		}
	}
	
	public List<ServiceFareUserTO> getAllServiceFareUser() throws Exception {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("select sfu from ServiceFareUser sfu");
        List<ServiceFareUser> rs = query.getResultList();
        List<ServiceFareUserTO> result = new ArrayList<ServiceFareUserTO>();
        for (ServiceFareUser sfu : rs) {
        	ServiceFareUserPK pk = new ServiceFareUserPK();
        	pk.setIdFare(sfu.getIdFare());
        	pk.setIdServiceType(sfu.getIdServiceType());
        	pk.setIdUserType(sfu.getIdUserType());
			result.add((ServiceFareUserTO) getDetails(pk, em));
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}