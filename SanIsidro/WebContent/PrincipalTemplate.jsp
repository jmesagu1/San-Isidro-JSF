<%@page import="com.sanisidro.to.UserLoginTO"%>
<center>
<img src="images/logo.png">
</center>
<%
if (session.getAttribute("user") != null)
{
%>
<div align="right"><a href="Logout.jsp" >Salida Segura</a>
<br>
	<%
		UserLoginTO user = (UserLoginTO)session.getAttribute("user");
		String p = "";
	
		if (user.getAdmin())
		{
			p = "HomeAdmin.jsp";
		}
		else
		{
			p = "UserHome.jsp";
		}
	
	%>
	<a href="<%= p %>">Página Principal</a>
	</div>
	<%
	}
	else
	{
		response.sendRedirect("/LoginRequired.jsp");
		return;				
	}
 %>


