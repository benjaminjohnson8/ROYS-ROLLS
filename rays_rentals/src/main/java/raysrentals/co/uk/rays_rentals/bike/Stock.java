package raysrentals.co.uk.rays_rentals.bike;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity()
@Table(name = "stock")
@Proxy(lazy=false)
public class Stock {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String partName;
	
	@Column
	private long numberOfStock;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public long getNumberOfStock() {
		return numberOfStock;
	}

	public void setNumberOfStock(long numberOfStock) {
		this.numberOfStock = numberOfStock;
	}

}
