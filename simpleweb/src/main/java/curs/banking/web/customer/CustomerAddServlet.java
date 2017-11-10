package curs.banking.web.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.AddressService;
import curs.banking.business.CustomerService;
import curs.banking.model.Address;
import curs.banking.model.City;
import curs.banking.model.Customer;
import curs.banking.model.SexEnum;

/**
 * Servlet implementation class CustomerAddServlet
 */
@WebServlet("/customers/add")
public class CustomerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("Am ajuns la ADD");
		String name = request.getParameter("name");
		String svarsta = request.getParameter("varsta");
		int varsta = (svarsta == null) ? 20 : Integer.parseInt(svarsta);
		Customer cust = new Customer();
		cust.setVarsta(varsta);
		cust.setName(name);
		cust.setSex(SexEnum.M);
		cust.setSSN(request.getParameter("cnp"));
		Address addr = new Address();
		addr.setNumber("22");
		addr.setStreet("Popa Sapca");
		addr.setPostalCode("85555");
		AddressService as = new AddressService();
		CustomerService cs = new CustomerService();
		try {
			City c = as.loadCityById(1);
			addr.setCity(c);
			cust.setAddress(addr);
			cs.createCustomer(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("show/all");
		
	}

}
