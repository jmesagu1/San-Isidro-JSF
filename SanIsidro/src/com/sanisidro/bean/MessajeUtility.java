package com.sanisidro.bean;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MessajeUtility {
	
	public static void saveMessajeSession (String messaje)
	{
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		session.setAttribute("messaje", messaje);
	}

}
