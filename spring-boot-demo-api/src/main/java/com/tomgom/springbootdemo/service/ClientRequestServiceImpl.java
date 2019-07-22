package com.tomgom.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tomgom.springbootdemo.entity.ClientRequest;
import com.tomgom.springbootdemo.repository.ClientRequestRepository;


/**
 * 
 * Client Request Service (business logic) layer
 *
 */

@Service
public class ClientRequestServiceImpl implements ClientRequestService {
	
	private ClientRequestRepository clientRequestRepository;
	
	
	public ClientRequestServiceImpl() {	
		
	}
	
	@Autowired
	public ClientRequestServiceImpl(ClientRequestRepository theClientRequestRepository) {
		clientRequestRepository = theClientRequestRepository;
	}
		
	@Override
	@Transactional
	public List<ClientRequest> getAll() {
		 return clientRequestRepository.findAll();
	}

	@Override
	@Transactional
	public ClientRequest findById(int theId) {
		return clientRequestRepository.findById(theId).get();
	}

	@Override
	@Transactional
	public ClientRequest saveClientRequest(ClientRequest theClientRequest) {
		clientRequestRepository.save(theClientRequest);
		return theClientRequest;
	}

	@Override
	@Transactional
	public void deleteClientRequestById(int theId) {
		clientRequestRepository.deleteById(theId);
	}

}
