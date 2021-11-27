package com.banco.bluebank.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "conta")
public class Conta  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conta")
    private Long id;
    
    @NotNull(message = "Número da Conta deve ser preenchido")
    @Size(min = 2, max = 9, message = "Número da Conta deve ter entre 2 e 9 dígitos")
    @Column(name="num_conta",length = 9)
    private Integer numeroConta;
    
    
    @NotBlank(message = "Número da Conta deve ser preenchido")
    @Size(min = 2, max = 2, message = "Tipo da Conta deve ter entre 2 dígitos")
    @Column(name="tipo_conta",length = 2)
    private String tipoConta;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_correntista")
    private Correntista correntista;
    
    @NotNull
    @ManyToOne(optional=false)
    @JoinColumn(name="id_agencia")
    private Agencia agencia;
    
    
    @NotBlank(message = "O Dígito deve ser computado")
    @Size(min = 1, max = 1, message = "O digito deve ter 1 digito")
    private int digito;
    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}
	
	public int getDigito() {
		return digito;
	}
	
	public void setDigito(int digito) {
		this.digito = digito;
	}
	
	public String getTipoConta() {
		return tipoConta;
	}
	
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
	
	public Correntista getCorrentista() {
		return correntista;
	}
	
	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}
	
	public Agencia getAgencia() {
		return agencia;
	}
	
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	
	public Conta(Integer numeroConta, int digito, String tipoConta, Correntista correntista, Agencia agencia) {
		this.numeroConta = numeroConta;
		this.digito = digito;
		this.tipoConta = tipoConta;
		this.correntista = correntista;
		this.agencia = agencia;
	}
	
	public Conta() {
		
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
		Conta other = (Conta) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "Conta [id=" + id + ", numeroConta=" + numeroConta + ", tipoConta=" + tipoConta + ", correntista="
				+ correntista + ", agencia=" + agencia + ", digito=" + digito + "]";
	}
}
