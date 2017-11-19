package curs.banking.rest.customer;

import java.util.Collection;

import curs.banking.business.CustomerService;
import curs.banking.db.utils.DataSourceConnectionFactory;
import curs.banking.model.Customer;
import curs.banking.rest.CustomerResourceIntf;

public class CustomerResource implements CustomerResourceIntf {
	@Override
	public Collection<Customer> getCustomers() throws Exception {
		return new CustomerService(DataSourceConnectionFactory.factory()).loadAllCustomers();
	}
}
