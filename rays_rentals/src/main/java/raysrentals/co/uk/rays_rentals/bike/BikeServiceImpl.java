package raysrentals.co.uk.rays_rentals.bike;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class BikeServiceImpl implements BikeService {
	@Autowired
	BikeDao bikeDao;

	@Override
	public Bike retrieveBike(Long id){
		Bike bike = bikeDao.getReference(id);
		return bike;
		
	}
}
