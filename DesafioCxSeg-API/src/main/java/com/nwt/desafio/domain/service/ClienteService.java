package com.nwt.desafio.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwt.desafio.domain.exception.NegocioException;
import com.nwt.desafio.domain.model.Cliente;
import com.nwt.desafio.domain.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = (Cliente) clienteRepository.findByNome(cliente.getNome());
		
		if (clienteExistente != null && !clienteExistente.equals(cliente)) {
			throw new NegocioException("Já existe um cliente cadastrado com este CPF.");
		}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long id) {
		clienteRepository.deleteById(id);
	}
}
