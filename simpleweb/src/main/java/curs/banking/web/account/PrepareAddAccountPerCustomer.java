package curs.banking.web.account;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.AccountService;
import curs.banking.business.CustomerService;

/**
 * Servlet implementation class PrepareAddAccountPerCustomer
 */
@WebServlet("/paac")
public class PrepareAddAccountPerCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CustomerService mCustomerService;
	@Inject
	private AccountService mAccountService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrepareAddAccountPerCustomer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String scid = request.getParameter("custId");
		try {
			request.setAttribute("customer", mCustomerService.loadCustomerById(Long.parseLong(scid)));
			request.setAttribute("accounts", mAccountService.loadAccountsPerCustomerId(Long.parseLong(scid)));
			request.setAttribute("cid", scid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/addAccountPerCustomer.jsp");
		rd.forward(request, response);
	}

}
