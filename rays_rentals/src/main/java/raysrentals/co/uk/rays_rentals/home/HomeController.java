package raysrentals.co.uk.rays_rentals.home;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import raysrentals.co.uk.rays_rentals.stats.StatsService;

@Controller
public class HomeController {
	@Autowired
	StatsService statSerivce;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index(Principal principal) {
		ModelAndView mv = new ModelAndView();
		if (principal != null) {
			// TODO tidy this up
			mv = new ModelAndView("home/homeSignedIn");
			int availabelBikeCount = statSerivce.availableBikeCount();
			int allBikeCount = statSerivce.allBikeCount();
			int availableBikePercent = statSerivce.getPercentageOfAvailable();

			int unavailableCount = statSerivce.getUnavailableBikes();
			int unavailablePercent = statSerivce.getPercentageOfUnAvailable();
			mv.addObject("availableCount", availabelBikeCount);
			mv.addObject("allBikeCount", allBikeCount);
			mv.addObject("availablePercent", availableBikePercent);
			mv.addObject("unavailableCount", unavailableCount);
			mv.addObject("unavailablePercent", unavailablePercent);

		} else {
			mv = new ModelAndView("home/homeNotSignedIn");
		}
		return mv;
	}
}
