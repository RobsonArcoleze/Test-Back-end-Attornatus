package com.attornatus.testePratico.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.attornatus.testePratico.DTO.PessoaDTO;
import com.attornatus.testePratico.services.PessoaService;
import com.attornatus.testePratico.services.exceptions.ResourceNotFoundException;
import com.attornatus.testePratico.tests.Factory;



@WebMvcTest
public class PessoaControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PessoaService service;
	
	private PageImpl<PessoaDTO> page;
	private PessoaDTO pessoaDTO;
	private Long existingId;
	private Long nonExistingId;
	
	@BeforeEach
	void setUp() throws Exception{
		
		existingId = 1L;
		nonExistingId = 2L;
		pessoaDTO = Factory.createdPessoaDTO(); 
		page = new PageImpl<>(List.of(pessoaDTO));
		
		when(service.findAllPaged( ArgumentMatchers.any())).thenReturn(page);
		when(service.findById(existingId)).thenReturn(pessoaDTO);
		when(service.findById(nonExistingId)).thenThrow(ResourceNotFoundException.class);
		
	}
	
	@Test
	public void findAllPagedShouldReturnPage() throws Exception {
		ResultActions result = mockMvc.perform(get("/pessoas")
			.accept(MediaType.APPLICATION_JSON)	
				);
		
		result.andExpect(status().isOk());
	}
	
	@Test
	public void findByIdShouldReturnPessoaDtoWhenIdExists() throws Exception {
		ResultActions result = mockMvc.perform(get("/pessoas/{id}", existingId)
				.accept(MediaType.APPLICATION_JSON)	
					);
		
		result.andExpect(status().isOk());
	}
	
	@Test
	public void findByIdShouldReturnResourceNotFoundExceptionWhenIdDoesNotExists() throws Exception {
		ResultActions result = mockMvc.perform(get("/pessoas/{id}", nonExistingId)
				.accept(MediaType.APPLICATION_JSON)	
					);
		
		result.andExpect(status().isNotFound());
	}
}

