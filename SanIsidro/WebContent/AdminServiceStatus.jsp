<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Estados de Servicio</title>
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
	<h:inputHidden id="editId" value="#{serviceStatusMB.editId}"/>
   	<h:panelGrid border="1" columns="2">
		<h:outputLabel value="Nombre Estado" />
		<h:inputText value="#{serviceStatusMB.name}"/>
		<h:outputLabel value="Descripción" />
		<h:inputText value="#{serviceStatusMB.description}"/>
		<h:outputText value=""></h:outputText>
		<h:commandButton value="Registrar" action="#{serviceStatusMB.createServiceStatus}"/>
	</h:panelGrid>
	<h:outputText style="color:red;" value="#{serviceStatusMB.message}"/>
	<h:dataTable border="1" value="#{serviceStatusMB.statusList}" var="status" rendered="#{serviceStatusMB.renderTable}">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Nombre de Estado"></h:outputText>
			</f:facet>
			<h:outputText value="#{status.name}" rendered="#{not status.editable}"/>
			<h:inputText value="#{serviceStatusMB.statusTmp.name}" rendered="#{status.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Descripción"></h:outputText>
			</f:facet>
			<h:outputText value="#{status.description}" rendered="#{not status.editable}"/>
			<h:inputText value="#{serviceStatusMB.statusTmp.description}" rendered="#{status.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Acción"></h:outputText>
			</f:facet>
			<h:commandLink onclick="setEditId(#{status.id});" action="#{serviceStatusMB.setEditable}" value="Editar" rendered="#{not status.editable}"/>
			<h:commandLink action="#{serviceStatusMB.updateServiceStatus}" value="Guardar" rendered="#{status.editable}"/>
		</h:column>
	</h:dataTable>
</h:form>
</f:view>
</body>
</html>