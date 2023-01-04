package com.attornatus.testePratico.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String logradouro;
	private Integer cep;
	private Integer numero;
	
	@ManyToOne(optional = true)
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id", nullable = true)
	private Pessoa pessoa;
	
	public Endereco() {
	}

		public Endereco(Long id, String logradouro, Integer cep, Integer numero, Pessoa pessoa) {
		this.id = id;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.pessoa = pessoa;
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
	
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
