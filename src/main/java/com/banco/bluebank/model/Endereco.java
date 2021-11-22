package com.banco.bluebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;

import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "endereco")
public class Endereco extends AbstractEntity {

	private String logradouro;

	private String numero;

	private String complemento;

	private String cep;

	private String bairro;

	private String cidade;

	private String estado;

	@ManyToOne
	// evita recursividade quando o json de resposta for criado para a datatables.
	@JsonIgnore
	private Correntista correntista;


	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public Endereco(String logradouro, String numero, String complemento, String cep, String bairro, String cidade,
					String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}

	public Endereco() {

	}
}
