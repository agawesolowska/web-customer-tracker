package pl.agawesolowska.webcustomertracker.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.agawesolowska.webcustomertracker.dao.CustomerDao;
import pl.agawesolowska.webcustomertracker.entity.Customer;

/**
 * Service layer that simply delegates calls to the Customer Data Access Object.
 * 
 * @author Aga
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public List<Customer> searchCustomersByName(String searchName) {
		return customerDao.searchCustomersByName(searchName);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer newCustomer) {
		customerDao.saveCustomer(newCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(long customerId) {
		customerDao.deleteCustomer(customerId);
	}

}
