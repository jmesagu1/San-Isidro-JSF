<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestión General</title>
</head>
<body>
<f:view>
<jsp:include page="PrincipalTemplate.jsp"></jsp:include>
	<center>
		<h:form>
			<h1>Gestión de Maestros</h1>
				<h:panelGrid border="1" columns="1">
					<h:outputLink value="CreateZone.jsp">Zonas</h:outputLink>
					<h:outputLink value="AdminUserTypes.jsp">Tipos de Usuarios</h:outputLink>
					<h:outputLink value="AdminServiceTypes.jsp">Tipos de Servicios</h:outputLink>
					<h:outputLink>Tarifas</h:outputLink>
				</h:panelGrid>
			</h:form>
	</center>
</f:view>
</body>
</html>