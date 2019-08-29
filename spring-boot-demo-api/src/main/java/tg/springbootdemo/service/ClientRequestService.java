package tg.springbootdemo.service;

import java.util.List;

import tg.springbootdemo.entity.ClientRequest;

public interface ClientRequestService {
	
	public List<ClientRequest> findAll();
	
	public ClientRequest findById(int theId);
	
	public ClientRequest saveClientRequest(ClientRequest theClientRequest);

	public void deleteClientRequestById(int theId);

}
