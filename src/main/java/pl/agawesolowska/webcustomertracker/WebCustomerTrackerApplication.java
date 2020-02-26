package pl.agawesolowska.webcustomertracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Simple CRM app that connects to a database using Spring MVC and Hibernate technologies.
 * 
 * @author Aga
 *
 */
@SpringBootApplication
public class WebCustomerTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebCustomerTrackerApplication.class, args);
	}

}
