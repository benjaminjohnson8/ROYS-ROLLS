package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import raysrentals.co.uk.lib.dao.HibernateJPABase;

@Service
@Transactional
public class StockServiceImpl extends HibernateJPABase<Stock, Long> implements StockService {
	
	@Override
	 public List<Stock> retrieveAllStock(){
		return super.findAll();
	 }

}
