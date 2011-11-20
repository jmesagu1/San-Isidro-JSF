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
<title>Buscar Contador por Servicio</title>
<script type="text/javascript">
	$(function() {
		$( "#dateFrom" ).datepicker({ dateFormat: 'dd/mm/yy' });
	});

	$(function() {
		$( "#dateTo" ).datepicker({ dateFormat: 'dd/mm/yy' });
	});
	
	function updateDate(field) {
		var strDate = document.getElementById(field).value;
		document.getElementById("form:" + field).value = strDate;
	}
</script>
</head>
<body>
<f:view>
<h:form id="form">
	<h:inputHidden id="dateFrom" value="#{meterByServiceMB.strDateFrom}"></h:inputHidden>
	<h:inputHidden id="dateTo" value="#{meterByServiceMB.strDateTo}"></h:inputHidden>
	<h:panelGrid columns="4">
		<h:outputLabel value="Nombre de Finca"/>
		<h:inputText value="#{meterByServiceMB.farmName}"/>
		<h:outputLabel value=""/>
		<h:outputLabel value=""/>
		<h:outputLabel value="Precio Suscripción"/>
		<h:inputText value="#{meterByServiceMB.strPriceSuscription}"/>
		<h:outputLabel value=""/>
		<h:outputLabel value=""/>
		<h:outputLabel value="Número de Cuotas"/>
		<h:inputText value="#{meterByServiceMB.strPayNumber}"/>
		<h:outputLabel value=""/>
		<h:outputLabel value=""/>
		<h:outputLabel value="Zona"/>
		<h:selectOneMenu value="#{meterByServiceMB.zoneId}">
			<f:selectItem itemLabel="-Select-" itemValue="-1" />
			<f:selectItems value="#{meterByServiceMB.zones}"/>
		</h:selectOneMenu>
		<h:outputLabel value=""/>
		<h:outputLabel value=""/>
		<h:outputLabel value="Tipo de Servicio"/>
		<h:selectOneMenu value="#{meterByServiceMB.serviceTypeId}">
			<f:selectItem itemLabel="-Select-" itemValue="-1" />
			<f:selectItems value="#{meterByServiceMB.serviceTypes}"/>
		</h:selectOneMenu>
		<h:outputLabel value=""/>
		<h:outputLabel value=""/>
		<h:outputLabel value="Fecha Desde"/>
		<input id="dateFrom" onchange="updateDate('dateFrom');">
		<h:outputLabel value="Fecha Hasta"/>
		<input id="dateTo" onchange="updateDate('dateTo');">
		<h:commandButton value="Buscar" action="#{meterByServiceMB.searchMeters}"/>
	</h:panelGrid>
	<h:dataTable value="#{meterByServiceMB.meters}" var="meter" border="1" rendered="#{meterByServiceMB.renderTable}">
		<h:column>
			<f:facet name="header">
				<h:outputText value="N° Serie"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.serie}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Fecha de Compra"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.dateBought}" converter="dateConverter"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Precio"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.price}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="N° de Pagos"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.payNumber}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Nombre Finca"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.service.farmName}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Metros Máximos"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.maxMeters}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tarifa"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.addMeterFare.price}"/>
		</h:column>
	</h:dataTable>
</h:form>
</f:view>
</body>
</html>