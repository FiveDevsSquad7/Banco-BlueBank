package com.banco.bluebank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "movimentacao")
public class Movimentacao  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimentacao")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_conta_debito")
    private Conta contaDebito;
    
    @ManyToOne
    @JoinColumn(name = "id_conta_credito")
    private Conta contaCredito;
    
    @Column(name="data_movimento")
    private Date dataMovimento;
    
    @NotNull(message = "Valor deve ser preenchido")
    @Size(min = 1, max = 10, message = "Valor deve ter entre 1:10 dígitos")
    @Column(length = 10, nullable = false)
    private BigDecimal valor;
    
    
    @NotBlank(message = "Descrição deve ser preenchido")
    @Size(min = 5, max = 45, message = "Descrição deve ter entre 5:45 dígitos")
    @Column(length = 45, nullable = true)
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
	
	public Movimentacao(Conta contaDebito, Conta contaCredito, Date dataMovimento, BigDecimal valor, String descricao) {
		this.contaDebito = contaDebito;
		this.contaCredito = contaCredito;
		this.dataMovimento = dataMovimento;
		this.valor = valor;
		this.descricao = descricao;
	}
}
