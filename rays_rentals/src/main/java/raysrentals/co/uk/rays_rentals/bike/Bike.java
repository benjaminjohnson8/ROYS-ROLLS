package raysrentals.co.uk.rays_rentals.bike;

import java.time.LocalDateTime;
import java.util.Currency;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity()
@Table(name = "bike_record")
//extends versioncontrolleed?
public class Bike implements java.io.Serializable   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 825004720238685773L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String model;
	
	@Column
	private String manufacturer;
	
	@Column
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDateTime")
	private LocalDateTime purchaseDate;
	
	@Column
	private Float price;
	
	@Column
	private Boolean unavailable;
	//TODO the rest

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setUnavailable(Boolean unavailable) {
		this.unavailable = unavailable;
	}
	
	public boolean isUnavaiable()
	{
		return unavailable;
	}
}
