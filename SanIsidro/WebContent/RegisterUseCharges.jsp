<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Cobros</title>
</head>
<body>
<f:view>
	<h:form>
		<h:panelGrid border="0" columns="2">
			<h:commandButton action="#{registerUseChargesMB.registerUseCharges}" value="Registrar Cobros"/>
			<h:outputLabel value="#{registerUseChargesMB.message}"/>
		</h:panelGrid>
	</h:form>
</f:view>
</body>
</html>