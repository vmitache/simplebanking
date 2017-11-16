package curs.banking.web.account;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.AccountService;
import curs.banking.db.utils.DataSourceConnectionFactory;
import curs.banking.model.Account;

/**
 * Servlet implementation class ShowAccountListServlet
 */
@WebServlet("/accounts/show/all")
public class ShowAccountListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAccountListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!request.isUserInRole("bankmanager")) {
			response.sendRedirect(request.getContextPath());
			return;
		}
		AccountService accService = new AccountService(DataSourceConnectionFactory.factory());
		try {
			Collection<Account> al = accService.loadAllAccounts();
			request.setAttribute("accounts", al);

			String jspName = "/listAccounts.jsp";

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jspName);
			// !!!!
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
