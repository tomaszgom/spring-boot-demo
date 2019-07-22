package com.tomgom.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tomgom.springbootdemo.entity.ClientRequest;


@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequest, Integer>{
	
}
