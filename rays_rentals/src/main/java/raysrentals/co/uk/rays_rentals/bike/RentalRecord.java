package raysrentals.co.uk.rays_rentals.bike;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import raysrentals.co.uk.rays_rentals.customer.Customer;

public class RentalRecord {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private Bike bikeRented;

	@Column
	private Date rentDate;
	
	@Column
	private Date timeOut;
	
	@Column
	private Date timeBackDue;
	
	@Column
	private Date timeBackActual;
	
	@Column
	private Customer customer;
	
	@Column
	private float amountPaid;
}
