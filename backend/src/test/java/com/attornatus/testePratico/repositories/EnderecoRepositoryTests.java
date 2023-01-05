package com.attornatus.testePratico.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.attornatus.testePratico.entities.Endereco;
import com.attornatus.testePratico.tests.Factory;

@DataJpaTest
public class EnderecoRepositoryTests {

	@Autowired
	private EnderecoRepository repository;
	
	private long existingId;
	private long nonExixtingId;
	
	@BeforeEach
	void setUp() throws Exception{
		existingId = 1L;
		nonExixtingId = 1000L;
	}
	
	@Test
	public void saveShouldPersitWithAutoIncrementWhenIdIsNull() {
		Endereco pessoa = Factory.createEndereco();
		pessoa.setId(null);
		
		pessoa = repository.save(pessoa);
		
		Assertions.assertNotNull(pessoa.getId());
	}
	
	@Test
	public void findByIdShouldReturnEnderecoNotEmptyWhenIdExists() {
		
		Optional<Endereco> result = repository.findById(existingId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldReturnOptionalProductIsEmptyWhenIdDoesNotExists() {
		
		Optional<Endereco> result = repository.findById(nonExixtingId);
		
		Assertions.assertTrue(result.isEmpty());
	}
}
