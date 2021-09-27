package tg.springbootdemo.repository;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import tg.springbootdemo.entity.ClientRequest;

/**
 * Client Request Repository layer testing
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClientRequestRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ClientRequestRepository clientRequestRepository;

	@Test
	public void whenFindById_thenReturnClientRequest() {
		// given
		ClientRequest clientRequest = new ClientRequest("John", "Smith", "john@cf.com",
				"Address 1", "333-444", "Purpose of request 1");

		// when
		entityManager.persistAndFlush(clientRequest);
		Optional<ClientRequest> foundRequest = clientRequestRepository.findById(clientRequest.getId());

		// then
		assertEquals(foundRequest.get().getId(), clientRequest.getId());
	}

}
