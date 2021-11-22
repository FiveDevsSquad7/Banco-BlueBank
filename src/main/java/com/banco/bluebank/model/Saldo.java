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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;



@Entity
@Table(name = "saldo")
public class Saldo  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_saldo")
    private Long id;
    
    @Column(name = "data_saldo", nullable = false)
	@DateTimeFormat(iso = ISO.DATE)
    private Date dataSaldo;
    
    @ManyToOne
    @JoinColumn(name = "id_conta")
    private Conta conta;
    
    private BigDecimal saldo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
		Saldo other = (Saldo) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Saldo [id=" + id + ", dataSaldo=" + dataSaldo + ", conta=" + conta + ", saldo=" + saldo + "]";
	}

}
