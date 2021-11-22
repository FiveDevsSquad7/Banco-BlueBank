package com.banco.bluebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "conta")
public class Conta  extends AbstractEntity {

	@Column(name="num_conta")
	private Integer numeroConta;

	@Column(name="tipo_conta")
	private String tipoConta;

	@ManyToOne
	@JoinColumn(name="id_correntista")
	private Correntista correntista;

	@ManyToOne
	@JoinColumn(name="id_agencia")
	private Agencia agencia;

	private int digito;

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
}
