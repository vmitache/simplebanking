<%@page import="curs.banking.model.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Afisare cont</h1>
		<a href="<%=request.getContextPath()%>">HOME</a>
	
	
	<%
	   Account acc = (Account)request.getAttribute("account");
	 %>
	
	Banca: <%= acc.getBank().getName()%><br>
		Client: <%= acc.getCustomer().getName()%><br>
		IBAN: <%= acc.getIBAN()%><br>
			SOLD: <%= acc.getAmount()%><br>
				TIP: <%= acc.getAccountType()%><br>
					VALUTA: <%= acc.getCurrency()%><br>
	
</body>
</html>