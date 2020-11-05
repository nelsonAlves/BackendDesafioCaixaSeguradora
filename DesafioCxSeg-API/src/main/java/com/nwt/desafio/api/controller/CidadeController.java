package com.nwt.desafio.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nwt.desafio.domain.model.Cidade;
import com.nwt.desafio.domain.repository.CidadeRepository;
import com.nwt.desafio.domain.service.CidadeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value="/desafio")
@Api(value="API REST Cidades")
@CrossOrigin(origins = "*")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CidadeService cidadeService;

	@ApiOperation(value="Retorna uma lista de Cidades")
	@GetMapping("/cidades")
	public List<Cidade> buscarTodasCidades(){
		
		return cidadeRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma cidade pelo nome")
	@GetMapping("/cidade/{nome}")
	public ResponseEntity<Cidade> buscarCidadePeloNome(@PathVariable String nome) throws ObjectNotFoundException {
		
		Cidade nomeCidade = cidadeService.findBuscaPorNome(nome);
		
		return  ResponseEntity.ok().body(nomeCidade);
	}

}
