package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

public interface MaintenanceService {

	public List<MaintenanceRecord> retrieveAllMaintenanceHistory();
	
	public List<MaintenanceRecord> getHistoryForBike(Long id);
	
	public MaintenanceRecord addRecord(MaintenanceRecord maintenanceRecord);
}

