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
 * Controller handling Client request issues,
 * exposed end points to communicate with front-end calls
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ClientRequestController {

    private ClientRequestService clientRequestService;

    @Autowired
    public ClientRequestController(ClientRequestService theClientRequestService) {
        clientRequestService = theClientRequestService;
    }

    @GetMapping("/issues")
    public List<ClientRequest> getAllClientRequests() {
        return clientRequestService.findAll();
    }

    @PostMapping("/issues")
    public ResponseEntity<Void> createClientRequest(@RequestBody ClientRequest theClientRequest) {

        theClientRequest.setId(0);
        ClientRequest createdClientRequest = clientRequestService.saveClientRequest(theClientRequest);

        // Taking current request path, the url of created resource, appending id
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(createdClientRequest.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/issue/{clientRequestId}")
    public ResponseEntity<Void> deleteClientRequest(@PathVariable int clientRequestId) {

        clientRequestService.deleteClientRequestById(clientRequestId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public String healthCheck() {
        return "Successful!";
    }

}
