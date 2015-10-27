package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import raysrentals.co.uk.lib.dao.HibernateJPABase;

@Service
@Transactional
public class MaintainanceServiceImpl extends HibernateJPABase<MaintenanceRecord, Long> implements MaintenanceService {

	@Override
	public List<MaintenanceRecord> retrieveAllMaintenanceHistory() {

		return super.findAll();
	}

}
