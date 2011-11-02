package com.sanisidro.bean;

import java.util.List;

import com.sanisidro.to.UserTypeTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class AdminUserTypeMB {

	private String name;
	private String message;
	private List<UserTypeTO> userTypes;
	
	private long editId;
	private UserTypeTO userTypeTmp;
	
	public AdminUserTypeMB() {
		editId = -1;
		refreshList();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserTypeTO> getUserTypes() {
		return userTypes;
	}
	public void setUserTypes(List<UserTypeTO> userTypes) {
		this.userTypes = userTypes;
	}
	public long getEditId() {
		return editId;
	}
	public void setEditId(long editId) {
		this.editId = editId;
	}
	public UserTypeTO getUserTypeTmp() {
		return userTypeTmp;
	}
	public void setUserTypeTmp(UserTypeTO userTypeTmp) {
		this.userTypeTmp = userTypeTmp;
	}

	public String createServiceType()
	{
		if (!name.trim().equals("")) {
			UserTypeTO to = new UserTypeTO();
			to.setName(name);
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			to = wrapper.createUserType(to);
			if (to.getId() != -1)
			{
				refreshList();
				message = "Tipo de Usuario registrado exitosamente";
				return "success";
			}
			else
			{
				message = "Error registrando Tipo de Usuario";
				return "failure";
			}
		}
		else {
			message = "Debe ingresar un nombre para el Tipo de Usuario";
			return "failure";
		}
	}
	
	public String setEditable()
	{
		int i = 0;
		for (i = 0; i < userTypes.size(); i++) {
			if (userTypes.get(i).getId() == editId) {
				userTypes.get(i).setEditable(true);
				userTypeTmp = userTypes.get(i);
			}
			else {
				userTypes.get(i).setEditable(false);
			}
		}
		return "";
	}
	
	public String updateServiceType() {
		if (!userTypeTmp.getName().trim().equals("")) {
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			if (wrapper.updateUserType(userTypeTmp))
			{
				userTypeTmp.setEditable(false);
				message = "Tipo de Usuario actualizado exitosamente";
				return "success";
			}
			else
			{
				message = "Error actualizando Tipo de Usuario";
				return "failure";
			}
		}
		else {
			message = "Debe ingresar un nombre para el Tipo de Usuario";
			return "failure";
		}
	}
	
	public void refreshList()
	{
		List<UserTypeTO> tmp = new SanIsidroWrapper().getAllUserTypes();
		if (tmp != null) {
			userTypes = tmp;
		} else {
			message = "Error consultando tipos de servicio";
		}
	}
}