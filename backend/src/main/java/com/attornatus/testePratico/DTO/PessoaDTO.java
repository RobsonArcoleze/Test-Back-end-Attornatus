package com.attornatus.testePratico.DTO;

import java.time.LocalDate;

import com.attornatus.testePratico.entities.Pessoa;

public class PessoaDTO {

	private Long id;
	private String name;
	private LocalDate dataDeNascimento;
	
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

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}
	
	
}
