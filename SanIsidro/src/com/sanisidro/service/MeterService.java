package com.sanisidro.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.Meter;
import com.sanisidro.to.MeterTO;

public class MeterService implements IService {

	public List<MeterTO> searchMeters(String serie, double price, Calendar dateFrom, Calendar dateTo) 
			throws Exception  
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
		String strQuery = "select m from Meter m where m.deleted = false and lower(m.serie) like lower(:serie)";
		boolean withPrice = false;
		if (price != -1) {
			strQuery += " and m.price = :price";
			withPrice = true;
		}
		boolean withDates = false;
		if (dateFrom != null && dateTo != null) {
			strQuery += " and m.dateBought >= :dateFrom and m.dateBought <= :dateTo";
			withDates = true;
		}
        Query query = em.createQuery(strQuery);
        query.setParameter("serie", serie + "%");
        if (withDates) {        	
        	query.setParameter("dateFrom", dateFrom);
        	query.setParameter("dateTo", dateTo);
        }
        if (withPrice) {
        	query.setParameter("price", price);
        }
        List<MeterTO> result = convertList(query.getResultList());
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}

	public List<MeterTO> searchMetersByUser(String name, String lastName, long dni) 
			throws Exception  
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();
		String strQuery = "select m from Meter m where m.deleted = false and lower(m.service.user.name) like lower(:name) " +
				"and lower(m.service.user.surname) like lower(:lastName)";
		boolean withDni = false;
		if (dni != -1) {
			strQuery += " and m.service.user.dni = :dni";
			withDni = true;
		}
        Query query = em.createQuery(strQuery);
        query.setParameter("name", name + "%");
        query.setParameter("lastName", lastName + "%");
        if (withDni) {
        	query.setParameter("dni", dni);
        }
        List<MeterTO> result = convertList(query.getResultList());
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}

	public List<MeterTO> searchMetersByService(String farmName, double priceSuscription, long payNumber,
			Calendar dateFrom, Calendar dateTo, long zoneId, long serviceTypeId) 
			throws Exception  
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = emf.createEntityManager();

		String strQuery = "select m from Meter m where m.deleted = false and lower(m.service.farmName) like lower(:farmName)";
		boolean withPrice = false;
		if (priceSuscription != -1) {
			strQuery += " and m.service.priceSuscription = :priceSuscription";
			withPrice = true;
		}
		boolean withPayNo = false;
		if (payNumber != -1) {
			strQuery += " and m.service.payNumber = :payNumber";
			withPayNo = true;
		}
		boolean withDates = false;
		if (dateFrom != null && dateTo != null) {
			strQuery += " and m.service.startDate >= :dateFrom and m.service.startDate <= :dateTo";
			withDates = true;
		}
		boolean withZoneId = false;
		if (zoneId != -1) {
			strQuery += " and m.service.zone.id = :zoneId";
			withZoneId = true;
		}
		boolean withServiceTypeId = false;
		if (serviceTypeId != -1) {
			strQuery += " and m.service.type.id = :serviceTypeId";
			withServiceTypeId = true;
		}

        Query query = em.createQuery(strQuery);
        query.setParameter("farmName", farmName + "%");
        if (withPrice) {
        	query.setParameter("priceSuscription", priceSuscription);
        }
        if (withDates) {
        	query.setParameter("dateFrom", dateFrom);
        	query.setParameter("dateTo", dateTo);
        }
        if (withPayNo) {
        	query.setParameter("payNumber", payNumber);
        }
        if (withZoneId) {
        	query.setParameter("zoneId", zoneId);
        }
        if (withServiceTypeId) {
        	query.setParameter("serviceTypeId", serviceTypeId);
        }
        List<MeterTO> result = convertList(query.getResultList());
    	if (em != null) {
    		em.close();
    	}
    	return result;
	}
	
	private List<MeterTO> convertList(List<Meter> meters) throws Exception {
        List<MeterTO> result = new ArrayList<MeterTO>();
        for (Meter meter : meters) {
        	MeterTO to = GenericEntityTO.getTO(meter); 
			result.add(to);
		}
        return result;
	}

	@Override
	public Object create(Object obj, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object obj, EntityManager em) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getDetails(Object obj, EntityManager em) {
		// TODO Auto-generated method stub
		return null;
	}
}