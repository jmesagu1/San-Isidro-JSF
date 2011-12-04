<%@page import="javax.faces.context.FacesContext"%>
<%@page import="com.sanisidro.bean.RegisterUseMeter"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://static.jquery.com/ui/css/demo-docs-theme/ui.theme.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script>
<title>Registrar Consumo</title>
<script type="text/javascript">
	$(function() {
		$( "#date" ).datepicker({ dateFormat: 'dd/mm/yy', defaultDate: +2 });
	});
	
	function updateDate(field) {
		var strDate = document.getElementById(field).value;
		document.getElementById("form:" + field).value = strDate;
	}
</script>
<% 
   long meterId = -1;
   String strId = request.getParameter("meterId");
   if (strId != null) 
   {
	   meterId = Long.parseLong(request.getParameter("meterId"));
   }
   RegisterUseMeter mb = (RegisterUseMeter)(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("registerUseMeter"));
   if (mb == null)
   {
	   mb = new RegisterUseMeter();
	   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("registerUseMeter", mb);
   }
   if (meterId != -1) {
	   mb.updateMB(meterId);
   }
   String strDate = mb.getStrDate();
%>
</head>
<body>
<f:view>
<h:form id="form">
	<h:panelGrid border="1" columns="2">
		<h:outputLabel value="Cliente"/>
		<h:outputLabel value="#{registerUseMeter.meter.service.user.name} #{registerUseMeter.meter.service.user.surname}"/>
		<h:outputLabel value="N° Serie Contador"/>
		<h:outputLabel value="#{registerUseMeter.meter.serie}"/>
		<h:outputLabel value="Finca"/>
		<h:outputLabel value="#{registerUseMeter.meter.service.farmName}"/>
		<h:outputLabel value="Metros Máximos"/>
		<h:outputLabel value="#{registerUseMeter.meter.maxMeters}"/>
		<h:outputLabel value="Precio Metro Adicional"/>
		<h:outputLabel value="#{registerUseMeter.meter.addMeterFare.price}"/>
	</h:panelGrid>
	<h:inputHidden id="date" value="#{registerUseMeter.strDate}"/>
	<h:panelGrid columns="1" border="0">
	<h:panelGrid columns="2" border="0">
		<h:outputLabel value="Metros Consumidos"/>
		<h:inputText value="#{registerUseMeter.metersCount}">
			<f:validateDoubleRange minimum="0"/>
		</h:inputText>
		<h:outputLabel value="Fecha de Registro"/>
		<input id="date" onchange="updateDate('date');" value="<%=strDate%>">
	</h:panelGrid>
	<h:commandButton value="Registrar Consumo" action="#{registerUseMeter.registerMeterUse}"/>
	</h:panelGrid>
	<h:messages>
		<h:outputLabel value="#{registerUseMeter.message}"/>
	</h:messages>
</h:form>
</f:view>
</body>
</html>