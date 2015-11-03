package raysrentals.co.uk.rays_rentals.bike;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
@RequestMapping("/bike")
public class BikeListController {
	
	@Autowired
	BikeService bikeService;
	
	@Autowired
	StockService stockService;
	@Autowired
	MaintenanceService maintenanceService;
	
	@RequestMapping(value = "/allbikes")
	public ModelAndView allBikes(){
		ModelAndView mv = new ModelAndView("bike/allBikes");
		List<Bike> allBikes = bikeService.retrieveAllBike();
		mv.addObject("allBikes", allBikes);
		return mv;
	}
	
	@RequestMapping("/newbike")
	public ModelAndView newproduct(@ModelAttribute("bike") Bike product, BindingResult result) {
		ModelAndView mv = new ModelAndView("/bike/newBike");
		mv.addObject("title", "New Bike");
		return mv;
				
	}
	
	@RequestMapping(value ="/editBike")
	public ModelAndView editBike(Long id) {
		ModelAndView mv = new ModelAndView("/bike/newBike");
		Bike bike = bikeService.retrieveBike(id);
		mv.addObject("bike", bike);
		mv.addObject("title", "Edit Bike");
		return mv;
	}
	
	@RequestMapping("/bikeInfo")
	public ModelAndView bikeInfo(@ModelAttribute("maintenanceRecord") MaintenanceRecord maintenanceRecord, BindingResult result,Long id) {
		ModelAndView mv = new ModelAndView("/bike/bikeInfo");
		mv.addObject("bike", bikeService.retrieveBike(id));
		List<MaintenanceRecord> maintenanceRecords = maintenanceService.retrieveAllMaintenanceHistoryForBike(id);
		System.out.println(maintenanceRecords);
		mv.addObject("history",maintenanceRecords);
		return mv;
				
	}
	
	@RequestMapping("/allstock")
	public ModelAndView stock() {
		ModelAndView mv = new ModelAndView("/bike/stock");
		List<Stock> allStock = stockService.retrieveAllStock();
		mv.addObject("allStock", allStock);
		return mv;
				
	}
	
	@RequestMapping("/newstock")
	public ModelAndView newStock(@ModelAttribute("stock") Stock product, BindingResult result) {
		ModelAndView mv = new ModelAndView("/bike/newStock");
		return mv;
				
	}
	
	@RequestMapping(value = "/addNewStock")
	public ModelAndView newStockInfo(@ModelAttribute("stock") Stock stock, BindingResult bindingResult) {
		stockService.createOrUpdateStock(stock);
		return new ModelAndView("redirect:allstock");
	}
	
	@RequestMapping(value ="/editStock")
	public ModelAndView editStock(Long id) {
		ModelAndView mv = new ModelAndView("/bike/newStock");
		Stock stock = stockService.retrieveStock(id);
		mv.addObject("stock", stock);
		mv.addObject("title", "Edit Stock");
		return mv;
	}
	
	@RequestMapping(value="/deleteStock")
	public ModelAndView deleteStock(Long id){
		stockService.removeStockById(id);
		return new ModelAndView("redirect:allstock");
	}

	@RequestMapping(value = "/addNewBike")
	public ModelAndView newBikeInfo(@ModelAttribute("bike") Bike bike, BindingResult bindingResult) {
//		ModelAndView mv = new ModelAndView("/bike/newBike");
		
		//add bike validation later
	//	bikeValidator.validate(bike, bindingResult);
//		if(bindingResult.hasErrors())
//		{
//			mv.addObject("errors", bindingResult);
//			return mv;
//		}
		Date date = new Date();
		bike.setPurchaseDate(date);
		bike.setAvailable(true);
		bikeService.createOrUpdateBike(bike);
		return new ModelAndView("redirect:allbikes");
	}
	
	@RequestMapping(value="/deleteBike")
	public ModelAndView deleteBike(Long id){
		System.out.println(id + "");
		bikeService.removeBikeById(id);
		return new ModelAndView("redirect:allbikes");
	}
	
	@RequestMapping(value = "/addNewRecord")
	public ModelAndView addNewRecord(@ModelAttribute("maintenanceRecord") MaintenanceRecord maintenanceRecord) {
		maintenanceService.addRecord(maintenanceRecord);
		return new ModelAndView("redirect:allbikes");
	}
	
}
