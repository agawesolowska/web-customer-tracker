package pl.agawesolowska.webcustomertracker.service;

import java.util.List;

import pl.agawesolowska.webcustomertracker.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public List<Customer> searchCustomersByName(String searchName);
	
	public void saveCustomer(Customer newCustomer);

	public void deleteCustomer(long customerId);

}
