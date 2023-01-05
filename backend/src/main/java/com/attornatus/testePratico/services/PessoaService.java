package com.attornatus.testePratico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attornatus.testePratico.DTO.PessoaDTO;
import com.attornatus.testePratico.entities.Pessoa;
import com.attornatus.testePratico.repositories.PessoaRepository;
import com.attornatus.testePratico.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	
	@Transactional(readOnly = true)
	public PessoaDTO findById(Long id) {
		Pessoa pessoa = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Recurso não encontrado"));
		return new PessoaDTO(pessoa, pessoa.getEnderecos());
	}
	
	@Transactional(readOnly = true)
	public Page<PessoaDTO> findAllPaged(Pageable pageable){
		Page <Pessoa> list = repository.findAll(pageable);
		return list.map(x -> new PessoaDTO(x));
	}
	
	@Transactional
	public PessoaDTO insert(PessoaDTO dto) {
		Pessoa entity = new Pessoa();
		copyDtoToEntity (dto, entity);
		entity = repository.save(entity);
	 
		return new PessoaDTO(entity);
	}
	
	@Transactional
	public PessoaDTO update(Long id, PessoaDTO dto) {
		try {
			Pessoa entity = repository.getReferenceById(id);
			copyDtoToEntity (dto, entity);
			entity = repository.save(entity);
			return new PessoaDTO(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("ID not found" + id);
		}
	}
	
	
	
	
	private void copyDtoToEntity(PessoaDTO pessoaDto, Pessoa pessoaEntity) {

		pessoaEntity.setNome(pessoaDto.getNome());
		pessoaEntity.setDataDeNascimento(pessoaDto.getDataDeNascimento());
								
	}
}
	