package raysrentals.co.uk.rays_rentals.bike;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import raysrentals.co.uk.rays_rentals.customer.Address;

public class DisposalDetails {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String dealerName;
	
	@Column
	private Address dealerAddress;
	
	@Column
	private Date saleDate;
	
	@Column
	private Float salePrice;

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

	public Address getDealerAddress() {
		return dealerAddress;
	}

	public void setDealerAddress(Address dealerAddress) {
		this.dealerAddress = dealerAddress;
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
