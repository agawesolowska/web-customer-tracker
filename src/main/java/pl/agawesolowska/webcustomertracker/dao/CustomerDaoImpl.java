package pl.agawesolowska.webcustomertracker.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pl.agawesolowska.webcustomertracker.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Customer> getCustomers() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("from Customer order by firstName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public List<Customer> searchCustomersByName(String searchName) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query;
		if (searchName != null && searchName.trim().length() > 0) {
			query = currentSession.createQuery(
					"from Customer where lower(firstName) like :thisName or lower(lastName) like :thisName", Customer.class);
			query.setParameter("thisName", "%" + searchName.toLowerCase() + "%");
		} else {
			query = currentSession.createQuery("from Customer order by firstName", Customer.class);
		}
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer newCustomer) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.save(newCustomer);
	}

	@Override
	public void deleteCustomer(long customerId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Customer> query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", customerId);
		query.executeUpdate();
	}

}
