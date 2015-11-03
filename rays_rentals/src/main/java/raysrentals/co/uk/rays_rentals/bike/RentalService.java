package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

public interface RentalService {
	
	public RentalRecord createOrUpdateRentalRecord(RentalRecord rentalRecord);

	public List<RentalRecord> retrieveAllRentalRecord();

	public RentalRecord getSingleRentalRecord(Long id);

}
