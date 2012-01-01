package com.sanisidro.annotation;

import com.sanisidro.wrapper.SanIsidroWrapper;

public class RegisterUseChargesMB {
	
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String registerUseCharges() {
		String result;
		SanIsidroWrapper wrapper = new SanIsidroWrapper();
		boolean chargesCreated = wrapper.creteUseChargeRegisters();
		if (chargesCreated) {
			message = "Cobros por consumo registrados exitosamente";
			result = "success";
		} else {
			message = "Error registrando Cobros por consumo";
			result = "failure";
		}
		return result;
	}
}