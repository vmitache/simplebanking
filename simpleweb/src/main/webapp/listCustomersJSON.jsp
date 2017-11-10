<%@page import="curs.banking.model.Customer"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8"%>
[
   <%
      String sep = "";
			Collection<Customer> custList = (Collection<Customer>) request.getAttribute("customers");
			for (Customer cust : custList) {
		%> 
			 <%= sep %>
		   {
		     "name":"<%= cust.getName() %>",
		     "varsta": <%= cust.getVarsta() %>,
		     "sex": "<%= cust.getSex().name() %>"
		   }
			
			<%
			   sep = ",";
			}
			%>

]
