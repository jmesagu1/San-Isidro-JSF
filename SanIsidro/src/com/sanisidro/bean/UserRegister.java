package com.sanisidro.bean;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import com.sanisidro.to.UserTO;
import com.sanisidro.to.UserTypeTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class UserRegister 
{
	private ArrayList<SelectItem> userTipes = new ArrayList<SelectItem>();
	private Long userTypeSelected;	
	private Long dni;
	private String name;
	private String surname;
	private String telephone1;
	private String telephone2;
	private String messaje;
	
	public String registerUser()
	{		
		String returnValue = "failure";
		try 
		{
			UserTO user = new UserTO();
			user.setDni(dni);
			user.setName(name);
			user.setSurname(surname);
			user.setTelephone1(telephone1);
			user.setTelephone2(telephone2);
			UserTypeTO userTypeTO = new UserTypeTO();
			userTypeTO.setId(userTypeSelected);
			UserTypeTO type = SanIsidroWrapper.getInstance().getUserTypeByID(userTypeTO);
			user.setType(type);
			user = SanIsidroWrapper.getInstance().createUser(user);
			returnValue = "success";
			MessajeUtility.saveMessajeSession(user.getName() + " " + user.getSurname() + 
					" fué registrado con documento: " + user.getDni() );
			
		}
		catch (Exception e) 
		{
			messaje = e.getMessage();
		}
		return returnValue;
	}
	
	public Long getUserTypeSelected() {
		return userTypeSelected;
	}
	public void setUserTypeSelected(Long userTypeSelected) {
		this.userTypeSelected = userTypeSelected;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getTelephone1() {
		return telephone1;
	}
	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}
	public String getTelephone2() {
		return telephone2;
	}
	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}
	public UserRegister ()
	{		
		List<UserTypeTO> tos = SanIsidroWrapper.getInstance().getAllUserTypes();
		for (UserTypeTO u : tos)
		{
			userTipes.add(new SelectItem(u.getId(), u.getName()));
		}
	}	
	public ArrayList<SelectItem> getUserTipes() {
		return userTipes;
	}
	public void setUserTipes(ArrayList<SelectItem> userTipes) {
		this.userTipes = userTipes;
	}

	public String getMessaje() {
		return messaje;
	}

	public void setMessaje(String messaje) {
		this.messaje = messaje;
	}
	
	
}
