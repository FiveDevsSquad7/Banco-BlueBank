package com.banco.bluebank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "movimentacao")
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_movimentacao")
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "num_conta_debito", insertable = false, updatable = false)
	@JsonIgnore
	private Conta contaDebito;

	@ManyToOne(optional = false)
	@JoinColumn(name = "num_conta_credito", insertable = false, updatable = false)
	@JsonIgnore
	private Conta contaCredito;
	
	//@NotBlank(message = "O número da conta de CRÉDITO deve ser preenchido. Ex: 123-4")
	@Column(name = "num_conta_credito")
	private Long numeroContaCredito;
	
	//@NotBlank(message = "O número da conta de DÉBITO deve ser preenchido. Ex: 123-4")
	@Column(name = "num_conta_debito")
	private Long numeroContaDebito;

	@CreationTimestamp
	@Column(name = "data_movimento",nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataMovimento;
	
	//@NotBlank(message = "Informe o valor da transação. Ex: 2000.02")
	private BigDecimal valor;
	
	@Size(min = 1, max = 45, message = "Descrição entre 1 e 45 caracteres.")
	@Column(length = 45)
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Long getNumeroContaCredito() {
		return numeroContaCredito;
	}

	public void setNumeroContaCredito(Long numeroContaCredito) {
		this.numeroContaCredito = numeroContaCredito;
	}

	public Long getNumeroContaDebito() {
		return numeroContaDebito;
	}

	public void setNumeroContaDebito(Long numeroContaDebito) {
		this.numeroContaDebito = numeroContaDebito;
	}

	public OffsetDateTime getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(OffsetDateTime dataMovimento) {
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
		Movimentacao other = (Movimentacao) obj;
		return Objects.equals(id, other.id);
	}

	public Movimentacao() {

	}

	public Movimentacao(OffsetDateTime dataMovimento, BigDecimal valor, String descricao) {

		this.dataMovimento = dataMovimento;
		this.valor = valor;
		this.descricao = descricao;

	}

}