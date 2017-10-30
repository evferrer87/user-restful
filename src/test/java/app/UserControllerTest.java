package app;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectWriter;

import config.JacksonMapperBean;
import dtoAssembler.UserDTOAssembler;
import model.ResponseDTO;
import model.entities.User;
import service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Import(JacksonMapperBean.class)
public class UserControllerTest {

    @LocalServerPort
    private int port;
    
    @Autowired
    private JacksonMapperBean jsonMapper;
    
    @Autowired 
	UserDTOAssembler userDTOAssembler;
    
    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private UserService userService;
    
    Iterable<User> userList = Arrays.asList(
		new User(Long.valueOf(1), "Ev", "ag.com"),
		new User(Long.valueOf(2), "Eve", "b@g.com"),
		new User(Long.valueOf(3), "Evelio", "c@g.com")
	);                 
    
    @Before
    public void setup() throws JsonProcessingException {
    	     
    }
    
    @Test
    public void getAllUserShouldReturnAnResponseDTOWithAllUser() throws Exception {    	    
    	
    	ResponseDTO responseDTO = new ResponseDTO.Builder("OK")
			.result(userList)
			.build();
    	
    	ObjectWriter ow = jsonMapper.getMapper().writer();
        String responseExpected = ow.writeValueAsString(responseDTO);
    	
        Mockito.when(userService.getAllUser()).thenReturn(userList);	
        
    	assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/getAllUser/",
    			String.class)).contains(responseExpected);
    }
}