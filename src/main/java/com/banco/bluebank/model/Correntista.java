package com.banco.bluebank.model;

import com.banco.bluebank.utils.CpfCnpj;
import com.banco.bluebank.utils.TipoPessoa;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.*;

@ApiModel(value = "Correntista", description = "Entidade entitulada Correntista")
@Entity
@Table(name = "correntista")
public class Correntista implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "Campo ID")
    @Column(name = "id_correntista")
    private Long id;

    @ApiModelProperty(required = true, value = "Campo Nome do correntista")
    @Column(length = 50, nullable = false)
    @NotEmpty(message = "O nome do correntista deve ser preenchido")
    @Size(min = 1, max = 50, message = "Nome do correntista deve ter no máximo 50 caracteres")
    private String nome;

    @ApiModelProperty(value = "Campo CPF")
    @CpfCnpj(message = "Número de CPF inválido")
    @Column(name = "cpf", length = 11, nullable = true)
    private String cpf;

    @ApiModelProperty(value = "Campo RG")
    @Size(min = 2, max = 11, message = "O RG do correntista deve até 20 caracteres")
    @Column(length = 20, nullable = true)
    private String rg;

    @ApiModelProperty(value = "Campo CNPJ")
    @CpfCnpj(message = "Número de CNPJ inválido")
    @Column(name = "cnpj", length = 14, nullable = true)
    private String cnpj;

    @ApiModelProperty(required = true, value = "Campo Tipo de Pessoa: Fisica ou Juridica")
    @NotEmpty(message = "O campo tipo de pessoa deve ser preenchido")
    @TipoPessoa(message = "O tipo de pessoa deve ser 'F' para física ou 'J' para jurídica")
    @Column(name = "pf_pj", length = 1, nullable = false)
    private String tipoPessoa;

    @ApiModelProperty(value = "Campo E-mail para notificar movimentação")
    @Email(message = "O email deve conter um valor válido")
    @Column(name = "email_validacao", length = 50, nullable = true)
    private String emailValidacao;

    @ApiModelProperty(value = "Campo SMS para notificar movimentação")
    @Size(max = 20, message = "O telefone para SMS deve ter no máximo 20 caracteres")
    @Column(name = "sms_validacao", length = 20, nullable = true)
    private String smsValidacao;

    @ApiModelProperty(value = "Campo Endereço do correntista")
    @OneToMany(mappedBy = "correntista", cascade = CascadeType.REMOVE)
    @Column(insertable = false, updatable = false)
    private List<Endereco> enderecos = new ArrayList<>();

    @ApiModelProperty(value = "Campo Objeto Contato relacionado Correntista")
    @OneToMany(mappedBy = "correntista", cascade = CascadeType.REMOVE)
    @Column(insertable = false, updatable = false)
    private List<ContatoCliente> contatos = new ArrayList<>();

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getEmailValidacao() {
        return emailValidacao;
    }

    public void setEmailValidacao(String emailValidacao) {
        this.emailValidacao = emailValidacao;
    }

    public String getSms() {
        return smsValidacao;
    }

    public void setSms(String sms) {
        this.smsValidacao = sms;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<ContatoCliente> getContatos() {
        return contatos;
    }

    public void setContatos(List<ContatoCliente> contatos) {
        this.contatos = contatos;
    }

    public Correntista(String nome, String cpf, String rg, String cnpj, String tipopessoa, String emailValidacao, String smsValidacao) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.cnpj = cnpj;
        this.tipoPessoa = tipopessoa;
        this.emailValidacao = emailValidacao;
        this.smsValidacao = smsValidacao;
    }

    public Correntista() {

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
        Correntista other = (Correntista) obj;
        return id == other.id;
    }

    @Override
    public String toString() {
        return "Correntista [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", rg=" + rg + ", cnpj=" + cnpj
                + ", tipoPessoa=" + tipoPessoa + ", emailValidacao=" + emailValidacao + ", smsValidacao=" + smsValidacao
                + ", enderecos=" + enderecos + ", contatos=" + contatos + "]";
    }

}
