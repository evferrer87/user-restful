package app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import config.JacksonMapperBean;
import dtoAssembler.UserDTOAssembler;
import model.entities.User;

@SpringBootTest
@Import(JacksonMapperBean.class)
@RunWith(SpringRunner.class)
public class DTOAssemblerTest {

	@Autowired
    private JacksonMapperBean jacksonMapper;
    
	@Autowired
	private UserDTOAssembler assembler;	

	private String userJson;
	
	@Before
	public void setup() throws ParseException {
		userJson = "{\"id\":1,\"name\":\"qw\",\"email\":\"Eve@g.com\"}";		  
	}
	
	@Test
	public void convertUserJsonToModelShouldBeReturnUserObject() throws IOException {
		assertThat(assembler).isNotEqualTo(null);
		assertThat(jacksonMapper).isNotEqualTo(null);
		User user = this.jacksonMapper.getMapper().readValue(userJson, User.class);
		assertEquals(user, assembler.convertToModel(userJson));
	}
}
