package raysrentals.co.uk.rays_rentals.bike;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="disposal_details")
public class DisposalDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String dealerName;
	
	@Column
	private Date saleDate;
	
	@Column
	private Float salePrice;

	@Column
	private String dealerAddressLine1;
	
	@Column
	private String dealerAddressLine2;
	
	@Column 
	private String dealerPostcode;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Float getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Float salePrice) {
		this.salePrice = salePrice;
	}

}
