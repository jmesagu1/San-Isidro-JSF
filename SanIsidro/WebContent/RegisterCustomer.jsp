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
<jsp:include page="PrincipalTemplate.jsp"></jsp:include>
	<center>
		<h1>Registrar Usuario</h1>
		<h:form>
				<h:panelGrid border="1" columns="2">
					<h:outputLabel value="Documento: "></h:outputLabel>
					<h:inputText value="#{userRegister.dni}" required="true" requiredMessage="Ingrese un documento válido" >
						<f:convertNumber integerOnly="true"/>
					</h:inputText>
					<h:outputLabel value="Nombre:"></h:outputLabel>
					<h:inputText value="#{userRegister.name }" required="true" requiredMessage="Ingrese un nombre válido"></h:inputText>
					<h:outputLabel value="Apellido:"></h:outputLabel>
					<h:inputText value="#{userRegister.surname }" required="true" requiredMessage="Ingrese un apellido válido"></h:inputText>
					<h:outputLabel value="Teléfono 1:"></h:outputLabel>
					<h:inputText value="#{userRegister.telephone1 }"></h:inputText>
					<h:outputLabel value="Teléfono 2:"></h:outputLabel>
					<h:inputText value="#{userRegister.telephone2 }"></h:inputText>
					<h:outputLabel value="Tipo:"></h:outputLabel>
					<h:selectOneMenu value="#{userRegister.userTypeSelected }" required="true" requiredMessage="Seleccione un tipo de Usuario">
						<f:selectItem itemLabel="-- Seleccione --"/>
						<f:selectItems value="#{userRegister.userTipes}"/>
					</h:selectOneMenu>				
				</h:panelGrid>
				<h:commandButton value="Grabar" type="submit" action="#{userRegister.registerUser}" ></h:commandButton>
				<br><h:messages style="color: #FF0000"></h:messages>
				<br><h:outputLabel value="#{userRegister.messaje }" style="color: #FF0000"></h:outputLabel>
			</h:form>
	</center>
</f:view>
</body>
</html>