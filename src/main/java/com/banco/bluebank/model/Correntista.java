package com.banco.bluebank.model;

import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "correntista")
public class Correntista  extends AbstractEntity {

	private String nome;
	@Column(name = "cpf", length = 11, nullable = false)
	private String cpf;

	private String rg;

	@Column(name = "cnpj", length = 14, nullable = false)
	private String cnpj;

	@Column(name="pf_pj")
	private Character tipoPessoa;

	@Column(name="email_validacao")
	private String emailValidacao;

	@Column(name="sms_validacao")
	private String smsValidacao;


	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "CORRENTISTAS_TEM_ENDERECOS",
			joinColumns = @JoinColumn(name = "ID_CORRENTISTA", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO", referencedColumnName = "ID")
	)
	private List<Endereco> enderecos;

	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(
			name = "CORRENTISTAS_TEM_CONTATOS",
			joinColumns = @JoinColumn(name = "ID_CORRENTISTA", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "ID_CONTATO", referencedColumnName = "ID")
	)
	private List<ContatoCliente> contatos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public char getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(char tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public String getEmailValidacao() {
		return emailValidacao;
	}

	public void setEmailValidacao(String emailValidacao) {
		this.emailValidacao = emailValidacao;
	}

	public String getSms() {
		return smsValidacao;
	}

	public void setSms(String sms) {
		this.smsValidacao = sms;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public List<ContatoCliente> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoCliente> contatos) {
		this.contatos = contatos;
	}

	public Correntista(String nome, String cpf, String rg, String cnpj, char tipopessoa, String emailValidacao, String smsValidacao) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.cnpj = cnpj;
		this.tipoPessoa = tipopessoa;
		this.emailValidacao = emailValidacao;
		this.smsValidacao = smsValidacao;
	}

	public Correntista() {

	}
}
