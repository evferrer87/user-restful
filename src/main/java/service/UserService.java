package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import common.exception.UniqueConstraintException;
import model.entities.User;
import repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(){}
	
	public User addUser(User user) throws UniqueConstraintException {
		User userFromDB = null;
		try {
			userFromDB = userRepository.save(user);
		}
		catch(DataIntegrityViolationException e) {			
			if (e.getMessage().contains("[UC_userName]")) {
				throw new UniqueConstraintException("The user name already exist.");
			}
			if (e.getMessage().contains("[UC_userEmail]")) {
				throw new UniqueConstraintException("The user email already exist.");
			}
		}
		return userFromDB;
	}
	
	public User updateUser(User user) throws UniqueConstraintException {
		User userFromDB = null;
		try {
			userFromDB = userRepository.save(user);
		}
		catch(DataIntegrityViolationException e) {			
			if (e.getMessage().contains("[UC_userName]")) {
				throw new UniqueConstraintException("The user name already exist.");
			}
			if (e.getMessage().contains("[UC_userEmail]")) {
				throw new UniqueConstraintException("The user email already exist.");
			}
		}
		return userFromDB;
	}

	public void deleteUser(User user) {	
		userRepository.delete(user.getId());
	}
	
	public Iterable<User> getAllUser() {		
		return userRepository.findAll();
	}
	
}
