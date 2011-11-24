<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/themes/base/jquery-ui.css" type="text/css" media="all" />
<link rel="stylesheet" href="http://static.jquery.com/ui/css/demo-docs-theme/ui.theme.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js" type="text/javascript"></script>
<title>Registrar Contador</title>
<script type="text/javascript">
	$(function() {
		$( "#dateBought" ).datepicker({ dateFormat: 'dd/mm/yy' });
	});
	
	function updateDate(field) {
		var strDate = document.getElementById(field).value;
		document.getElementById("form:" + field).value = strDate;
	}
</script>
</head>
<body>
<f:view>
<h:form id="form">
	<h:inputHidden id="dateBought" value="#{createMeterMB.strDateBought}"></h:inputHidden>
	<h:panelGrid columns="2">
		<h:outputLabel value="Número de Serie"/>
		<h:inputText value="#{createMeterMB.serie}"/>
		<h:outputLabel value="Precio"/>
		<h:inputText value="#{createMeterMB.price}" converter="javax.faces.Double" converterMessage="El precio debe ser numérico">
			<f:validateDoubleRange minimum="0"/>
		</h:inputText>
		<h:outputLabel value="Número de Cuotas"/>
		<h:inputText value="#{createMeterMB.payNumber}"/>
		<h:outputLabel value="Metros Máximos"/>
		<h:inputText value="#{createMeterMB.maxMeters}"/>
		<h:outputLabel value="Fecha de Compra"/>
		<input id="dateBought" onchange="updateDate('dateBought');">
		<h:outputLabel value="Comentario"/>
		<h:inputTextarea value="#{createMeterMB.comments}"/>
		<h:commandButton value="Registrar" action="#{createMeterMB.createMeter}"/>
	</h:panelGrid>
	<h:outputText style="color:red;" value="#{createMeterMB.message}"/>
</h:form>
</f:view>
</body>
</html>