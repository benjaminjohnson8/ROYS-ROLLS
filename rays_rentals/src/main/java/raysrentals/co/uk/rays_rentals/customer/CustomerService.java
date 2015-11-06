package raysrentals.co.uk.rays_rentals.customer;

import java.util.List;

public interface CustomerService {

	public Customer retrieveCustomer(Long id);

	public List<Customer> retrieveAllCustomers();

	public Customer createOrUpdateCustomer(Customer customer);

}
