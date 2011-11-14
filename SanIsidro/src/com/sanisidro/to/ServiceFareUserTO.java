package com.sanisidro.to;

public class ServiceFareUserTO {
	
	private FareTO fare;
	private UserTypeTO userType;
	private ServiceTypeTO serviceType;

	private boolean editable;

	public ServiceFareUserTO() {
		editable = false;
	}

	public FareTO getFare() {
		return fare;
	}
	public void setFare(FareTO fare) {
		this.fare = fare;
	}
	public UserTypeTO getUserType() {
		return userType;
	}
	public void setUserType(UserTypeTO userType) {
		this.userType = userType;
	}
	public ServiceTypeTO getServiceType() {
		return serviceType;
	}
	public void setServiceType(ServiceTypeTO serviceType) {
		this.serviceType = serviceType;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}