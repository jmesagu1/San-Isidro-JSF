package com.sanisidro.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.sanisidro.entity.User;
import com.sanisidro.entity.UserType;
import com.sanisidro.to.UserTO;
import com.sanisidro.to.UserTypeTO;

public class UserService {
	
	public static List <UserTO> getAllCustomers()
	{
		List<UserTO> userTOs = new ArrayList<UserTO>();
		try 
		{			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("SanIsidro");
			EntityManager em = emf.createEntityManager();
			List <User> list = em.createQuery("select u from User u").getResultList();
			for (User s: list)
			{
				//UserTO uto = GenericEntityTO.getTO(s, new UserTO());
				//uto.setType((UserTypeTO) GenericEntityTO.getTO(s.getType()));
				userTOs.add(GenericEntityTO.getTO(s, new UserTO()));
			}
			if (em != null)
			{
				em.close();
			}
			
		}
		catch (Exception e) 
		{
			System.out.println("Error getAllCustomers(): " + e.getMessage());
		}
		
		return userTOs;
		
	}
	
	public static UserTO createUser(UserTO userTO)
	{
		try 
		{
//			User user = GenericEntityTO.getEntity(userTO);			
//			user.setType((UserType) GenericEntityTO.getEntity(userTO.getType()));
//			user = GenericService.create(user);
			
			User user = GenericService.create(GenericEntityTO.getEntity(new User(), userTO));
		}
		catch (Exception e) 
		{
			System.out.println("Error: " + e.getMessage());
		}
		return userTO;
	}

}
