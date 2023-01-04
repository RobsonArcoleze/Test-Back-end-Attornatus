package com.attornatus.testePratico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.attornatus.testePratico.DTO.PessoaDTO;
import com.attornatus.testePratico.services.PessoaService;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PessoaDTO> finById(@PathVariable Long id){
		PessoaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
}
