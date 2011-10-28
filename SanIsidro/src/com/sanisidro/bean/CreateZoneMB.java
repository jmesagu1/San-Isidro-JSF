package com.sanisidro.bean;

import java.util.List;

import com.sanisidro.to.ZoneTO;
import com.sanisidro.wrapper.SanIsidroWrapper;

public class CreateZoneMB {

	private String zoneName;
	private String message;
	private List<ZoneTO> zones;
	
	private long editId;
	private ZoneTO zoneTmp;
	
	public CreateZoneMB() {
		editId = -1;
		List<ZoneTO> tmp = new SanIsidroWrapper().getAllZones(); 
		if (tmp != null) {
			zones = tmp;
		} else {
			message = "Error consultando zonas";
		}
	}

	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ZoneTO> getZones() {
		return zones;
	}
	public void setZones(List<ZoneTO> zones) {
		this.zones = zones;
	}
	public long getEditId() {
		return editId;
	}
	public void setEditId(long editId) {
		this.editId = editId;
	}
	public ZoneTO getZoneTmp() {
		return zoneTmp;
	}
	public void setZoneTmp(ZoneTO zoneTmp) {
		this.zoneTmp = zoneTmp;
	}

	public String createZone()
	{
		if (!zoneName.trim().equals("")) {
			ZoneTO zone = new ZoneTO();
			zone.setName(zoneName);
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			zone = wrapper.createZone(zone);
			if (zone.getId() != -1)
			{
				message = "Zona registrada exitosamente";
				return "success";
			}
			else
			{
				message = "Error registrando zona";
				return "failure";
			}
		}
		else {
			message = "Debe ingresar un nombre de zona";
			return "failure";
		}
	}
	
	public String setEditable()
	{
		int i = 0;
		for (i = 0; i < zones.size(); i++) {
			if (zones.get(i).getId() == editId) {
				zones.get(i).setEditable(true);
				zoneTmp = zones.get(i);
			}
			else {
				zones.get(i).setEditable(false);
			}
		}
		return "";
	}
	
	public String updateZone() {
		if (!zoneTmp.getName().trim().equals("")) {
			SanIsidroWrapper wrapper = new SanIsidroWrapper();
			if (wrapper.updateZone(zoneTmp))
			{
				zoneTmp.setEditable(false);
				message = "Zona actualizada exitosamente";
				return "success";
			}
			else
			{
				message = "Error actualizando zona";
				return "failure";
			}
		}
		else {
			message = "Debe ingresar un nombre de zona";
			return "failure";
		}
	}
}