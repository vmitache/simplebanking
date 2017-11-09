package curs.banking.web.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.CustomerService;
import curs.banking.model.Customer;

/**
 * Servlet implementation class ShowCustomerListServlet
 */
@WebServlet("/customers/show/all")
public class ShowCustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowCustomerListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerService custService = new CustomerService();
		try {
			Collection<Customer> cl = custService.loadAllCustomers();
			PrintWriter w = response.getWriter();
			w.println("<!DOCTYPE html><head></head><body>");
			////
			w.println("<H1>Lista clienti</H1>");
			w.println("<TABLE><TR><TH>Nume</TH><TH>CNP</TH><TH>Oras</TH><TH>Varsta</TH><TH>Sex</TH></TR>");
			for(Customer cust : cl) {
				w.append("<TR><TD>").append(cust.getName())
				 .append("</TD><TD>")
				 .append(cust.getSSN())
				 .append("</TD><TD>")
				 .append(cust.getAddress().getCity().getName())
				 .append("</TD><TD>")
				 .append("" + cust.getVarsta())
				 .append("</TD><TD>")
				 .append(cust.getSex().name())
				 .append("</TD></TR>");

			}
			w.println("</TABLE>");
			w.print("</body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
