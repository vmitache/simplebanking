package curs.banking.web.account;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.AccountService;
import curs.banking.business.CustomerService;
import curs.banking.model.Account;
import curs.banking.model.AccountType;
import curs.banking.model.Currency;

/**
 * Servlet implementation class AccountAddServlet
 */
@WebServlet("/accounts/add")
public class AccountAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccountAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String iban = request.getParameter("iban");
		String accType = request.getParameter("tc");
		AccountType at = AccountType.valueOf(accType);// inversul lui name()
		String currency = request.getParameter("currency");
		Currency cc = Currency.getById(Long.parseLong(currency));
		double sold = Double.parseDouble(request.getParameter("sold"));
		long custId = Long.parseLong(request.getParameter("custId"));
		Account account = new Account();
		account.setAccountType(at);
		account.setAmount(sold);
		CustomerService cs = new CustomerService();
		try {
			account.setBank(cs.getBank());
			account.setCurrency(cc);
			account.setIBAN(iban);
			account.setCustomer(cs.loadCustomerById(custId));
			Account newAccount = new AccountService().createAccount(account);
			request.setAttribute("account", newAccount);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/showAccount.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
