package com.attornatus.testePratico.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.attornatus.testePratico.Endereco;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate dataDeNascimento;
	
	@OneToMany(mappedBy = "pessoa")
	private List<Endereco> enderecos = new ArrayList<>();
	
	public Pessoa() {
	}

	public Pessoa(Long id, String name, LocalDate dataDeNascimento) {
		this.id = id;
		this.name = name;
		this.dataDeNascimento = dataDeNascimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	
	
}
