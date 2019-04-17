package io.javabrains.springbootstarter.hello;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	//get rest api
	@RequestMapping("/hello")
	public String sayHi() {
		return "HI";
	}
	
	
	

}
