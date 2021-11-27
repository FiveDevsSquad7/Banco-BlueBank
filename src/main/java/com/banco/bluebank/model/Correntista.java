package com.banco.bluebank.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "correntista")
public class Correntista implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_correntista")
    private Long id;
    
    @Column(length = 50)
    @NotBlank(message = "Nome da Pessoa deve ser preenchido")
    @Size(min = 2, max = 50, message = "Nome da pessoa deve ter entre 2 e 50 letras")
    private String nome;
    
    @NotNull(message = "CPF deve ser preenchido")
    @Size(min = 2, max = 11, message = "CPF da pessoa deve ter entre 2 e 50 letras")
    @Pattern(regexp="\\d{3}.\\d{3}.\\d{3}-\\d{2}", message = "CPF da Pessoa deve seguir o padrão NNN.NNN.NNN-NN")
    @Column( length = 14, nullable = false)
    private String cpf;
    
    @NotBlank(message = "RG deve ser preenchido")
    @Size(min = 2, max = 11, message = "RG da pessoa deve ter entre 2 e 20 caracteres")
    @Column(length = 11,  nullable = true)
    private String rg;
    
    @NotNull(message = "CNPJ deve ser preenchido")
    @Size(min = 2, max = 15, message = "CNPJ da pessoa deve ter entre 2 e 15 dígitos")    
    @Column(name = "cnpj", length = 14, nullable = false)
    @Pattern(regexp="\\d{3}.\\d{3}.\\d{3}.\\d{3}-\\d{3}", message = "CNPJ da Pessoa deve seguir o padrão NNN.NNN.NNN.NNN-NN")
    private String cnpj;

    @NotNull(message = "O tipo pessoa deve ser preenchido")
    @Size(min = 2, max = 2, message = "O tipo de pessoa deve ter entre 2 caracteres")    
    @Column(name="pf_pj", length = 2, nullable = false)
    private char tipoPessoa;
    
    @NotNull(message = "O email validacao deve ser preenchido")
    @Size(min = 5, max = 50, message = "O tipo de pessoa deve ter entre 5  a 50 caracteres")    
    @Column(name="email_validacao", length = 50, nullable = false)
    private String emailValidacao;
    
    @NotNull(message = "O sms validacao deve ser preenchido")
    @Size(min = 5, max = 20, message = "O sms deve ter entre 5 a 20 caracteres")    
    @Column(name="sms_validacao", length = 20, nullable = false)
    private String smsValidacao;
    
    @OneToMany(mappedBy = "correntista")
    private List<Endereco> enderecos;
    
    @OneToMany(mappedBy = "correntista")
    private List<ContatoCliente> contatos;
    
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
