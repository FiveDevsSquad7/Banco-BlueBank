package com.banco.bluebank.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@ApiModel(value = " Agencia", description = "Entidade entitulada Agencia")
@Entity
@Table(name = "agencia")
public class Agencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Campo ID")
    @Column(name="id_agencia")
    private Long id;

    @ApiModelProperty(value = "Campo referente nome juridico da Agencia")
    @NotBlank(message = "Número da agência deve ser preenchido")
    @Size(min = 2, max = 9, message = "Número da agência deve ter entre 2 e 40 carecteres")
    @Column(length = 9, nullable = false)
    private String agencia;

    @ApiModelProperty(value = "Campo referente nome fantasia da Agencia")
    @NotBlank(message = "Nome da agência deve ser preenchido")
    @Size(min = 2, max = 40, message = "Nome da agência deve ter entre 2 e 40 caracteres")
    @Column(length = 40, name="nome_agencia", nullable = true)
    private String nome;

    @ApiModelProperty(value = "Campo referente data da criação")
    @CreationTimestamp
    @Column(name = "data_cadastro",nullable = false, columnDefinition = "datetime")
    private OffsetDateTime dataCadastro;

    public OffsetDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(OffsetDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Agencia() {
    }

    public Agencia(String agencia, String nome) {
        this.agencia = agencia;
        this.nome = nome;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agencia agencia = (Agencia) o;
        return id == agencia.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

	@Override
	public String toString() {
		return "Agencia id: " + id + " Agencia: " + agencia + " Nome Agencia: " + nome;
	} 
}
