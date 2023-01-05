package com.attornatus.testePratico.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.attornatus.testePratico.DTO.EnderecoDTO;
import com.attornatus.testePratico.entities.Endereco;
import com.attornatus.testePratico.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	private EnderecoRepository repository;

	@Transactional
	public EnderecoDTO insert(Long id, EnderecoDTO dto) {
		Endereco entity = new Endereco();
		copyDtoToEntity (dto, entity);
		entity = repository.save(entity);
	 
		return new EnderecoDTO(entity);
	}
	
	private void copyDtoToEntity(EnderecoDTO dto, Endereco entity) {

		entity.setLogradouro(dto.getLogradouro());
		entity.setCep(dto.getCep());
		entity.setNumero(dto.getNumero());
		entity.setCidade(dto.getCidade());

								
	}
}
