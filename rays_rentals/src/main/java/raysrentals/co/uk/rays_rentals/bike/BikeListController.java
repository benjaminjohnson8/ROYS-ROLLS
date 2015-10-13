package raysrentals.co.uk.rays_rentals.bike;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/bike")
public class BikeListController {
	
	@Autowired
	BikeService bikeService;
	
	@RequestMapping(value = "/allbikes", method = RequestMethod.GET)
	public ModelAndView allBikes(){
		ModelAndView mv = new ModelAndView("bike/allBikes");
//		List<Bike> allBikes = bikeService.retrieveAllBike();
//		allBikes = new ArrayList<Bike>();
//		mv.addObject("allBikes", allBikes);
		return mv;
	}
}
