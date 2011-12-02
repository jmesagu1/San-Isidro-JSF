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
<title>Buscar Contadores</title>
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
<jsp:include page="PrincipalTemplate.jsp"></jsp:include>
<h:form id="form">
	<h:inputHidden id="dateFrom" value="#{searchMeterMB.strDateFrom}"></h:inputHidden>
	<h:inputHidden id="dateTo" value="#{searchMeterMB.strDateTo}"></h:inputHidden>
	<h:panelGrid columns="4">
		<h:outputLabel value="N° Serie"/>
		<h:inputText value="#{searchMeterMB.serie}"/>
		<h:outputLabel value=""/>
		<h:outputLabel value=""/>
		<h:outputLabel value="Precio"/>
		<h:inputText value="#{searchMeterMB.strPrice}"/>
		<h:outputLabel value=""/>
		<h:outputLabel value=""/>
		<h:outputLabel value="Fecha Desde"/>
		<input id="dateFrom" onchange="updateDate('dateFrom');">
		<h:outputLabel value="Fecha Hasta"/>
		<input id="dateTo" onchange="updateDate('dateTo');">
		<h:commandButton value="Buscar" action="#{searchMeterMB.searchMeters}"/>
	</h:panelGrid>
	<h:dataTable value="#{searchMeterMB.meters}" var="meter" border="1" rendered="#{searchMeterMB.renderTable}">
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