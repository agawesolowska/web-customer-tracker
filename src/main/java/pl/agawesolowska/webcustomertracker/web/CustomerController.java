package pl.agawesolowska.webcustomertracker.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.agawesolowska.webcustomertracker.entity.Customer;
import pl.agawesolowska.webcustomertracker.service.CustomerService;

/**
 * The heart of the web customer tracker app responding to HTTP queries.
 * 
 * @author Aga
 *
 */
@Controller
@RequestMapping("/web-customer-tracker")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping
	public String getCustomersList(Model model) {
		List<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "/customers-list.jsp";
	}

	@GetMapping("/search-customers")
	public String searchCustomersByName(Model model, @RequestParam("searchName") String searchName) {
		List<Customer> customers = customerService.searchCustomersByName(searchName);
		model.addAttribute("customers", customers);
		return "/customers-list.jsp";
	}

	@GetMapping("/show-form")
	public String getFormAddCustomer() {
		return "/customer-form.jsp";
	}

	@PostMapping("/save-customer")
	public String saveCustomer(Model model, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {
		Customer newCustomer = new Customer(firstName, lastName, email);
		model.addAttribute("newCustomer", newCustomer);
		customerService.saveCustomer(newCustomer);
		return "redirect:/web-customer-tracker";
	}

	@GetMapping("/delete-customer")
	public String deleteCustomer(@RequestParam("customerId") long customerId) {
		customerService.deleteCustomer(customerId);
		return "redirect:/web-customer-tracker";
	}

}
