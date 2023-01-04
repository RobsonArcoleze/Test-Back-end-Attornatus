package com.attornatus.testePratico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attornatus.testePratico.DTO.PessoaDTO;
import com.attornatus.testePratico.entities.Pessoa;
import com.attornatus.testePratico.repositories.PessoaRepository;
import com.attornatus.testePratico.services.exceptions.ResourceNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	@Transactional(readOnly = true)
	public PessoaDTO findById(Long id) {
		Pessoa pessoa = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new PessoaDTO(pessoa);
	}
}
