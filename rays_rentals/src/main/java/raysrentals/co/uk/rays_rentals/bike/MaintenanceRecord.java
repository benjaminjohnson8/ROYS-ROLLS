package raysrentals.co.uk.rays_rentals.bike;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity()
@Proxy(lazy=false)
@Table(name = "maintenance_record")
public class MaintenanceRecord {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String faultDetails;
	
	@Column
	private String faultDate;
	
	@Column
	private String actionTaken;
	
	@Column
	private String actionDate;
	
	@JoinColumn(name = "bike_id")
	@ManyToOne()
	private Bike bike;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFaultDetails() {
		return faultDetails;
	}

	public void setFaultDetails(String faultDetails) {
		this.faultDetails = faultDetails;
	}

	public String getFaultDate() {
		return faultDate;
	}

	public void setFaultDate(String faultDate) {
		this.faultDate = faultDate;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getActionDate() {
		return actionDate;
	}

	public void setActionDate(String actionDate) {
		this.actionDate = actionDate;
	}

	public Bike getBike() {
		return bike;
	}

	public void setBike(Bike bike) {
		this.bike = bike;
	}

}
