package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import com.googlecode.genericdao.search.SearchResult;

public interface RentalService {
	
	public RentalRecord createOrUpdateRentalRecord(RentalRecord rentalRecord);

	public List<RentalRecord> retrieveAllRentalRecord();

	public RentalRecord getSingleRentalRecord(Long id);

	public SearchResult<RentalRecord> search(RentalSearch deviceSearch);


}
