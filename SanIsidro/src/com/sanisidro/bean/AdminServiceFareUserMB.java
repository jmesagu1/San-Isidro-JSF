package com.sanisidro.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.sanisidro.entity.ServiceFareUserPK;
import com.sanisidro.to.FareTO;
import com.sanisidro.to.ServiceFareUserTO;
import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.to.UserTypeTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class AdminServiceFareUserMB {
	
	//Parameters for creating new ServiceFareUser
	private String name;
	private double price;
	private String message;
	private long userTypeId;
	private long serviceTypeId;

	//Lists to be displayed
	private List<SelectItem> userTypeList;
	private List<SelectItem> serviceTypeList;
	private List<ServiceFareUserTO> fares;

	//Parameters for updating a ServiceFareUserTO
	private String nameEdit;
	private double priceEdit;
	private long fareIdEdit;
	private long userTypeIdOld;
	private long serviceTypeIdOld;
	private long userTypeIdNew;
	private long serviceTypeIdNew;

	public AdminServiceFareUserMB() {
		userTypeList = new ArrayList<SelectItem>();
		serviceTypeList = new ArrayList<SelectItem>();
		
		SanIsidroWrapper wrapper = new SanIsidroWrapper();
		fares = wrapper.getAllServiceFareUser();
		List<UserTypeTO> userTypes = wrapper.getAllUserTypes();
		List<ServiceTypeTO> serviceTypes = wrapper.getAllServiceTypes();
		for (UserTypeTO userType : userTypes) {
			userTypeList.add(new SelectItem(userType.getId(), userType.getName()));
		}
		for (ServiceTypeTO serviceType : serviceTypes) {
			serviceTypeList.add(new SelectItem(serviceType.getId(), serviceType.getDetail()));
		}
	}
	
	public long getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(long userTypeId) {
		this.userTypeId = userTypeId;
	}
	public long getServiceTypeId() {
		return serviceTypeId;
	}
	public void setServiceTypeId(long serviceTypeId) {
		this.serviceTypeId = serviceTypeId;
	}
	public List<SelectItem> getUserTypeList() {
		return userTypeList;
	}
	public void setUserTypeList(List<SelectItem> userTypeList) {
		this.userTypeList = userTypeList;
	}
	public List<SelectItem> getServiceTypeList() {
		return serviceTypeList;
	}
	public void setServiceTypeList(List<SelectItem> serviceTypeList) {
		this.serviceTypeList = serviceTypeList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getNameEdit() {
		return nameEdit;
	}
	public void setNameEdit(String nameEdit) {
		this.nameEdit = nameEdit;
	}
	public double getPriceEdit() {
		return priceEdit;
	}
	public void setPriceEdit(double priceEdit) {
		this.priceEdit = priceEdit;
	}
	public long getUserTypeIdOld() {
		return userTypeIdOld;
	}
	public void setUserTypeIdOld(long userTypeIdOld) {
		this.userTypeIdOld = userTypeIdOld;
	}
	public long getServiceTypeIdOld() {
		return serviceTypeIdOld;
	}
	public void setServiceTypeIdOld(long serviceTypeIdOld) {
		this.serviceTypeIdOld = serviceTypeIdOld;
	}
	public long getFareIdEdit() {
		return fareIdEdit;
	}
	public void setFareIdEdit(long fareIdEdit) {
		this.fareIdEdit = fareIdEdit;
	}
	public List<ServiceFareUserTO> getFares() {
		return fares;
	}
	public void setFares(List<ServiceFareUserTO> fares) {
		this.fares = fares;
	}
	public long getUserTypeIdNew() {
		return userTypeIdNew;
	}
	public void setUserTypeIdNew(long userTypeIdNew) {
		this.userTypeIdNew = userTypeIdNew;
	}
	public long getServiceTypeIdNew() {
		return serviceTypeIdNew;
	}
	public void setServiceTypeIdNew(long serviceTypeIdNew) {
		this.serviceTypeIdNew = serviceTypeIdNew;
	}

	public String createServiceFareUser() {
		String result = "failure";
		if (!name.trim().equals("")) {
			if (userTypeId != -1) {
				if (serviceTypeId != -1) {
					SanIsidroWrapper wrapper = new SanIsidroWrapper();
					ServiceFareUserTO sfu = new ServiceFareUserTO();
					FareTO fare = new FareTO();
					fare.setName(name);
					fare.setPrice(price);
					ServiceTypeTO serviceType = new ServiceTypeTO();
					serviceType.setId(serviceTypeId);
					UserTypeTO userType = new UserTypeTO();
					userType.setId(userTypeId);

					sfu.setFare(fare);
					sfu.setServiceType(serviceType);
					sfu.setUserType(userType);
					if (wrapper.createServiceFareUser(sfu) != null) {
						message = "Tarifa creada exitosamente";
						refreshList();
						result = "success";
					} else {
						message = "Error creando Tarifa";
					}
				} else {
					message = "Debe seleccionar un Tipo de Servicio";
				}
			} else {
				message = "Debe seleccionar un Tipo de Usuario";
			}
		} else {
			message = "Debe ingresar un nombre para la Tarifa";
		}
		return result;
	}

	public String setEditable()
	{
		int i = 0;
		for (i = 0; i < fares.size(); i++) {
			ServiceFareUserTO fare = fares.get(i);
			if (fare.getFare().getId() == fareIdEdit &&
					fare.getUserType().getId() == userTypeIdOld &&
					fare.getServiceType().getId() == serviceTypeIdOld ) {
				nameEdit = fare.getFare().getName();
				priceEdit = fare.getFare().getPrice();
				fares.get(i).setEditable(true);
				userTypeIdNew = userTypeIdOld;
				serviceTypeIdNew = serviceTypeIdOld;
			}
			else {
				fares.get(i).setEditable(false);
			}
		}
		return "";
	}
	
	public String updateFare() {
		String result = "failure";
		if (!nameEdit.trim().equals("")) {
			if (userTypeIdNew != -1) {
				if (serviceTypeIdNew != -1) {
					SanIsidroWrapper wrapper = new SanIsidroWrapper();
					ServiceFareUserTO sfu = new ServiceFareUserTO();

					FareTO fare = new FareTO();
					fare.setId(fareIdEdit);
					fare.setName(nameEdit);
					fare.setPrice(priceEdit);
					ServiceTypeTO serviceType = new ServiceTypeTO();
					serviceType.setId(serviceTypeIdNew);
					UserTypeTO userType = new UserTypeTO();
					userType.setId(userTypeIdNew);

					sfu.setFare(fare);
					sfu.setServiceType(serviceType);
					sfu.setUserType(userType);
					
					ServiceFareUserPK oldPK = new ServiceFareUserPK();
					oldPK.setIdFare(fareIdEdit);
					oldPK.setIdServiceType(serviceTypeIdOld);
					oldPK.setIdUserType(userTypeIdOld);
					if (wrapper.updateServiceFareUser(sfu, oldPK)) {
						message = "Tarifa actualizada exitosamente";
						refreshList();
						result = "success";
					} else {
						message = "Error actualizando Tarifa";
					}
				} else {
					message = "Debe seleccionar un Tipo de Servicio";
				}
			} else {
				message = "Debe seleccionar un Tipo de Usuario";
			}
		} else {
			message = "Debe ingresar un nombre para la Tarifa";
		}
		return result;
	}
	
	public void refreshList() {
		SanIsidroWrapper wrapper = new SanIsidroWrapper();
		fares = wrapper.getAllServiceFareUser();
	}
}