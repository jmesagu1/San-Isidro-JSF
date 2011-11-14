<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Tipos de Servicio</title>
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
	<h:inputHidden id="editId" value="#{serviceTypeMB.editId}"/>
	<h:panelGrid border="1" columns="2">
		<h:outputText value="Tipo de Servicio" />
		<h:inputText value="#{serviceTypeMB.detail}"/>
		<h:outputText value="¿Con Contador?" />
		<h:selectOneMenu value="#{serviceTypeMB.hasMeter}">
			<f:selectItem itemLabel="Si" itemValue="true"/>
			<f:selectItem itemLabel="No" itemValue="false"/>
		</h:selectOneMenu>
		<h:outputText value=""></h:outputText>
		<h:commandButton value="Registrar" action="#{serviceTypeMB.createServiceType}"/>
	</h:panelGrid>
	<h:outputText style="color:red;" value="#{serviceTypeMB.message}"/>
	<h:dataTable border="1" value="#{serviceTypeMB.serviceTypes}" var="type">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tipo de Servicio"></h:outputText>
			</f:facet>
			<h:outputText value="#{type.detail}" rendered="#{not type.editable}"/>
			<h:inputText value="#{type.detail}" rendered="#{type.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tiene Contador"></h:outputText>
			</f:facet>
			<h:selectBooleanCheckbox value="#{type.hasMeter}" disabled="#{not type.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Acción"></h:outputText>
			</f:facet>
			<h:commandLink onclick="setEditId(#{type.id});" value="Editar" action="#{serviceTypeMB.setEditable}" rendered="#{not type.editable}"/>
			<h:commandLink value="Guardar" action="#{serviceTypeMB.updateServiceType}" rendered="#{type.editable}"/>
		</h:column>
	</h:dataTable>
	</h:form>
</f:view>
</body>
</html>