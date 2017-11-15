<%@page import="java.util.Collection"%>
<%@page import="curs.banking.model.Account"%>
<%@page import="curs.banking.business.AccountService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>Adauga plata</H1>
	<hr>
	Date platitor:<br>
	<%
	   String saccid = request.getParameter("accountId");
	   AccountService as = new AccountService();
	   Account acc = as.loadAccountById(Long.parseLong(saccid));
	   Collection<Account> accList = as.loadPossibleAccountsForPaymentFrom(acc);
	 %>
	 IBAN: <%= acc.getIBAN() %><br>
	 Nume: <%= acc.getCustomer().getName() %><br>
	 Sold: <%= acc.getAmount() %>
	 Valuta: <%= acc.getCurrency() %><br>
	 <hr>
	 	<FORM action="transactions/add" method="post">
	 	   Suma: <input type="text" name="amount" value="0">
	 	   <select name="accBeneficiar">
	 	     <%
	 	        for(Account a : accList) {
	 	      %>
	 	      	<option value="<%= a.getId() %>"><%= a.getIBAN() %>/<%= a.getCustomer().getName() %>
	 	      <%
	 	      }
	 	       %>
	 	   </select>
	 	   <input type="hidden" name="accPlatitor" value="<%= saccid %>">
	 	   <input type="submit" value="Confirmare plata">
	 </FORM>
</body>
</html>