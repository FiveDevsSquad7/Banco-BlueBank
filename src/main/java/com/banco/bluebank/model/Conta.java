package com.banco.bluebank.model;

import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "conta")
public class Conta  implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="num_conta")
    private Long numeroConta;
    
    @NotBlank(message = "Tipo da Conta deve ser preenchido")
    @Size(max = 2, message = "Tipo da Conta deve CC para conta corrente e PP para poupanca")
    @Column(name="tipo_conta",length = 2, nullable = false)
    private String tipoConta;
   
    @ManyToOne
    @JoinColumn(name="id_correntista", insertable = false, updatable = false)
    private Correntista correntista;
    
    @ManyToOne(optional=false)
    @JoinColumn(name = "id_agencia", insertable = false, updatable = false)
    private Agencia agencia;
    
    @JsonIgnore
    @Column(name = "id_correntista")
    private Long idCorrentista;
    
    @JsonIgnore
    @Column(name = "id_agencia")
    private Long idAgencia;

	@CreationTimestamp
	@Column(name = "data_cadastro",nullable = false, columnDefinition = "datetime")
	private OffsetDateTime dataCadastro;

	public OffsetDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(OffsetDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

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

	public Long getNumeroConta() {
		return numeroConta;
	}
	
	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
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
		this.tipoConta = tipoConta;
		this.correntista = correntista;
		this.agencia = agencia;
		this.idCorrentista = idCorrentista;
		this.idAgencia = idAgencia;
	}

	public Conta() {
		
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Conta conta = (Conta) o;

		return numeroConta.equals(conta.numeroConta);
	}

	@Override
	public int hashCode() {
		return numeroConta.hashCode();
	}

	@Override
	public String toString() {
		return "Conta{" +
				"numeroConta=" + numeroConta +
				", tipoConta='" + tipoConta + '\'' +
				", correntista=" + correntista.getNome() +
				", agencia=" + agencia.getNome() +
				", idCorrentista=" + idCorrentista +
				", idAgencia=" + idAgencia +
				", dataCadastro=" + dataCadastro +
				'}';
	}
}
