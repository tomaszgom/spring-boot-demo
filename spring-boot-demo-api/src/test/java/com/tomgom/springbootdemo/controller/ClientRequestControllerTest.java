package com.tomgom.springbootdemo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomgom.springbootdemo.SpringBootDemoApplication;
import com.tomgom.springbootdemo.entity.ClientRequest;
import com.tomgom.springbootdemo.repository.ClientRequestRepository;


/**
 * 
 * Client Request Controller testing GET and POST
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = SpringBootDemoApplication.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class ClientRequestControllerTest {

	// Object for testing servlet related calls
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
    private ClientRequestRepository clientRequestRepository;

    @After
    public void resetDb() {
    	clientRequestRepository.deleteAll();
    }
    
		
    @Test
    public void whenValidInput_CreatedClientRequest() throws Exception{
    	ClientRequest clientRequest = new ClientRequest("John","Smith","john@cf.com","Address 1","333-444","Purpose of request 1");
    	
    	mockMvc.perform( MockMvcRequestBuilders
          .post("/jpa/client-requests")
          .content(asJsonString(clientRequest))
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON))
          .andExpect(status().isCreated());
          
          List<ClientRequest> found = clientRequestRepository.findAll();
          assertThat(found).extracting(ClientRequest::getLastName).contains("Smith");

    }
		
	@Test
	public void givenClientRequests_whenGetClientRequests_thenReturnJsonArray()
	  throws Exception {
		
		createClientRequest( "John","Smith","john@cf.com","Address 1","333-444","Purpose of request 1");
		createClientRequest( "Jane","Jones","john@cf.com","Address 2","333-555","Purpose of request 2");
	 	    
		mockMvc.perform(get("/jpa/client-requests").contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
    	.andExpect(jsonPath("$[0].lastName", is("Smith")))
        .andExpect(jsonPath("$[1].lastName", is("Jones"))); 
	}
		
    private void createClientRequest( String firstName,String lastName,String email,String address,String phone, String contactPurpose) {
    	ClientRequest clientRequest = new ClientRequest(firstName,lastName,email,address,phone,contactPurpose);
    	clientRequestRepository.saveAndFlush(clientRequest);
    }
	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
	

}
