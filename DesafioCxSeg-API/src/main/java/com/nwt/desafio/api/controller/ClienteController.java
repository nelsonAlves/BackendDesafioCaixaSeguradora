package com.nwt.desafio.api.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nwt.desafio.domain.model.Cliente;
import com.nwt.desafio.domain.repository.ClienteRepository;
import com.nwt.desafio.domain.service.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/desafio")
@Api(value="API REST Clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@ApiOperation(value="Retorna uma lista de Clientes")
	@GetMapping("/clientes")
	public List<Cliente> listar() {	
		
		return clienteRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um único Cliente")
	@GetMapping("/cliente/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@ApiOperation(value="Adiciona um Cliente")
	@PostMapping("/cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
		
		return clienteService.salvar(cliente);
	}
	
	@ApiOperation(value="Atualiza um Cliente")
	@PutMapping("/cliente/{id}")
	public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long id,
			@RequestBody Cliente cliente) {
		
		if (!clienteRepository.existsById(id)) {
			
			return ResponseEntity.notFound().build();
		}
		
		cliente.setId(id);
		cliente = clienteService.salvar(cliente);
		
		return ResponseEntity.ok(cliente);
	}
	
	@ApiOperation(value="Remove um Cliente")
	@DeleteMapping("/cliente/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		
		clienteService.excluir(id);
		
		return ResponseEntity.noContent().build();
	}
}
