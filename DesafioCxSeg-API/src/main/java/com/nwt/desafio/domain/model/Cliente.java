package com.nwt.desafio.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;
    private String cidade;
    private String uf;
    private String genero;
    private String nome;
    @Column(name = "sobre_nome")
    private String sobreNome;
    @Column(name = "num_cpf")
    private String cpf;
	@DateTimeFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss")
	@Column(name = "dth_nascimento")
    private Date dthNascimento;
    
    
	public Cliente() {
		super();
	}

	public Cliente(Long id, String endereco, String cidade, String uf, String genero, String nome, String sobreNome, String cpf,
			Date dthNascimento) {
		super();
		this.id = id;
		this.endereco = endereco;
		this.cidade = cidade;
		this.uf = uf;
		this.genero = genero;
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.dthNascimento = dthNascimento;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getUf() {
		return uf;
	}


	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobreNome() {
		return sobreNome;
	}


	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public Date getDthNascimento() {
		return dthNascimento;
	}


	public void setDthNascimento(Date dthNascimento) {
		this.dthNascimento = dthNascimento;
	}

}
