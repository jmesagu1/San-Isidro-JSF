<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Búsqueda de Clientes</title>
<script type="text/javascript">
	function setEditId(id)
	{
		document.getElementById("form:editId").value = id;
	}
</script>
</head>
<body>
<f:view>
<jsp:include page="PrincipalTemplate.jsp"></jsp:include>
	<center>
	<h1>Búsqueda de Clientes</h1>
	<h:panelGrid border="1" columns="2">
					<h:outputLabel value="Documento: "></h:outputLabel>
					<h:inputText value="#{searchCustomerMB.userDni}"  >
						<f:convertNumber integerOnly="true"/>
					</h:inputText>
					<h:outputLabel value="Nombre:"></h:outputLabel>
					<h:inputText value="#{searchCustomerMB.userSearch.name }" ></h:inputText>
					<h:outputLabel value="Apellido:"></h:outputLabel>
					<h:inputText value="#{searchCustomerMB.userSearch.surname }" ></h:inputText>
					<h:outputLabel value="Teléfono 1:"></h:outputLabel>
					<h:inputText value="#{searchCustomerMB.userSearch.telephone1 }"></h:inputText>
					<h:outputLabel value="Teléfono 2:"></h:outputLabel>
					<h:inputText value="#{searchCustomerMB.userSearch.telephone2 }"></h:inputText>
					<h:outputLabel value="Tipo:"></h:outputLabel>
					<h:selectOneMenu value="#{searchCustomerMB.userTypeSelected }">
						<f:selectItem itemLabel="-- Seleccione --"/>
						<f:selectItems value="#{searchCustomerMB.userTipes}"/>
					</h:selectOneMenu>				
				</h:panelGrid><h:form>
				<h:commandButton value="Buscar" type="submit" action="#{searchCustomerMB.search}" ></h:commandButton>
			</h:form>
		<h:form id="form">
				<h:inputHidden value="#{searchCustomerMB.idCurrent}" id="editId"></h:inputHidden>
				<h:messages style="color: #FF0000"></h:messages>
				<br><h:outputLabel value="#{searchCustomerMB.message}" style="color: #FF0000"></h:outputLabel>
				<br><h:outputLabel value="#{searchCustomerMB.messageSuccess}" style="color: #0000FF"></h:outputLabel>
				<h:dataTable border="1" value="#{searchCustomerMB.customers}" var="customer">
					<h:column id="dni">
						<f:facet name="header">
							<h:outputText value="Documento"></h:outputText>
						</f:facet>
						<h:outputText value="#{customer.dni}" rendered="#{customer.editable}"></h:outputText>	
						<h:inputText value="#{customer.dni}" rendered="#{ not customer.editable}" required="true" requiredMessage="Ingrese un documento válido"></h:inputText>																						
					</h:column>
					<h:column id="name">
						<f:facet name="header">
							<h:outputText value="Nombre"></h:outputText>
						</f:facet>
						<h:outputText value="#{customer.name}" rendered="#{customer.editable}"></h:outputText>
						<h:inputText value="#{customer.name}" rendered="#{ not customer.editable}" required="true" requiredMessage="Ingrese un nombre válido"></h:inputText>	
					</h:column>
					<h:column id="lastname">
						<f:facet name="header">
							<h:outputText value="Apellido"></h:outputText>
						</f:facet>
						<h:outputText value="#{customer.surname}" rendered="#{customer.editable}"></h:outputText>
						<h:inputText value="#{customer.surname}" rendered="#{ not customer.editable}" required="true" requiredMessage="Ingrese un apellido válido"></h:inputText>	
					</h:column>
					<h:column id="tel1">
						<f:facet name="header">
							<h:outputText value="Teléfono 1"></h:outputText>
						</f:facet>
						<h:outputText value="#{customer.telephone1}" rendered="#{customer.editable}"></h:outputText>
						<h:inputText value="#{customer.telephone1}" rendered="#{ not customer.editable}"></h:inputText>	
					</h:column>
					<h:column id="tel2">
						<f:facet name="header">
							<h:outputText value="Teléfono 2" ></h:outputText>
						</f:facet>
						<h:outputText value="#{customer.telephone2}" rendered="#{customer.editable}"></h:outputText>
						<h:inputText value="#{customer.telephone2}" rendered="#{ not customer.editable}"></h:inputText>	
					</h:column>
					<h:column id="userType">						
						<f:facet name="header">
							<h:outputText value="Tipo de Usuario"></h:outputText>
						</f:facet>
						<h:selectOneMenu value="#{customer.type.id}"  rendered="#{ not customer.editable}">
							<f:selectItems value="#{searchCustomerMB.userTipes}"/>
						</h:selectOneMenu>
						<h:outputLabel value="#{customer.type.name}" rendered="#{customer.editable}"></h:outputLabel>
					</h:column>
					<h:column id="action">
						<f:facet name="header">
							<h:outputText value="Acción"/>
						</f:facet>
						<h:commandLink onclick="setEditId(#{customer.dni});" action="#{searchCustomerMB.editCustomer}" value="Editar" rendered="#{customer.editable}"/>
						<h:commandLink action="#{searchCustomerMB.updateCustomer}" value="Guardar" rendered="#{not customer.editable}"/>
					</h:column>					
				</h:dataTable>
				
				<br />  
                <h:commandButton value="Primero" action="#{searchCustomerMB.pageFirst}"                
                    disabled="#{searchCustomerMB.firstRow == 0}" />
                <h:commandButton value="Previo" action="#{searchCustomerMB.pagePrevious}"
                    disabled="#{searchCustomerMB.firstRow == 0}" />
                <h:commandButton value="Siguiente" action="#{searchCustomerMB.pageNext}"
                    disabled="#{searchCustomerMB.firstRow + searchCustomerMB.rowsPerPage >= searchCustomerMB.totalRows}" />
                <h:commandButton value="último" action="#{searchCustomerMB.pageLast}"
                    disabled="#{searchCustomerMB.firstRow + searchCustomerMB.rowsPerPage >= searchCustomerMB.totalRows}" />
                <h:outputText value="Página #{searchCustomerMB.currentPage} / #{searchCustomerMB.totalPages}" />
                <br />                    
				<br />  
                <h:outputLabel for="rowsPerPage" value="Filas por página" />
                <h:inputText id="rowsPerPage" value="#{searchCustomerMB.rowsPerPage}" size="3" maxlength="3" />
                <h:commandButton value="Cambiar" action="#{searchCustomerMB.pageFirst}" />
                <br><h:message for="rowsPerPage" errorStyle="color: red;" />
                				
			</h:form>
	</center>
</f:view>
</body>
</html>