package raysrentals.co.uk.rays_rentals.customer;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import raysrentals.co.uk.rays_rentals.account.Account;

@Entity
@Table(name = "address")
public class Address implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5455136287649053221L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String addressLine1;
	
	@Column
	private String addressLine2;
	
	@Column 
	private String postcode;
		
	@OneToMany(mappedBy = "address")
	private Set<Customer> customers = new HashSet<Customer>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


}
