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
		return mv;
				
	}
	
	@RequestMapping("/bikeInfo")
	public ModelAndView bikeInfo(@ModelAttribute("bike") Bike product, BindingResult result,Long id) {
		ModelAndView mv = new ModelAndView("/bike/bikeInfo");
		mv.addObject("bike", bikeService.retrieveBike(id));
		return mv;
				
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
		bike.setUnavailable(false);
		bikeService.createOrUpdateBike(bike);
		return new ModelAndView("redirect:allbikes");
	}
	
	@RequestMapping(value="/deleteBike")
	public ModelAndView deleteBike(Long id){
		System.out.println(id + "");
		bikeService.removeBikeById(id);
		return new ModelAndView("redirect:allbikes");
	}
	
}
