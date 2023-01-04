package com.attornatus.testePratico.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.attornatus.testePratico.entities.Endereco;
import com.attornatus.testePratico.entities.Pessoa;

public class PessoaDTO {

	private Long id;
	private String name;
	private LocalDate dataDeNascimento;
	
	private List<EnderecoDTO> enderecos = new ArrayList<>();
	
	public PessoaDTO(Long id, String name, LocalDate dataDeNascimento) {
		this.id = id;
		this.name = name;
		this.dataDeNascimento = dataDeNascimento;
	}
	
	public PessoaDTO(Pessoa entity) {
		id = entity.getId();
		name = entity.getName();
		dataDeNascimento = entity.getDataDeNascimento();
	}
	
	public PessoaDTO(Pessoa entity, List<Endereco> endereco) {
		this(entity);
		endereco.forEach(end -> this.enderecos.add(new EnderecoDTO(end)));
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public List<EnderecoDTO> getEnderecos() {
		return enderecos;
	}
	
	
}
