package com.nwt.desafio.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nwt.desafio.domain.exception.NegocioException;
import com.nwt.desafio.domain.model.Cidade;
import com.nwt.desafio.domain.repository.CidadeRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	public Cidade cadastrarCidade(Cidade cidade) {

		Optional<Cidade> cidadeExiste = cidadeRepository.findById(cidade.getId());
	
		if (cidadeExiste != null && !cidadeExiste.equals(cidade)) {
			throw new NegocioException("Já existe um cliente cadastrado com este CPF.");
		}
		
		return cidadeRepository.save(cidade);
	}
	
	public Cidade findBuscaPorNome(String nome) throws ObjectNotFoundException {
		
		Optional<Cidade> nomeCidade = cidadeRepository.findByNome(nome);
		
		return nomeCidade.orElseThrow(() -> new ObjectNotFoundException("Nome não encontrado!"));
	}
}
