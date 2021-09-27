package tg.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tg.springbootdemo.entity.ClientRequest;

@Repository
public interface ClientRequestRepository extends JpaRepository<ClientRequest, Integer>{
}
