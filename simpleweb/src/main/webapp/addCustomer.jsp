<%@page import="curs.banking.business.AddressService"%>
<%@page import="curs.banking.business.CustomerService"%>
<%@page import="curs.banking.model.City"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>Adaugare client</H1>
	<HR>
	<FORM method="post" action="customers/add">
		Nume:<input type="text" name="name" maxlength="64"> <br>
		Varsta:<input type="text" name="varsta" maxlength="2"> <br>
		Sex: <input type="radio" name="sex" value="M" checked="checked">Male
		<input type="radio" name="sex" value="F">Female <br> CNP:<input
			type="text" name="cnp" maxlength="16"> <br> Strada: <input
			type="text" name="strada" maxlength="32"> <br> Numar: <input
			type="text" name="numar" maxlength="6"> <br> Cod postal:
		<input type="text" name="cp" maxlength="12"> <br> Oras: <select
			name="city">
		
			<%
				//AddressService as = (AddressService) pageContext.findAttribute("addressService");
				Collection<City> cities = (Collection<City>)request.getAttribute("cities");
				for (City city : cities) {
			%>
			<option value="<%=city.getId()%>"><%=city.getName()%></option>

			<%
				}
			%>
		</select> <br> <input type="submit" value="Salveaza">
	</FORM>

</body>
</html>