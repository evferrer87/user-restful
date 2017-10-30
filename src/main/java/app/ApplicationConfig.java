package app;

import org.springframework.context.annotation.Bean;

import dtoAssembler.UserDTOAssembler;
import service.UserService;

public class ApplicationConfig {

	@Bean
	public UserService userService() {
		return new UserService();
	}
	
	@Bean 
	UserDTOAssembler userDTOAssembler() {
		return new UserDTOAssembler();
	}
	
}
