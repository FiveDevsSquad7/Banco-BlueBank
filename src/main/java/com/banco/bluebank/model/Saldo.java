package com.banco.bluebank.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@SuppressWarnings("serial")
@Entity
@Table(name = "saldo")
public class Saldo  extends AbstractEntity {

	@Column(name = "data_saldo", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
	private Date dataSaldo;

	@ManyToOne
	@JoinColumn(name = "id_conta")
	private Conta conta;

	private BigDecimal saldo;

	public Date getDataSaldo() {
		return dataSaldo;
	}

	public void setDataSaldo(Date dataSaldo) {
		this.dataSaldo = dataSaldo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public Saldo(Date dataSaldo, Conta conta, BigDecimal saldo) {
		this.dataSaldo = dataSaldo;
		this.conta = conta;
		this.saldo = saldo;
	}

	public Saldo() {

	}
}
