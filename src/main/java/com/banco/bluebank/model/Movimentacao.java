package com.banco.bluebank.model;

import java.math.BigDecimal;
import java.util.Date;;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "movimentacao")
public class Movimentacao  extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "id_conta_debito")
	private Conta contaDebito;

	@ManyToOne
	@JoinColumn(name = "id_conta_credito")
	private Conta contaCredito;

	@Column(name="data_movimento")
	private Date dataMovimento;

	private BigDecimal valor;

	private String descricao;

	public Conta getContaDebito() {
		return contaDebito;
	}

	public void setContaDebito(Conta contaDebito) {
		this.contaDebito = contaDebito;
	}

	public Conta getContaCredito() {
		return contaCredito;
	}

	public void setContaCredito(Conta contaCredito) {
		this.contaCredito = contaCredito;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Movimentacao() {

	}

	public Movimentacao(Conta contaDebito, Conta contaCredito, Date dataMovimento, BigDecimal valor, String descricao) {
		this.contaDebito = contaDebito;
		this.contaCredito = contaCredito;
		this.dataMovimento = dataMovimento;
		this.valor = valor;
		this.descricao = descricao;
	}
}
