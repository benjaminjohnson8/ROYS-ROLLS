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

import raysrentals.co.uk.rays_rentals.customer.Customer;
@Entity()
@Table(name = "rental_record")
public class RentalRecord {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date rentDate;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date timeOut;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date timeBackDue;
	
	@Column
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date timeBackActual;
	
	@Column
	private float amountPaid;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne()
	private Customer customer;
	
	@JoinColumn(name = "bike_id", foreignKey = @ForeignKey(name = "rental_record_bike_fkey"))
	@ManyToOne()
	private Bike bike;

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	public Date getTimeBackDue() {
		return timeBackDue;
	}

	public void setTimeBackDue(Date timeBackDue) {
		this.timeBackDue = timeBackDue;
	}

	public Date getTimeBackActual() {
		return timeBackActual;
	}

	public void setTimeBackActual(Date timeBackActual) {
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
