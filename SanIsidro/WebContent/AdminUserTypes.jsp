<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Tipos de Usuario</title>
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
<h1>Tipos de Usuarios</h1>
<h:form id="form">
	<h:inputHidden id="editId" value="#{userTypeMB.editId}"/>
	<h:panelGrid border="1" columns="2">
		<h:outputText value="Tipo de Usuario" />
		<h:inputText value="#{userTypeMB.name}"/>
		<h:outputText value=""></h:outputText>
		<h:commandButton value="Registrar" action="#{userTypeMB.createUserType}"/>
	</h:panelGrid>
	<h:outputText style="color:red;" value="#{userTypeMB.message}"/>
	<h:dataTable border="1" value="#{userTypeMB.userTypes}" var="type">
		<h:column>
			<f:facet name="header">
				<h:outputText value="Tipo de Usuario"></h:outputText>
			</f:facet>
			<h:outputText value="#{type.name}" rendered="#{not type.editable}"/>
			<h:inputText value="#{type.name}" rendered="#{type.editable}"/>
		</h:column>
		<h:column>
			<f:facet name="header">
				<h:outputText value="Acción"></h:outputText>
			</f:facet>
			<h:commandLink onclick="setEditId(#{type.id});" value="Editar" action="#{userTypeMB.setEditable}" rendered="#{not type.editable}"/>
			<h:commandLink value="Guardar" action="#{userTypeMB.updateUserType}" rendered="#{type.editable}"/>
		</h:column>
	</h:dataTable>
</h:form>
</f:view>
</center>
</body>
</html>