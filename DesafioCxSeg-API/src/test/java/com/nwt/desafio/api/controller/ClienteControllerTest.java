package com.nwt.desafio.api.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.mysql.cj.log.Log;
import com.nwt.desafio.domain.model.Cliente;

@SpringBootTest
class ClienteControllerTest {

	@Autowired
	ClienteController clienteController;
	
	Cliente cliente = new Cliente();
	
	List<Cliente> clientes = new ArrayList<Cliente>();
	String str = "2020-10-19T22:37:13.199Z";
	

	@Test
	void deveCadastrarUmaCliente() throws Exception{
		
        Cliente cliente = new Cliente();
        Cliente testCliente = clienteController.adicionar(cliente);

        assertNotNull(testCliente.getId());
	}
	
	@Test
	void deveRetornarClientePorId(Log id) throws Exception{

    	Cliente cliente = new Cliente();
    	clienteController.adicionar(cliente);

        assertNotNull(ResponseEntity.ok().build());
	}
	
	@Test
	void deveLancarExcecaoSeNaoEncontrarClientePorId() throws Exception{
		
		 clienteController.buscar(-1L);
		
	}
	
	@Test
	void deveConsultarUmaListaDeCliente() throws Exception {
		
		
    	Cliente cliente = new Cliente();
    	clienteController.adicionar(cliente);

        List<Cliente> byNome = clienteController.listar();
        assertThat(byNome.size());
	}
	
	@Test
	void deveAtualizarUmaCliente() throws Exception {
		
		cliente.setSobreNome("Almeida Prado");
		assertNotNull(clienteController.atualizar(2L, cliente));
		assertEquals("Almeida Prado", cliente.getSobreNome());
	}
	
    @Test
    public void testDelete() {

        Cliente cliente = new Cliente();
        clienteController.adicionar(cliente);
        clienteController.adicionar(cliente);
        ResponseEntity<Cliente> testCliente = clienteController.buscar(cliente.getId());
        assertNull(testCliente);
    }
}
