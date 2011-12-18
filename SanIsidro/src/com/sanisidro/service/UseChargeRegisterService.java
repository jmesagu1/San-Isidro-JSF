package com.sanisidro.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sanisidro.entity.UseChargeRegister;
import com.sanisidro.to.UseChargeRegisterTO;

public class UseChargeRegisterService {
	
	public boolean createMeterCharges(List<UseChargeRegisterTO> ucrs)
	{
		boolean result;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
		EntityManager em = null;
		try
		{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			for (UseChargeRegisterTO charge : ucrs) {
				UseChargeRegister entity = GenericEntityTO.getEntity(new UseChargeRegister(), charge);
				em.persist(entity);
			}
			em.getTransaction().commit();
			result = true;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			result = false; 
		}
		finally
		{
			if (em != null)
			{
				em.close();
			}			
		}
		return result;	
	}
}