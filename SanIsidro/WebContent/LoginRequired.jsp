<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login es requerido</title>
</head>
<body>
<f:view>
<center>
<img src="images/logo.png">
	<h:form>
		<h1>Por favor auntentíquese en nuestro sistema </h1>
		<h:outputLink value="Login.jsp">Login</h:outputLink>
	</h:form>
</center>
</f:view>
</body>
</html>