package com.sanisidro.bean;

import java.util.List;

import com.sanisidro.to.ServiceTypeTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class AdminServiceTypeMB {

	private String detail;
	private boolean hasMeter;
	private String message;
	private List<ServiceTypeTO> serviceTypes;
	
	private long editId;
	private ServiceTypeTO serviceTypeTmp;
	
	public AdminServiceTypeMB() {
		editId = -1;
		List<ServiceTypeTO> tmp = new SanIsidroWrapper().getAllServiceTypes();
		if (tmp != null) {
			serviceTypes = tmp;
		} else {
			message = "Error consultando tipos de servicio";
		}
	}

	public boolean isHasMeter() {
		return hasMeter;
	}

	public void setHasMeter(boolean hasMeter) {
		this.hasMeter = hasMeter;
	}

	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ServiceTypeTO> getServiceTypes() {
		return serviceTypes;
	}
	public void setServiceTypes(List<ServiceTypeTO> serviceTypes) {
		this.serviceTypes = serviceTypes;
	}
	public long getEditId() {
		return editId;
	}
	public void setEditId(long editId) {
		this.editId = editId;
	}
	public ServiceTypeTO getServiceTypeTmp() {
		return serviceTypeTmp;
	}
	public void setServiceTypeTmp(ServiceTypeTO serviceTypeTmp) {
		this.serviceTypeTmp = serviceTypeTmp;
	}

	public String createZone()
	{
		if (!detail.trim().equals("")) {
			ServiceTypeTO to = new ServiceTypeTO();
			to.setDetail(detail);
			to.setHasMeter(hasMeter);
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			to = wrapper.createServiceType(to);
			if (to.getId() != -1)
			{
				message = "Tipo de Servicio registrado exitosamente";
				return "success";
			}
			else
			{
				message = "Error registrando Tipo de Servicio";
				return "failure";
			}
		}
		else {
			message = "Debe ingresar un nombre para el Tipo de Servicio";
			return "failure";
		}
	}
	
	public String setEditable()
	{
		int i = 0;
		for (i = 0; i < serviceTypes.size(); i++) {
			if (serviceTypes.get(i).getId() == editId) {
				serviceTypes.get(i).setEditable(true);
				serviceTypeTmp = serviceTypes.get(i);
			}
			else {
				serviceTypes.get(i).setEditable(false);
			}
		}
		return "";
	}
	
	public String updateZone() {
		if (!serviceTypeTmp.getDetail().trim().equals("")) {
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			if (wrapper.updateServiceType(serviceTypeTmp))
			{
				serviceTypeTmp.setEditable(false);
				message = "Tipo de Servicio actualizado exitosamente";
				return "success";
			}
			else
			{
				message = "Error actualizando Tipo de Servicio";
				return "failure";
			}
		}
		else {
			message = "Debe ingresar un nombre para el Tipo de Servicio";
			return "failure";
		}
	}
}