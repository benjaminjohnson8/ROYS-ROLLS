package raysrentals.co.uk.rays_rentals;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity()
@Table(name = "bike_reccord")
public class Bike implements java.io.Serializable  {

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
	@Type(type="org.jadira.usertype.dateandtime.threeten.PersistentLocalDate")
	private LocalDate purchaseDate;
	
	@Column
	private Float price;
	
	//TODO the rest
	
}
