package dtoAssembler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.entities.User;

public class UserDTOAssembler implements DTOAssembler<User> {

	private static final Logger log = LoggerFactory.getLogger(UserDTOAssembler.class);
	
	@Override
	public User convertToModel(Object obj) {
		User user = null;
		ObjectMapper mapper = new ObjectMapper();		
		try {			
			user = mapper.readValue(String.valueOf(obj), User.class);			
		} catch(Exception e) {
			log.info(e.getMessage());
		}	    			
		return user;
	}
	
}