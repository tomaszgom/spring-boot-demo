package tg.springbootdemo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import tg.springbootdemo.entity.ClientRequest;
import tg.springbootdemo.service.ClientRequestService;

/**
 * 
 * ClientRequestController exposed end points to work with front end requests
 *
 */

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class ClientRequestController {
	
	private ClientRequestService clientRequestService;
	
	@Autowired
	public ClientRequestController(ClientRequestService theClientRequestService) {		
		clientRequestService = theClientRequestService;
	}

	// Return the list of Client Request
	@GetMapping ("/issues")
	public List<ClientRequest> getAll(){
		return clientRequestService.findAll();
	}
	
	// Create new Client Request
	@PostMapping("/issues")
	public ResponseEntity<Void> addClientRequest(@RequestBody ClientRequest theClientRequest) {
		
		theClientRequest.setId(0);	
		ClientRequest createdClientRequest = clientRequestService.saveClientRequest(theClientRequest);
		
		// Taking current request path, the url of created resource, appending id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}").buildAndExpand(createdClientRequest.getId()).toUri();
		
		// Returning status call created, location of created resource
		return  ResponseEntity.created(uri).build();
	}
	
	// Delete Client Request
	@DeleteMapping("/issue/{clientRequestId}")
	public ResponseEntity<Void> deleteClientRequest(@PathVariable int clientRequestId ){
				
		 clientRequestService.deleteClientRequestById(clientRequestId);
			 return ResponseEntity.noContent().build();
	}
		
	@GetMapping ("/test")
	public String getTestString(){
		return "Test was successful!";
	}
	
}
