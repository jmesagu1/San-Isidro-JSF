package com.sanisidro.bean;

import java.util.List;

import com.sanisidro.to.ServiceStatusTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class AdminServiceStatusMB {

	private String name;
	private String description;
	private String message;

	private long editId;
	private ServiceStatusTO statusTmp;
	private List<ServiceStatusTO> statusList;
	private boolean renderTable;
	
	public AdminServiceStatusMB() {
		refreshList(new SanIsidroWrapper());
	}

	public long getEditId() {
		return editId;
	}
	public void setEditId(long editId) {
		this.editId = editId;
	}
	public List<ServiceStatusTO> getStatusList() {
		return statusList;
	}
	public void setStatusList(List<ServiceStatusTO> statusList) {
		this.statusList = statusList;
	}
	public boolean isRenderTable() {
		return renderTable;
	}
	public void setRenderTable(boolean renderTable) {
		this.renderTable = renderTable;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ServiceStatusTO getStatusTmp() {
		return statusTmp;
	}
	public void setStatusTmp(ServiceStatusTO statusTmp) {
		this.statusTmp = statusTmp;
	}

	public String createServiceStatus() {
		String result = "failure";
		if (!name.trim().equals("")) {
			if (!description.trim().equals("")) {
				ServiceStatusTO serviceStatus = new ServiceStatusTO();
				serviceStatus.setName(name);
				serviceStatus.setDescription(description);
				SanIsidroWrapper wrapper = new SanIsidroWrapper();
				serviceStatus = wrapper.createServiceStatus(serviceStatus);
				if (serviceStatus.getId() != -1) {
					message = "Estado de Servicio registrado exitosamente";
					refreshList(wrapper);
					result = "success";
				}
			} else {
				message = "Debe ingresar una descripción";
			}
		} else {
			message = "Debe ingresar un nombre";
		}
		return result;
	}

	public String setEditable()
	{
		int i = 0;
		for (i = 0; i < statusList.size(); i++) {
			if (statusList.get(i).getId() == editId) {
				statusList.get(i).setEditable(true);
				statusTmp = statusList.get(i);
			}
			else {
				statusList.get(i).setEditable(false);
			}
		}
		return "";
	}

	public String updateServiceStatus() {
		String result = "failure";
		if (!statusTmp.getName().trim().equals("")) {
			if (!statusTmp.getDescription().trim().equals("")) {
				SanIsidroWrapper wrapper = new SanIsidroWrapper();
				if (wrapper.updateServiceStatus(statusTmp))
				{
					statusTmp.setEditable(false);
					message = "Estado se Servicio actualizado exitosamente";
					refreshList(wrapper);
					result = "success";
				}
				else {
					message = "Error actualizando zona";
				}
			}
			else {
				message = "Debe ingresar una descripción";
			}
		}
		else {
			message = "Debe ingresar un nombre";
		}
		return result;
	}

	public void refreshList(SanIsidroWrapper wrapper) {
		statusList = wrapper.getAllServiceStatus();
		if (statusList != null && !statusList.isEmpty()) {
			renderTable = true;
		} else {
			renderTable = false;
		}
	}
}