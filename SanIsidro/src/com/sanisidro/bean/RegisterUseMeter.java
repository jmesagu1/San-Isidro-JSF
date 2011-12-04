package com.sanisidro.bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.sanisidro.to.MeterTO;
import com.sanisidro.to.UseMeterRegisterTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class RegisterUseMeter {

	private double metersCount;
	private String strDate;
	private MeterTO meter;
	private String message;

	public double getMetersCount() {
		return metersCount;
	}
	public void setMetersCount(double metersCount) {
		this.metersCount = metersCount;
	}
	public String getStrDate() {
		return strDate;
	}
	public void setStrDate(String strDate) {
		this.strDate = strDate;
	}
	public MeterTO getMeter() {
		return meter;
	}
	public void setMeter(MeterTO meter) {
		this.meter = meter;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public void updateMB(long meterId) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		strDate = format.format(cal.getTime());
		SanIsidroWrapper wrapper = new SanIsidroWrapper();
		meter = wrapper.getMeter(meterId);
	}
	
	public String registerMeterUse() {
		String result;
		if (strDate != null && !strDate.equals("")) {
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(format.parse(strDate).getTime());
				UseMeterRegisterTO to = new UseMeterRegisterTO();
				to.setCountMeter(metersCount);
				to.setDateRegister(cal);
				to.setMeter(meter);
				to = new SanIsidroWrapper().createUseMeterRegister(to);
				if (to != null) {
					result = "success";
					message = "Registro de Consumo exitoso";
				} else {
					result = "failure";
					message = "Error registrando consumo";
				}
			} catch (ParseException e) {
				result = "failure";
				message = "Error en fecha de registro";
				e.printStackTrace();
			}
		}
		else{
			result = "failure";
			message = "Error en fecha de registro";
		}
		MessajeUtility.saveMessajeSession(message);
		return result;
	}
}