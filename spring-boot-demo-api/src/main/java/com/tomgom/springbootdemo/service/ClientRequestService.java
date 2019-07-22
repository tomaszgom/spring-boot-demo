package com.tomgom.springbootdemo.service;

import java.util.List;

import com.tomgom.springbootdemo.entity.ClientRequest;

public interface ClientRequestService {
	
	public List<ClientRequest> getAll();
	
	public ClientRequest findById(int theId);
	
	public ClientRequest saveClientRequest(ClientRequest theClientRequest);

	public void deleteClientRequestById(int theId);

}
