package raysrentals.co.uk.rays_rentals.bike;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.googlecode.genericdao.search.SearchResult;

@Controller
@RequestMapping("/search")
public class RentalSearchController {
	@Autowired
	RentalService rentalService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String search(Model model) {
		model.addAttribute(new RentalSearch());
        return "search/search";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView search(@Valid @ModelAttribute RentalSearch rentalSearch) {
		ModelAndView result = new ModelAndView("search/search");

		SearchResult<RentalRecord> records = rentalService.search(rentalSearch);
		result.addObject("searchResults", records.getResult());
		
		return result;
	}

}
