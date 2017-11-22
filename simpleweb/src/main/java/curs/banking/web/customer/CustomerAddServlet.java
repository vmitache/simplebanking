package curs.banking.web.customer;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curs.banking.business.AddressService;
import curs.banking.business.CustomerService;
import curs.banking.db.utils.DataSourceConnectionFactory;
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
       
	@Inject
	private CustomerService mCustomerService;
	@Inject
	private AddressService mAddressService;
	
	
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
		if("M".equals(request.getParameter("sex"))) {
			cust.setSex(SexEnum.M);
		} else {
			cust.setSex(SexEnum.F);

		}
		cust.setSSN(request.getParameter("cnp"));
		Address addr = new Address();
		addr.setNumber(request.getParameter("numar"));
		addr.setStreet(request.getParameter("strada"));
		addr.setPostalCode(request.getParameter("cp"));
		System.out.println("City is:" + request.getParameter("city"));
		if(request.getParameter("city") == null) {
			// ???? MA INTORC IN PAGINA CU EROARE
		}
		try {
			long cityId = Long.parseLong(request.getParameter("city"));
		} catch(NumberFormatException ex) {
			ex.printStackTrace();
			// ???? MA INTORC IN PAGINA CU EROARE
		}
		try {
			City c = mAddressService.loadCityById(Long.parseLong(request.getParameter("city")));
			addr.setCity(c);
			cust.setAddress(addr);
			mCustomerService.createCustomer(cust);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("show/all");
		
	}

}
