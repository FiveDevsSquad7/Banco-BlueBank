package com.banco.bluebank.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Agencia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_agencia")
    private int id;

    private String agencia;

    @Column(name="nome_agencia")
    private String nome;

    public int getId() {
        return id;
    }

    public Agencia() {
    }

    public Agencia(int id, String agencia, String nome) {
        this.id = id;
        this.agencia = agencia;
        this.nome = nome;
    }

    public void setId(int id) {
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
}
