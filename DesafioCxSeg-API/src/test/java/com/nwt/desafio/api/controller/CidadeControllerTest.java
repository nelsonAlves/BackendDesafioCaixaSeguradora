package com.nwt.desafio.api.controller;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.nwt.desafio.domain.model.Cidade;

@SpringBootTest
class CidadeControllerTest {

	@Autowired
	CidadeController cidadeController;

	@Test
	void deveRetornarCidadePeloNome(String nome) throws Exception{

    	List<Cidade> cidades = new ArrayList<Cidade>();
    	cidadeController.buscarCidadePeloNome(((Cidade) cidades).getNome());

        assertNotNull(ResponseEntity.ok().build());
	}
}
