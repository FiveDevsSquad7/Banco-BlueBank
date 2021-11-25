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

import com.banco.bluebank.model.dto.output.CorrentistaOutputDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "conta")
public class Conta  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_conta")
    private Long id;
    
    @Column(name="num_conta")
    private Integer numeroConta;
    
    @Column(name="tipo_conta")
    private String tipoConta;
    
    @ManyToOne
    @JoinColumn(name="id_correntista", insertable = false, updatable = false)
    private Correntista correntista;
    
    @ManyToOne
    @JoinColumn(name = "id_agencia", insertable = false, updatable = false)
    private Agencia agencia;
    
    @Column(name = "id_correntista")
    @JsonIgnore
    private Long idCorrentista;
    
    @Column(name = "id_agencia")
    @JsonIgnore
    private Long idAgencia;
    
    private int digito;
        
	public Long getIdCorrentista() {
		return idCorrentista;
	}

	public void setIdCorrentista(Long idCorrentista) {
		this.idCorrentista = idCorrentista;
	}

	public Long getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(Long idAgencia) {
		this.idAgencia = idAgencia;
	}

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
	
	public Conta(Integer numeroConta, String tipoConta, Correntista correntista, Agencia agencia, Long idCorrentista,
			Long idAgencia, int digito) {
		super();
		this.numeroConta = numeroConta;
		this.tipoConta = tipoConta;
		this.correntista = correntista;
		this.agencia = agencia;
		this.idCorrentista = idCorrentista;
		this.idAgencia = idAgencia;
		this.digito = digito;
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
