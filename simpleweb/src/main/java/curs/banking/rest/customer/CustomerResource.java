package curs.banking.rest.customer;

import java.util.Collection;

import javax.inject.Inject;

import curs.banking.business.CustomerService;
import curs.banking.model.Customer;
import curs.banking.rest.CustomerResourceIntf;

public class CustomerResource implements CustomerResourceIntf {
	@Inject
	private CustomerService mCustomerService;
	
	
	@Override
	public Collection<Customer> getCustomers() throws Exception {
		return mCustomerService.loadAllCustomers();
	}

	@Override
	public Customer getCustomer(long pId) throws Exception {
		return mCustomerService.loadCustomerById(pId);
	}

	@Override
	public Customer createCustomer(Customer pCustomer) throws Exception {
		return mCustomerService.createCustomer(pCustomer);
	}
}
