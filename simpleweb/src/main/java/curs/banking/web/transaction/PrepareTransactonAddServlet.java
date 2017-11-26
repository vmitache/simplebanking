package curs.banking.web.transaction;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.AccountService;
import curs.banking.model.Account;

/**
 * Servlet implementation class PrepareTransactonAddServlet
 */
@WebServlet("/pta")
public class PrepareTransactonAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private AccountService mAccountService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrepareTransactonAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String saccid = request.getParameter("accountId");
		try {
			Account acc = mAccountService.loadAccountById(Long.parseLong(saccid));
			request.setAttribute("account", acc);
			request.setAttribute("accounts", mAccountService.loadPossibleAccountsForPaymentFrom(acc));
			RequestDispatcher rd = request.getRequestDispatcher("/addPaymentPerAccount.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
