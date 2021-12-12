package com.banco.bluebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Objects;

@ApiModel(value = "Movimentacao", description = "Entidade entitulada Movimentacao")
@Entity
@Table(name = "movimentacao")
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Campo referente ID")
	@Column(name = "id_movimentacao")
	private Long id;

	@ApiModelProperty(value = "Campo referente OBJETO CONTA TIPO DEBITO",
			reference = "Relacionamento Muitas Contatos para um Conta do Tipo Debito")
	@ManyToOne(optional = false)
	@JoinColumn(name = "num_conta_debito", insertable = false, updatable = false)
	@JsonIgnore
	private Conta contaDebito;

	@ApiModelProperty(value = "Campo referente OBJETO CONTA TIPO CREDITO",
			reference = "Relacionamento Muitas Contatos para um Conta do Tipo cretido")
	@ManyToOne(optional = false)
	@JoinColumn(name = "num_conta_credito", insertable = false, updatable = false)
	@JsonIgnore
	private Conta contaCredito;

	@ApiModelProperty(required = true, value = "Campo referente número da Conta Crédito")
	@NotNull(message = "O número da conta de crédito deve ser preenchido")
	@Column(name = "num_conta_credito", nullable = false)
	private Long numeroContaCredito;

	@ApiModelProperty(required = true, value = "Campo referente número da Conta Debito")
	@NotNull(message = "O número da conta de débito deve ser preenchido")
	@Column(name = "num_conta_debito", nullable = false)
	private Long numeroContaDebito;

	@CreationTimestamp
	@Column(name = "data_movimento",nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataMovimento;

	@ApiModelProperty(value = "Campo referente valor")
	@NotNull(message = "O valor deve ser preenchido")
	@Column(nullable = false)
	private BigDecimal valor;

	@ApiModelProperty(value = "Campo referente descrição")
	@Size(max = 100, message = "A descrição deve ter no máximo 100 caracteres.")
	@Column(length = 100, nullable = true)
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