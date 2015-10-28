package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Search;

import raysrentals.co.uk.lib.dao.HibernateJPABase;

@Service
@Transactional
public class MaintenanceServiceImpl extends HibernateJPABase<MaintenanceRecord, Long> implements MaintenanceService {

	@Autowired
	BikeService bikeservice;
	@Override
	public List<MaintenanceRecord> retrieveAllMaintenanceHistory() {

		return super.findAll();
	}

	@Override
	public MaintenanceRecord addRecord(MaintenanceRecord maintenanceRecord) {
		return super.save(maintenanceRecord);
	}
	
	@Override
	public List<MaintenanceRecord> retrieveAllMaintenanceHistoryForBike(Long bikeId){
		Search maintenanceSearch = new Search(MaintenanceRecord.class);
		Bike bike = bikeservice.retrieveBike(bikeId);
		maintenanceSearch.addFilterEqual("bike", bike);
		List<MaintenanceRecord> recordRetrieved = super.search(maintenanceSearch);
		return recordRetrieved;	
	}
	

}
