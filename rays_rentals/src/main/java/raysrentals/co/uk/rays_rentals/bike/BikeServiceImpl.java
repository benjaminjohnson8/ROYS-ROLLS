package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Search;

import raysrentals.co.uk.lib.dao.HibernateJPABase;

@Service
@Transactional
public class BikeServiceImpl extends HibernateJPABase<Bike, Long> implements BikeService {
	@Override
	public Bike retrieveBike(Long id){
		return super.getReference(id);
	}
	
	@Override
	public Bike createOrUpdateBike(Bike bike){
		return super.save(bike);
	}
	
	 @Override
	 public List<Bike> retrieveAllBike(){
		return super.findAll();
	 }
	 
	 @Override
	 public void removeBikeById(Long id){
		 super.removeById(id);
	 }
	 
	 @Override
	 public List<Bike>getAllAvailableBikes(){
		 Search bikeSearch = new Search(Bike.class);
		 bikeSearch.addFilterEqual("available", true);
		 List<Bike> bikesRetrieved = super.search(bikeSearch);
		 return bikesRetrieved;	
	 }
	 
}
