package com.attornatus.testePratico.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.attornatus.testePratico.DTO.PessoaDTO;
import com.attornatus.testePratico.entities.Endereco;
import com.attornatus.testePratico.entities.Pessoa;
import com.attornatus.testePratico.repositories.EnderecoRepository;
import com.attornatus.testePratico.repositories.PessoaRepository;
import com.attornatus.testePratico.services.exceptions.ResourceNotFoundException;
import com.attornatus.testePratico.tests.Factory;

import jakarta.persistence.EntityNotFoundException;



@ExtendWith(SpringExtension.class)
public class PessoaServiceTests {

	@InjectMocks
	private PessoaService service;
	
	@Mock
	private PessoaRepository repository;
	
	@Mock
	private EnderecoRepository enderecoRepository;
	
	
	private long existingId;
	private long nonExistingId;
	private PageImpl<Pessoa> page;
	private Pessoa pessoa;
	private Endereco endereco;
	private PessoaDTO pessoaDTO;
	
	
	@BeforeEach
	void setUp() throws Exception{
		existingId = 1L;
		nonExistingId = 1000L;
		pessoa = Factory.createPessoa();
		page = new PageImpl<>(List.of(pessoa));
		pessoaDTO = Factory.createdPessoaDTO();
	
		Mockito.when(repository.findAll((Pageable)ArgumentMatchers.any())).thenReturn(page);
		
		Mockito.when(repository.save(ArgumentMatchers.any())).thenReturn(pessoa);
		
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(pessoa));
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
		
		Mockito.when(repository.getReferenceById(existingId)).thenReturn(pessoa);
		Mockito.when(repository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
		
		Mockito.when(enderecoRepository.getReferenceById(existingId)).thenReturn(endereco);
		Mockito.when(enderecoRepository.getReferenceById(nonExistingId)).thenThrow(EntityNotFoundException.class);
		
			}
	
	@Test
	public void updateShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.update(nonExistingId, pessoaDTO);
		});
	}
	
	@Test
	public void updateShouldReturnPessoaDtoWhenIdExists() {
		
		PessoaDTO result = service.update(existingId, pessoaDTO);
		
		Assertions.assertNotNull(result);
	}
	
	@Test
	public void findByIdShouldThrowResourceNotFoundExceptionWhenIdDoesNotExist() {
		
		Assertions.assertThrows(ResourceNotFoundException.class, () -> {
			service.findById(nonExistingId);
		});
	}
	
	@Test
	public void findByIdShouldReturnPessoaDtoWhenIdExists() {
		
		PessoaDTO result = service.findById(existingId); 
		
		Assertions.assertNotNull(result);
	}
	
	@Test
	public void findAllPagedShoulReturnPageable() {
		
		Pageable pageable = PageRequest.of(0, 10);
		
		Page<PessoaDTO> result = service.findAllPaged(pageable);
		
		Assertions.assertNotNull(result);
		Mockito.verify(repository, Mockito.times(1)).findAll(pageable);
	}
	
}


