package curs.banking.web.customer;

import java.io.IOException;
import java.sql.SQLException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.AddressService;

/**
 * Servlet implementation class CustomerPrepareAddServlet
 */
@WebServlet("/cpa")
public class CustomerPrepareAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private AddressService mAddressService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerPrepareAddServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("cities", mAddressService.loadCities());
			RequestDispatcher rd = request.getServletContext().getRequestDispatcher("/addCustomer.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
