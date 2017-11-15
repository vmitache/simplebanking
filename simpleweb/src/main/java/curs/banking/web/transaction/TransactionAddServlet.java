package curs.banking.web.transaction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.TransactionService;

/**
 * Servlet implementation class TransactionAddServlet
 */
@WebServlet("/transactions/add")
public class TransactionAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String samount = request.getParameter("amount");
		String saccpl = request.getParameter("accPlatitor");
		String saccbn = request.getParameter("accBeneficiar");
		TransactionService ts = new TransactionService();
		try {
			if(ts.transferMoney(Long.parseLong(saccbn),Long.parseLong(saccpl), Double.parseDouble(samount))) {
				response.sendRedirect("show/all");
			} else {
				response.getWriter().println("<html><body>Tranzactie eronata<BR>");
				response.getWriter().println(
						
						
						"<a href='" + request.getContextPath() + "'>HOME</a></body></html>");

			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
