package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

public interface BikeService  {

	public Bike retrieveBike(Long id);

	public Bike createOrUpdateBike(Bike bike);

	public List<Bike> retrieveAllBike();
	
	public void removeBikeById(Long id);

	public List<Bike> getAllAvailableBikes();

}
