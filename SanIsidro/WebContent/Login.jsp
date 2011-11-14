<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<f:view>
	<center>
		<h:form>
		<img src="images/logo.png"/>
			<H1>Login</H1>		
			<h:panelGrid border="1" columns="2">
					<h:outputLabel value="Usuario:"></h:outputLabel>
					<h:inputText maxlength="20" required="true" requiredMessage="Ingrese un nombre de usuario" value="#{login.username }"></h:inputText>
					<h:outputLabel value="Contraseña"></h:outputLabel>
					<h:inputSecret required="true" maxlength="20" requiredMessage="Ingrese la contraseña" value="#{login.password }"></h:inputSecret>
				</h:panelGrid>
				<h:commandButton value="Ingresar" action="#{login.login}"></h:commandButton>
				<br><h:messages style="color: #FF0000"></h:messages>
				<br><h:outputLabel value="#{login.message }" style="color: #FF0000"></h:outputLabel>
			</h:form>
	</center>
</f:view>
</body>
</html>