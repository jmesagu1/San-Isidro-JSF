<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Tarifas Simples</title>
<script type="text/javascript">
	function setEditId(id)
	{
		document.getElementById("form:editId").value = id;
	}
</script>
</head>
<body>
<f:view>
<h:form id="form">
	<h:inputHidden id="editId" value="#{faresMB.editId}"/>
	<h:panelGrid border="0" columns="2">
		<h:outputText value="Nombre de Tarifa" />
		<h:inputText value="#{faresMB.name}"/>
		<h:outputText value="Precio" />
		<h:inputText value="#{faresMB.price}" converter="javax.faces.Double" converterMessage="El precio debe ser un numero">
			<f:validateDoubleRange minimum="0"/>
		</h:inputText>
		<h:outputText value=""/>
		<h:commandButton value="Registrar" action="#{faresMB.registerFare}"/>
	</h:panelGrid>
	<h:outputText style="color:red;" value="#{faresMB.message}"/>
	<h:dataTable border="1" value="#{faresMB.fares}" var="fare">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tipo de Servicio"></h:outputText>
			</f:facet>
			<h:outputText value="#{fare.name}" rendered="#{not fare.editable}"/>
			<h:inputText value="#{faresMB.fareTmp.name}" rendered="#{fare.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Precio"></h:outputText>
			</f:facet>
			<h:outputText value="#{fare.price}" rendered="#{not fare.editable}"/>
			<h:inputText value="#{faresMB.fareTmp.price}" converter="javax.faces.Double" rendered="#{fare.editable}">
				<f:validateDoubleRange minimum="0"/>
			</h:inputText>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Acción"></h:outputText>
			</f:facet>
			<h:commandLink onclick="setEditId(#{fare.id});" value="Editar" action="#{faresMB.setEditable}" rendered="#{not fare.editable}"/>
			<h:commandLink value="Guardar" action="#{faresMB.updateFare}" rendered="#{fare.editable}"/>
		</h:column>
	</h:dataTable>
</h:form>
</f:view>
</body>
</html>