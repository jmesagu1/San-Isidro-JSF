<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Tarifas Compuestas</title>
<script type="text/javascript">
	function setEditId(fareId, serviceTypeId, userTypeId)
	{
		document.getElementById("form:fareId").value = fareId;
		document.getElementById("form:serviceTypeId").value = serviceTypeId;
		document.getElementById("form:userTypeId").value = userTypeId;
	}
</script>
</head>
<body>
<f:view>
<h:form id="form">
	<h:inputHidden id="fareId" value="#{serviceFareUserMB.fareIdEdit}"/>
	<h:inputHidden id="serviceTypeId" value="#{serviceFareUserMB.serviceTypeIdOld}"/>
	<h:inputHidden id="userTypeId" value="#{serviceFareUserMB.userTypeIdOld}"/>
	<h:panelGrid border="0" columns="2">
		<h:outputText value="Nombre de Tarifa" />
		<h:inputText value="#{serviceFareUserMB.name}"/>
		<h:outputLabel value="Precio" />
		<h:inputText value="#{serviceFareUserMB.price}" converter="javax.faces.Double" converterMessage="El precio debe ser un numero">
			<f:validateDoubleRange minimum="0"/>
		</h:inputText>
		<h:outputLabel value="Tipo de Servicio"/>
		<h:selectOneMenu value="#{serviceFareUserMB.serviceTypeId}">
			<f:selectItem itemLabel="-SELECT-" itemValue="-1"/>
			<f:selectItems value="#{serviceFareUserMB.serviceTypeList}"/>
		</h:selectOneMenu>
		<h:outputLabel value="Tipo de Usuario"/>
		<h:selectOneMenu value="#{serviceFareUserMB.userTypeId}">
			<f:selectItem itemLabel="-SELECT-" itemValue="-1"/>
			<f:selectItems value="#{serviceFareUserMB.userTypeList}"/>
		</h:selectOneMenu>
		<h:outputText value=""/>
		<h:commandButton value="Registrar" action="#{serviceFareUserMB.createServiceFareUser}"/>
	</h:panelGrid>
	<h:outputText style="color:red;" value="#{serviceFareUserMB.message}"/>
	<h:dataTable border="1" value="#{serviceFareUserMB.fares}" var="fare">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tarifa"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{fare.fare.name}" rendered="#{not fare.editable}"/>
			<h:inputText value="#{serviceFareUserMB.nameEdit}" rendered="#{fare.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Precio"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{fare.fare.price}" rendered="#{not fare.editable}"/>
			<h:inputText value="#{serviceFareUserMB.priceEdit}" converter="javax.faces.Double" rendered="#{fare.editable}">
				<f:validateDoubleRange minimum="0"/>
			</h:inputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tipo de Servicio"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{fare.serviceType.detail}" rendered="#{not fare.editable}"/>
			<h:selectOneMenu value="#{serviceFareUserMB.serviceTypeIdNew}" rendered="#{fare.editable}">
				<f:selectItem itemLabel="-SELECT-" itemValue="-1"/>
				<f:selectItems value="#{serviceFareUserMB.serviceTypeList}"/>
			</h:selectOneMenu>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tipo de Usuario"></h:outputText>
			</f:facet>
			<h:outputLabel value="#{fare.userType.name}" rendered="#{not fare.editable}"/>
			<h:selectOneMenu value="#{serviceFareUserMB.userTypeIdNew}" rendered="#{fare.editable}">
				<f:selectItem itemLabel="-SELECT-" itemValue="-1"/>
				<f:selectItems value="#{serviceFareUserMB.userTypeList}"/>
			</h:selectOneMenu>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Acción"></h:outputText>
			</f:facet>
			<h:commandLink onclick="setEditId(#{fare.fare.id},#{fare.serviceType.id},#{fare.userType.id});" value="Editar" action="#{serviceFareUserMB.setEditable}" rendered="#{not fare.editable}"/>
			<h:commandLink value="Guardar" action="#{serviceFareUserMB.updateFare}" rendered="#{fare.editable}"/>
		</h:column>
	</h:dataTable>
</h:form>
</f:view>
</body>
</html>