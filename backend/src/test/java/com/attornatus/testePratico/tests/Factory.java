package com.attornatus.testePratico.tests;

import java.time.LocalDate;

import com.attornatus.testePratico.DTO.PessoaDTO;
import com.attornatus.testePratico.entities.Endereco;
import com.attornatus.testePratico.entities.Pessoa;

public class Factory {

	public static Pessoa createPessoa() {
		Pessoa pessoa = new Pessoa(1L, "Robson Arcoleze", LocalDate.of(2015, 3, 5));
		return pessoa;
	}
	
	public static Endereco createEndereco() {
		Endereco endereco = new Endereco(1L, "Rua Benedita", 07714220, 39, Factory.createPessoa(), "SP");
		return endereco;
	}
	
	public static PessoaDTO createdPessoaDTO() {
		Pessoa pessoa = createPessoa();
		return new PessoaDTO(pessoa, pessoa.getEnderecos());
	}
	
}
