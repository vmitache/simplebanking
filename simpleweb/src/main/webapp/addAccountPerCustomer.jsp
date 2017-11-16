<%@page import="curs.banking.db.utils.DataSourceConnectionFactory"%>
<%@page import="curs.banking.model.Currency"%>
<%@page import="curs.banking.model.AccountType"%>
<%@page import="curs.banking.business.AccountService"%>
<%@page import="curs.banking.model.Account"%>
<%@page import="java.util.Collection"%>
<%@page import="curs.banking.business.CustomerService"%>
<%@page import="curs.banking.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Adauga cont</h1>
	<%
		String scid = request.getParameter("custId");
		Customer cust = new CustomerService(DataSourceConnectionFactory.factory()).loadCustomerById(Long.parseLong(scid));
	%>
	<h2>Client</h2>
	<br>
	<%=cust.getName()%>
	,
	<%=cust.getSSN()%>
	<hr>
	<h2>Informatii conturi client</h2>

	<TABLE>
		<TR>
			<TH>IBAN</TH>
			<TH>TIP</TH>
			<TH>VALUTA</TH>
		</TR>
		<%
			Collection<Account> accounts = new AccountService(DataSourceConnectionFactory.factory()).loadAccountsPerCustomerId(Long.parseLong(scid));
			for (Account acc : accounts) {
		%>
		<tr>
			<td><%=acc.getIBAN()%></td>
			<td><%=acc.getAccountType()%></td>
			<td><%=acc.getCurrency()%></td>
		</tr>
		<%
			}
		%>
	</TABLE>
	<hr>
	<FORM action="accounts/add" method="post">
		Tip cont : <select name="tc">
			<%
				for (AccountType at : AccountType.values()) {
			%>
			<option value="<%= at.name() %>"><%= at.name() %></option>

			<%
				}
			%>
			</select>
			Valuta : <select name="currency">
			<%
				for (Currency cc : Currency.values()) {
			%>
				<option value="<%= cc.getId() %>"><%=cc.name()%></option>

			<%
				}
			%>
			</select>
			<br>
		IBAN: <input type="text" name="iban" maxlength="32">
		<br>
		Sold: <input type="text" name="sold" maxlength="6" value="0">
		<br>
		<input type="hidden" name="custId" value="<%= scid %>">
		<input type="submit" value="Adauga">
	</FORM>
</body>
</html>