package controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import common.exception.UniqueConstraintException;
import dtoAssembler.UserDTOAssembler;
import model.ResponseDTO;
import model.entities.User;
import service.UserService;

@RestController
public class UserController {
	
	private UserService userService;
	
	private UserDTOAssembler userDTOAssembler;
	
	public UserController(UserService userService, UserDTOAssembler userDTOAssembler) {		
		this.userService = userService;
		this.userDTOAssembler = userDTOAssembler;
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, value = "/addUser")
	public ResponseDTO addUser(@RequestBody String userString) throws UniqueConstraintException {
		
		User user = userService.addUser(userDTOAssembler.convertToModel(userString));
		return new ResponseDTO.Builder("OK").result(user).build();
		
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, value = "/updateUser")
	public ResponseDTO updateUser(@RequestBody String userString) throws UniqueConstraintException {
				
		User user = userService.updateUser(userDTOAssembler.convertToModel(userString));
		return new ResponseDTO.Builder("OK").result(user).build();
		
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, value = "/deleteUser")
	public ResponseDTO deleteUser(@RequestBody String userString) {
				
		userService.deleteUser(userDTOAssembler.convertToModel(userString));
		return new ResponseDTO.Builder("OK").build();
		
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.GET, value = "/getAllUser")
	public ResponseDTO getAllUser() {
		
		Iterable<User> users = userService.getAllUser();
		return new ResponseDTO.Builder("OK").result(users).build();
		
	}
}
