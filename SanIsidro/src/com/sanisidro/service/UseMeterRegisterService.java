package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sanisidro.entity.UseMeterRegister;
import com.sanisidro.to.ServiceTO;
import com.sanisidro.to.UseMeterRegisterTO;

public class UseMeterRegisterService {

	private EntityManager em;
	
	public UseMeterRegisterService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		em = emf.createEntityManager();
	}
	
	public List<UseMeterRegisterTO> getUseMeterRegisters(ServiceTO service) throws Exception
	{
		String strQuery = "select umr from UseMeterRegister umr where umr.meter.service.id = :id";
		Query query = em.createQuery(strQuery);
		query.setParameter("id", service.getId());
		List<UseMeterRegister> rs = query.getResultList();
		List<UseMeterRegisterTO> registers = new ArrayList<UseMeterRegisterTO>();
		for (UseMeterRegister register : rs) {
			registers.add(GenericEntityTO.getTO(register, new UseMeterRegisterTO()));
		}
    	return registers;
	}
}