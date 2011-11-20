<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Contador por Cliente</title>
</head>
<body>
<f:view>
<h:form id="form">
	<h:panelGrid columns="2">
		<h:outputLabel value="Nombre"/>
		<h:inputText value="#{metersByUserMB.name}"/>
		<h:outputLabel value="Apellido"/>
		<h:inputText value="#{metersByUserMB.lastname}"/>
		<h:outputLabel value="Documento"/>
		<h:inputText value="#{metersByUserMB.strDni}"/>
		<h:commandButton value="Buscar" action="#{metersByUserMB.searchMeters}"/>
	</h:panelGrid>
	<h:dataTable value="#{metersByUserMB.meters}" var="meter" border="1" rendered="#{metersByUserMB.renderTable}">
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
		<h:column>
			<f:facet name="header">
				<h:outputText value="Cliente"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{meter.service.user.name} #{meter.service.user.surname}"/>
		</h:column>
	</h:dataTable>
</h:form>
</f:view>
</body>
</html>