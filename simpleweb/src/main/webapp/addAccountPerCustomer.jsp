<%@page import="curs.banking.model.Currency"%>
<%@page import="curs.banking.model.AccountType"%>
<%@page import="curs.banking.model.Account"%>
<%@page import="java.util.Collection"%>
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
		Customer cust = (Customer)request.getAttribute("customer");
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
			Collection<Account> accounts = (Collection<Account>)request.getAttribute("accounts");
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
			<option value="<%=at.name()%>"><%=at.name()%></option>

			<%
				}
			%>
		</select> Valuta : <select name="currency">
			<%
				for (Currency cc : Currency.values()) {
			%>
			<option value="<%=cc.getId()%>"><%=cc.name()%></option>

			<%
				}
			%>
		</select> <br> IBAN: <input type="text" name="iban" maxlength="32">
		<br> Sold: <input type="text" name="sold" maxlength="6" value="0">
		<br> <input type="hidden" name="custId" value="<%=request.getAttribute("cid")%>">
		<input type="submit" value="Adauga">
	</FORM>
</body>
</html>