package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Service;

import raysrentals.co.uk.lib.dao.HibernateJPABase;

@Service
@Transactional
public class MaintenanceServiceImpl extends HibernateJPABase<MaintenanceRecord, Long> implements MaintenanceService {

	@Override
	public List<MaintenanceRecord> retrieveAllMaintenanceHistory() {

		return super.findAll();
	}

	@Override
	public List<MaintenanceRecord> getHistoryForBike(Long id) {
		return null;
	}

	@Override
	public MaintenanceRecord addRecord(MaintenanceRecord maintenanceRecord) {
		return super.save(maintenanceRecord);
	}

	

}
