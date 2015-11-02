package raysrentals.co.uk.rays_rentals.customer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import raysrentals.co.uk.rays_rentals.bike.RentalRecord;



@Entity
@Table(name = "customer")
//version controlled
public class Customer implements java.io.Serializable {
	/**
	 * randomly generateed
	 */
	private static final long serialVersionUID = 6064857589999072158L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String phoneNo;
	
	@ManyToOne
	@JoinColumn(name="address_id", foreignKey=@ForeignKey(name="accounts_address_fkey"))
	private Address address;
	
	@OneToMany(mappedBy="customer")
	@Fetch (FetchMode.SELECT)
	private List<RentalRecord> rentalRecords = new ArrayList<RentalRecord>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	

}
