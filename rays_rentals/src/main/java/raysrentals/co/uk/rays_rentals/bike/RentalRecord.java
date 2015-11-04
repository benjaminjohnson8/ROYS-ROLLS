package raysrentals.co.uk.rays_rentals.bike;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import org.hibernate.annotations.Proxy;

import raysrentals.co.uk.rays_rentals.customer.Customer;
@Entity()
@Table(name = "rental_record")
@Proxy(lazy=false)
public class RentalRecord {
	
	@Id
	@GeneratedValue
	private Long id;
	//TODO:Change to dates
	@Column
	private String rentDate;
	
	@Column
	private String timeOut;
	
	@Column
	private String timeBackDue;
	
	@Column
	private String timeBackActual;
	
	@Column
	private float amountPaid;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne()
	private Customer customer;
	
	@JoinColumn(name = "bike_id", foreignKey = @ForeignKey(name = "rental_record_bike_fkey"))
	@ManyToOne()
	private Bike bike;

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(String timeOut) {
		this.timeOut = timeOut;
	}

	public String getTimeBackDue() {
		return timeBackDue;
	}

	public void setTimeBackDue(String timeBackDue) {
		this.timeBackDue = timeBackDue;
	}

	public String getTimeBackActual() {
		return timeBackActual;
	}

	public void setTimeBackActual(String timeBackActual) {
		this.timeBackActual = timeBackActual;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public float getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(float amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Long getId() {
		return id;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

}
