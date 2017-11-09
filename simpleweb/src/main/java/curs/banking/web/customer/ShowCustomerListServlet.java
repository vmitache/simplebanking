package curs.banking.web.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
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
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listCustomers.jsp");
			//!!!!
			request.setAttribute("cl", cl);
			dispatcher.forward(request,response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
