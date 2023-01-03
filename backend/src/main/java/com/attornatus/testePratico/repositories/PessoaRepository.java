package com.attornatus.testePratico.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.attornatus.testePratico.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

}
