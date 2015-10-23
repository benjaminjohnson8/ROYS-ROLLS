package raysrentals.co.uk.rays_rentals.bike;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Proxy;

@Entity()
@Table(name = "bike_record")
@Proxy(lazy=false)
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
	private Date purchaseDate;
	
	@Column
	private Float price;
	
	@Column
	private Boolean available;

	@Column(nullable=false, updatable=false)
	@Enumerated(EnumType.STRING)
	private BikeClassification classification;
	
	@Column(nullable=false, updatable=false)
	@Enumerated(EnumType.STRING)
	private BikeSize size;
	
	@OneToMany(mappedBy="bike", cascade=CascadeType.ALL)
	@Fetch (FetchMode.SELECT)
	private List<MaintenanceRecord> maintenanceRecords = new ArrayList<MaintenanceRecord>();

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

	public Date getPurchaseDate() {

		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	public boolean isAvailable()
	{
		return available;
	}
	
	public BikeClassification getClassification() {
		return classification;
	}

	public void setClassification(BikeClassification classification) {
		this.classification = classification;
	}
	
	public BikeSize getSize() {
		return size;
	}

	public void setSize(BikeSize size) {
		this.size = size;
	}

}
