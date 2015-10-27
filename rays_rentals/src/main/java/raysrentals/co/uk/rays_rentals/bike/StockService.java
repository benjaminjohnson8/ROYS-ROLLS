package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

public interface StockService {
	
	public Stock retrieveStock(Long id);
	
	public List<Stock> retrieveAllStock();
	
	public Stock createOrUpdateStock(Stock stock);
	
	public void removeStockById(Long id);

}
