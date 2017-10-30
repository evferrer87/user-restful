package app;


import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import controller.UserController;
import dtoAssembler.UserDTOAssembler;
import service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRestfulTest {

	@Autowired
    private UserController userController;
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	UserDTOAssembler userDTOAssembler;
	
	@Test
	public void contextLoads() {
		assertThat(userController).isNotNull();
		assertThat(userService).isNotNull();
		assertThat(userDTOAssembler).isNotNull();
	}	

}