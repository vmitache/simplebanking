<%@page import="curs.banking.model.TransactionPair"%>
<%@page import="curs.banking.model.Transaction"%>
<%@page import="curs.banking.model.Account"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transaction list</title>
</head>
<body>
	<H1>Lista tranzactii</H1>
	<a href="<%=request.getContextPath()%>">HOME</a>
	<!-- <a href="/banking">HOME</a>  -->

	<TABLE border="2">
		<TR>
			<TH>IBAN PLATITOR</TH>
			<TH>NUME PLATITOR</TH>
			<TH>IBAN BENEFICIAR</TH>
			<TH>NUME BENEFICIAR</TH>
			<TH>VALUTA</TH>
			<TH>SUMA</TH>
			<TH>DATA</TH>
			
		</TR>
		<%
			Collection<TransactionPair> accList = (Collection<TransactionPair>) request.getAttribute("transactions");
			for (TransactionPair acc : accList) {
		%>
		 <TR>
			<TD><%=acc.getDebitTransaction().getAccount().getIBAN()%></TD>
			<TD><%=acc.getDebitTransaction().getAccount().getCustomer().getName()%></TD>
			<TD><%=acc.getCreditTrasaction().getAccount().getIBAN()%></TD>
			<TD><%=acc.getCreditTrasaction().getAccount().getCustomer().getName()%></TD>
			<TD><%=acc.getDebitTransaction().getAccount().getCurrency()%></TD>
			<TD><%=acc.getDebitTransaction().getAmount()%></TD>
			<TD><%=acc.getDebitTransaction().getTransactionTime()%></TD>

		</TR>
		
		
		<%
			}
		%>
	</TABLE>
	<BR>

</body>
</html>