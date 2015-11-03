package raysrentals.co.uk.rays_rentals.bike;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	RentalService rentalService;
	@RequestMapping(value="/allrentals")
	public ModelAndView allRentals(){
		ModelAndView mv = new ModelAndView("rental/rentalRecords");
		List<RentalRecord> rentalRecords = rentalService.retrieveAllRentalRecord();
		mv.addObject("allRentals", rentalRecords);
		return mv;
	}
}
