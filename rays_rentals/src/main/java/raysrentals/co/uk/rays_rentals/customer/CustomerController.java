package raysrentals.co.uk.rays_rentals.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@RequestMapping(value="newCustomers")
	public ModelAndView newCustomers(@ModelAttribute("customer") Customer customer){
		ModelAndView mv = new ModelAndView("customer/newCustomer");
		return mv;
		
	}
	
	@RequestMapping(value="/addNewCustomer")
	public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes ra){
		customerService.createOrUpdateCustomer(customer);
		ra.addFlashAttribute("redirectAttribute", "New Customer Added");
		return new ModelAndView("redirect:/customer/newCustomers");
		
	}
}
