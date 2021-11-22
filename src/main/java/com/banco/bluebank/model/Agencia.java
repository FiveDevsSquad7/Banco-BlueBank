package com.banco.bluebank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
@Entity
@Table(name = "agencia")
public class Agencia  extends AbstractEntity {

    private String agencia;

    @Column(name="nome_agencia")
    private String nome;

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
}
