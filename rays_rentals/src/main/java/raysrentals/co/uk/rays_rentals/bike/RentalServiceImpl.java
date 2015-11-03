package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import raysrentals.co.uk.lib.dao.HibernateJPABase;

@Service
@Transactional
public class RentalServiceImpl extends HibernateJPABase<RentalRecord, Long> implements RentalService {
	
	@Override
	public RentalRecord createOrUpdateRentalRecord(RentalRecord rentalRecord){
		return super.save(rentalRecord);
	}

	@Override
	public List<RentalRecord> retrieveAllRentalRecord(){
		return super.findAll();
	}
	@Override
	public RentalRecord getSingleRentalRecord(Long id){
		return super.getReference(id);
	}

}
