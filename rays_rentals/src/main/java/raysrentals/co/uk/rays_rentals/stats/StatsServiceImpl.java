package raysrentals.co.uk.rays_rentals.stats;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import raysrentals.co.uk.rays_rentals.bike.Bike;
import raysrentals.co.uk.rays_rentals.bike.BikeService;

@Service
@Transactional
public class StatsServiceImpl implements StatsService {
	@Autowired
	BikeService bikeService;
	
	@Override
	 public int availableBikeCount(){
		 List<Bike> bikesRetrieved = bikeService.getAllAvailableBikes();
		 int bikeCount = 0;
		 for(@SuppressWarnings("unused") Bike bike: bikesRetrieved){
			 bikeCount++;
		 }
		 return bikeCount;	
	 }
	
	@Override
	public int allBikeCount(){
		List<Bike> bikesRetrieved = bikeService.retrieveAllBike();
		 int bikeCount = 0;
		 for(@SuppressWarnings("unused") Bike bike: bikesRetrieved){
			 bikeCount++;
		 }
		 return bikeCount;	
	}
	
	@Override
	public int getUnavailableBikes(){
		int availableBikes = availableBikeCount();
		int allBikes = allBikeCount();
		
		int unavilableBikes = allBikes - availableBikes;
		
		return unavilableBikes;
		
	}
	@Override
	public int getPercentageOfAvailable(){
		int availableBikes = availableBikeCount();
		int allBikes = allBikeCount();
		int percent = (availableBikes *100) / allBikes;
		
		return percent;
		
	}
	
	@Override
	public int getPercentageOfUnAvailable(){
		int unAvailableBikes = getUnavailableBikes();
		int allBikes = allBikeCount();
		int percent = (unAvailableBikes *100) / allBikes;
		
		return percent;
		
	}
	
	
	
}
