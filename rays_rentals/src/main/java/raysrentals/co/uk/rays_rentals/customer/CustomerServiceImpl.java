package raysrentals.co.uk.rays_rentals.customer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import raysrentals.co.uk.lib.dao.HibernateJPABase;
@Service
@Transactional
public class CustomerServiceImpl extends HibernateJPABase<Customer, Long> implements CustomerService{
	@Override
	public Customer retrieveCustomer(Long id){
		return super.getReference(id);
	}
	@Override
	public List<Customer> retrieveAllCustomers(){
		return super.findAll();
	}
	
	@Override
	public Customer createOrUpdateCustomer(Customer customer){
		return super.save(customer);
	}

}
