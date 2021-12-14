package com.banco.bluebank.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

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

    @ApiModelProperty(required = true,value = "Campo referente número da Agencia")
    @NotEmpty(message = "O número da agência deve ser preenchido")
    @Size(min = 1, max = 9, message = "O número da agência deve ter no máximo 9 carecteres")
    @Column(length = 9, nullable = false)
    private String agencia;

    @ApiModelProperty(required = true,value = "Campo referente nome da Agencia")
    @NotEmpty(message = "O nome da agência deve ser preenchido")
    @Size(min = 2, max = 40, message = "O nome da agência deve ter no máximo 40 caracteres")
    @Column(length = 40, name="nome_agencia", nullable = false)
    private String nome;

    @CreationTimestamp
    @Column(name = "data_cadastro", insertable = true, updatable = false, nullable = false, columnDefinition = "datetime")
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
        String dtCadastro = (dataCadastro != null)?dataCadastro.toString():"null";
        return "Agencia{" +
                "id=" + id +
                ", agencia='" + agencia + '\'' +
                ", nome='" + nome + '\'' +
                ", dataCadastro=" + dtCadastro +
                '}';
    }
}
