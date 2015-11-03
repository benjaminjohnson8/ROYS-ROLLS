package raysrentals.co.uk.rays_rentals.bike;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;
/**
 * 
 * @author ROakley
 * linking table for rental records and bike
 *
 */
@Entity
@Proxy(lazy = false)
@Table(name="bike_rental_record")
public class BikeRentalRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JoinColumn(name = "bike_id", foreignKey = @ForeignKey(name = "bike_rental_record_bike_fkey"))
	@ManyToOne(optional=false, cascade=CascadeType.REFRESH)
	private Bike bike;

	@JoinColumn(name = "rental_record_id", foreignKey = @ForeignKey(name = "bike_rental_record_rental_record_fkey"))
	@ManyToOne(optional=false)
	private RentalRecord rentalRecord;

	public Long getId() {
		return id;
	}
	
	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

	public RentalRecord getRentalRecord() {
		return rentalRecord;
	}

	public void setRentalRecord(RentalRecord rentalRecord) {
		this.rentalRecord = rentalRecord;
	}
}
