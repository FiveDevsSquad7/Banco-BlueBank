package com.banco.bluebank.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "correntista")
public class Correntista implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_correntista")
    private Long id;
    
    private String nome;
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;
    
    private String rg;
    
    @Column(name = "cnpj", length = 14, nullable = false)
    private String cnpj;
    
    @Column(name="pf_pj")
    private char tipoPessoa;
    
    @Column(name="email_validacao")
    private String emailValidacao;
    
    @Column(name="sms_validacao")
    private String smsValidacao;
    
    @OneToMany(mappedBy = "correntista", cascade = CascadeType.REMOVE)
	@Column(insertable = false, updatable = false)
	private List<Endereco> enderecos = new ArrayList<>();
    
    @OneToMany(mappedBy = "correntista", cascade = CascadeType.REMOVE)
	@Column(insertable = false, updatable = false)
    private List<ContatoCliente> contatos = new ArrayList<>();
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Correntista other = (Correntista) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "Correntista [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", cnpj=" + cnpj
				+ ", tipoPessoa=" + tipoPessoa + ", emailValidacao=" + emailValidacao + ", smsValidacao=" + smsValidacao
				+ ", enderecos=" + enderecos + ", contatos=" + contatos + "]";
	}
	
	
	
}
