<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<body>
<h2>Welcome to our banking APP </h2>

<h3><%= request.getUserPrincipal().getName() %>
 <a href="<%= request.getContextPath() %>/logout">Logout </a>
</h3>
<hr>
<a href="customers/show/all">Clientii nostri</a>

<%
  if(request.isUserInRole("bankmanager")) {
  
%>
<a href="accounts/show/all">Conturile noastre</a>
<a href="transactions/show/all">Tranzactiile noastre</a>
<%
  }
%>
</body>
</html>
