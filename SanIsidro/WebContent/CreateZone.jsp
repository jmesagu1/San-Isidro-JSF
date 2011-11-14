<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<?xml version="1.0" encoding="UTF-8"?>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Zonas</title>
<script type="text/javascript">
	function setEditId(id)
	{
		document.getElementById("form:editId").value = id;
	}
</script>
</head>
<body>
<center>
<f:view>
<jsp:include page="PrincipalTemplate.jsp"></jsp:include>
<h1>Zonas</h1>
	<h:form id="form">
	<h:inputHidden id="editId" value="#{createZoneMB.editId}"/>
	<h:panelGrid border="1" columns="2">
		<h:outputText value="Nombre de Zona" />
		<h:inputText value="#{createZoneMB.zoneName}"/>
		<h:outputText value=""></h:outputText>
		<h:commandButton value="Registrar" action="#{createZoneMB.createZone}"/>
	</h:panelGrid>
	<h:outputText style="color:red;" value="#{createZoneMB.message}"/>
	<h:dataTable border="1" value="#{createZoneMB.zones}" var="zone">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Nombre de Zona"></h:outputText>
			</f:facet>
			<h:outputText value="#{zone.name}" rendered="#{not zone.editable}"/>
			<h:inputText value="#{createZoneMB.zoneTmp.name}" rendered="#{zone.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Acción"></h:outputText>
			</f:facet>
			<h:commandLink onclick="setEditId(#{zone.id});" action="#{createZoneMB.setEditable}" value="Editar" rendered="#{not zone.editable}"/>
			<h:commandLink action="#{createZoneMB.updateZone}" value="Guardar" rendered="#{zone.editable}"/>
		</h:column>
	</h:dataTable>
	</h:form>
</f:view>
</center>
</body>
</html>