package com.attornatus.testePratico.DTO;

import com.attornatus.testePratico.entities.Endereco;

public class EnderecoDTO {

	private Long id;
	private String logradouro;
	private Integer cep;
	private Integer numero;
	private String cidade;
	
	public EnderecoDTO() {
	}

	public EnderecoDTO(Long id, String logradouro, Integer cep, Integer numero, String cidade) {
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
	}
	
	public EnderecoDTO(Endereco entity) {
		id = entity.getId();
		logradouro = entity.getLogradouro();
		cep = entity.getCep();
		numero = entity.getNumero();
		cidade = entity.getCidade();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Integer getCep() {
		return cep;
	}

	public void setCep(Integer cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	
	
}
