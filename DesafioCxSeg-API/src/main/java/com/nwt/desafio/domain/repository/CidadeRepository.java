package com.nwt.desafio.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nwt.desafio.domain.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{

	Cidade findById(long id);
	Optional<Cidade> findByNome(String nome);
	List<Cidade> findByNomeContaining(String nome);
}
