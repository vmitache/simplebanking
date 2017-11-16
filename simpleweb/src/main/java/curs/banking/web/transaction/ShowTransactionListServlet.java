package curs.banking.web.transaction;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.TransactionService;
import curs.banking.db.utils.DataSourceConnectionFactory;
import curs.banking.model.TransactionPair;

/**
 * Servlet implementation class ShowTransactionListServlet
 */
@WebServlet("/transactions/show/all")
public class ShowTransactionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTransactionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TransactionService transactionService = new TransactionService(DataSourceConnectionFactory.factory());
		try {
			Collection<TransactionPair> tl = transactionService.loadAllTransactionPairs();
			request.setAttribute("transactions", tl);

			
			String jspName = "/listTransactions.jsp";
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jspName);
			// !!!!
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
