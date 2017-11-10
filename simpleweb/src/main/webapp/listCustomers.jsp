<%@page import="curs.banking.model.Customer"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Customer list</title>
</head>
<body>
	<H1>Lista clienti</H1>
	<a href="<%= request.getContextPath() %>">HOME</a>
		<!-- <a href="/banking">HOME</a>  -->
	
	<TABLE border="2">
		<TR>
			<TH>Nume</TH>
			<TH>CNP</TH>
			<TH>Oras</TH>
			<TH>Varsta</TH>
			<TH>Sex</TH>
		</TR>
		<%
			Collection<Customer> custList = (Collection<Customer>) request.getAttribute("customers");
			for (Customer cust : custList) {
		%>
		<TR>
			<TD><%=cust.getName()%></TD>
			<TD><%=cust.getSSN()%></TD>
			<TD><%=cust.getAddress().getCity().getName()%></TD>
			<TD><%= cust.getVarsta() %></TD>
			<TD><%= cust.getSex() %></TD>
		</TR>
			<%
				}
			%>
			</TABLE>
		<BR>
		<a href="<%= request.getContextPath() %>/addCustomer.jsp">Adauga client</a>
</body>
</html>