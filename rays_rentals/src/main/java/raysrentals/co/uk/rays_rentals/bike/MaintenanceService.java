package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

public interface MaintenanceService {

	public List<MaintenanceRecord> retrieveAllMaintenanceHistory();
		
	public MaintenanceRecord addRecord(MaintenanceRecord maintenanceRecord);

	public List<MaintenanceRecord> retrieveAllMaintenanceHistoryForBike(Long bikeId);
}

