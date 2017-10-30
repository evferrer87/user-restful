package config;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JacksonMapperBean {

	private ObjectMapper mapper;
	
	public JacksonMapperBean() {
		mapper = new ObjectMapper();
	}
	
	public ObjectMapper getMapper() {
		return mapper; 
	}
	
}
