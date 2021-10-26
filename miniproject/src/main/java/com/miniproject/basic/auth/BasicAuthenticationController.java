package com.miniproject.basic.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController        //to create restful web services
@CrossOrigin(origins="http://localhost:4200")
public class BasicAuthenticationController {
	
	@Autowired
	private MessageSource messageSource; 
	//GET
	//URI - /hello-world
	//method - "hello world"
	
	//@RequestMapping(method=RequestMethod.GET,path= "/hello-world")
	
	
	
	//returning a bean
	//hello-world-bean
	@GetMapping(path= "/basicauth")
	public AuthenticationBean helloWorldBean() {
		return new AuthenticationBean("you are authenticated");
	}
	
	
}
