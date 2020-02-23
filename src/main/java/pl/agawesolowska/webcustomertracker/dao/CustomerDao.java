package pl.agawesolowska.webcustomertracker.dao;

import java.util.List;

import pl.agawesolowska.webcustomertracker.entity.Customer;

public interface CustomerDao {

	public List<Customer> getCustomers();

	public List<Customer> searchCustomersByName(String searchName);

	public void saveCustomer(Customer newCustomer);

	public void deleteCustomer(long customerId);

}
