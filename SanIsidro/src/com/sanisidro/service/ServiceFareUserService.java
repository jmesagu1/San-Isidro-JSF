package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.Fare;
import com.sanisidro.entity.ServiceFareUser;
import com.sanisidro.entity.ServiceFareUserPK;
import com.sanisidro.entity.ServiceType;
import com.sanisidro.entity.UserType;
import com.sanisidro.to.FareTO;
import com.sanisidro.to.ServiceFareUserTO;
import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.to.UserTypeTO;

public class ServiceFareUserService implements IService {

	@Override
	public Object create(Object obj, EntityManager em) {
		ServiceFareUserTO to = (ServiceFareUserTO) obj;
		em.getTransaction().begin();
		try {
			FareTO fare = GenericService.create(new Fare(), to.getFare());
			ServiceFareUser entity = new ServiceFareUser();
			entity.setIdFare(fare.getId());
			entity.setIdServiceType(to.getServiceType().getId());
			entity.setIdUserType(to.getUserType().getId());
			em.persist(entity);
			em.getTransaction().commit();
			return to;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(Object obj, EntityManager em) {
		boolean result = false;
		ServiceFareUserTO to = (ServiceFareUserTO) ((Object[]) obj)[0];
		ServiceFareUserPK pk = (ServiceFareUserPK) ((Object[]) obj)[1];
		ServiceFareUser entity = em.find(ServiceFareUser.class, pk);
		if (entity != null) {
			em.getTransaction().begin();
			try {
				GenericService.update(new Fare(), to.getFare());
			} catch (Exception e) {
				e.printStackTrace();
			}
			em.remove(entity);
			em.getTransaction().commit();
			em.getTransaction().begin();
			ServiceFareUser newEntity = new ServiceFareUser();
			newEntity.setIdFare(to.getFare().getId());
			newEntity.setIdServiceType(to.getServiceType().getId());
			newEntity.setIdUserType(to.getUserType().getId());
			em.merge(newEntity);
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
			UserTypeTO userType = new UserTypeTO();
			ServiceTypeTO serviceType = new ServiceTypeTO();
			try {
				fare = GenericService.find(new Fare(), fare, entity.getIdFare());
				userType = GenericService.find(new UserType(), userType, entity.getIdUserType());
				serviceType = GenericService.find(new ServiceType(), serviceType, entity.getIdServiceType());

				ServiceFareUserTO to = new ServiceFareUserTO();
				to.setFare(fare);
				to.setUserType(userType);
				to.setServiceType(serviceType);
				return to;
			} catch (Exception e) {
				return null;
			}
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
        	ServiceFareUserTO to = (ServiceFareUserTO) getDetails(pk, em);
        	if (to != null) {
        		result.add(to);
        	}
		}
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
}