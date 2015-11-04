package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.core.rolling.helper.RenameUtil;
import raysrentals.co.uk.rays_rentals.customer.Customer;
import raysrentals.co.uk.rays_rentals.customer.CustomerService;

@Controller
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	RentalService rentalService;
	
	@Autowired
	CustomerService customerService;

	
	@Autowired
	BikeService bikeService;
	@RequestMapping(value="/allrentals")
	public ModelAndView allRentals(){
		ModelAndView mv = new ModelAndView("rental/rentalRecords");
		List<RentalRecord> rentalRecords = rentalService.retrieveAllRentalRecord();
		mv.addObject("allRentals", rentalRecords);
		return mv;
	}
	
	@RequestMapping(value="newRentals")
	public ModelAndView newRentalPage(@ModelAttribute("rentalRecord") RentalRecord rentalRecord){
		ModelAndView mv = new ModelAndView("rental/newRentalRecord");
		List<Customer> customers = customerService.retrieveAllCustomers();
		mv.addObject("customers", customers );
		return mv;
	}
	
	@RequestMapping(value = "/addNewRentalRecord")
	public ModelAndView newBikeInfo(@ModelAttribute("rentalRecord") RentalRecord rentalRecord) {

		rentalService.createOrUpdateRentalRecord(rentalRecord);
		Bike bike = rentalRecord.getBike();
		
		bike.setAvailable(false);
		bikeService.createOrUpdateBike(bike);
		return new ModelAndView("redirect:allRentals");
	}
}
