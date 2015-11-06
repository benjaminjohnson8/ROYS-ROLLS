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
/**
 * 
 * @author ROakley
 *
 */
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
		List<Bike> availableBikes = bikeService.getAllAvailableBikes();
		mv.addObject("customers", customers );
		mv.addObject("availableBikes", availableBikes );
		return mv;
	}
	
	@RequestMapping(value = "/addNewRentalRecord")
	public ModelAndView newRentalInfo(@ModelAttribute("rentalRecord") RentalRecord rentalRecord) {
		
		Long bikeId = rentalRecord.getBike().getId();
		if(bikeId !=null){
			Bike bike =bikeService.retrieveBike(bikeId);
			bike.setAvailable(false);
			bikeService.createOrUpdateBike(bike);
		}
		rentalService.createOrUpdateRentalRecord(rentalRecord);
		
		return new ModelAndView("redirect:allrentals");
	}
	
	@RequestMapping(value ="/editRentalRecord")
	public ModelAndView editRentalRecord(Long id) {
		ModelAndView mv = new ModelAndView("rental/newRentalRecord");
		RentalRecord rentalRecord = rentalService.getSingleRentalRecord(id);
		mv.addObject("title", "Update Rental Record");
		mv.addObject("rentalRecord", rentalRecord);
		mv.addObject("title", "Edit Bike");
		return mv;
	}
}
