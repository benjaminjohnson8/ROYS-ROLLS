package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import raysrentals.co.uk.lib.dao.HibernateJPABase;

@Service
@Transactional
public class StockServiceImpl extends HibernateJPABase<Stock, Long> implements StockService {
	
	@Override
	public Stock retrieveStock(Long id){
		return super.getReference(id);
	}
	
	@Override
	 public List<Stock> retrieveAllStock(){
		return super.findAll();
	 }
	
	@Override
	public Stock createOrUpdateStock(Stock stock){
		return super.save(stock);
	}
	
	@Override
	 public void removeStockById(Long id){
		 super.removeById(id);
	 }

}
