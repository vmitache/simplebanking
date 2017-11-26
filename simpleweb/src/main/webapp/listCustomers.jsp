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
	<a href="<%=request.getContextPath()%>">HOME</a>
	<!-- <a href="/banking">HOME</a>  -->

	<TABLE border="2">
		<TR>
			<TH>Nume</TH>
			<TH>CNP</TH>
			<TH>Varsta</TH>
			<TH>Sex</TH>
			<TH>Oras</TH>
			<TH>Strada</TH>
			<TH>Numar</TH>
			<TH>Cod postal</TH>
			<TH>Accounts</TH>
		</TR>
		<%
			Collection<Customer> custList = (Collection<Customer>) request.getAttribute("customers");
			for (Customer cust : custList) {
		%>
		<TR>
			<TD><%=cust.getName()%></TD>
			<TD><%=cust.getSSN()%></TD>
			<TD><%=cust.getVarsta()%></TD>
			<TD><%=cust.getSex()%></TD>
			<TD><%=cust.getAddress().getCity().getName()%></TD>
			<TD><%=cust.getAddress().getStreet()%></TD>
			<TD><%=cust.getAddress().getNumber()%></TD>
			<TD><%=cust.getAddress().getPostalCode()%></TD>
			<TD>
				<form action="<%= request.getContextPath() %>/paac">
				  <input type="hidden" value="<%= cust.getId() %>" name="custId">
				  <input type="submit" value="Adauga cont">
				</form>
			</TD>
		</TR>
		<%
			}
		%>
	</TABLE>
	<BR>
	<a href="<%=request.getContextPath()%>/cpa">Adauga
		client</a>
</body>
</html>