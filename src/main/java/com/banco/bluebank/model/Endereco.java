package com.banco.bluebank.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel(value = "Endereco", description = "Entidade entitulada Endereco")
@Entity
@Table(name = "endereco")
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "Campo referente ID")
    @Column(name="id_endereco")
    private Long id;

	@ApiModelProperty(required = true, value = "Campo logradouro")
    @NotEmpty(message = "O logradouro deve ser preenchido")
    @Size(min = 1, max = 50, message = "O logradouro deve ter no máximo 50 caracteres")
    @Column(length = 50, nullable = false)
    private String logradouro;

	@ApiModelProperty(required = true, value = "Campo número")
    @NotEmpty(message = "O número deve ser preenchido")
    @Size(min = 1, max = 10, message = "O número deve ter no máximo 10 caracteres")
    @Column(length = 10,nullable = false)
    private String numero;

	@ApiModelProperty(value = "Campo complemento referente cadastro do endereço")
    @Size(max = 25, message = "O complemento deve ter no máximo 25 carecteres")
    @Column(length = 25,nullable = true)  
    private String complemento;

	@ApiModelProperty(required = true, value = "Campo CEP")
    @NotEmpty(message = "O CEP deve ser preenchido")
    @Size(min = 8, max = 8, message = "O CEP deve ter 8 números")
    @Column(length = 8, nullable = false)  
    private String cep;

	@ApiModelProperty(required = true, value = "Campo bairro")
    @NotEmpty(message = "O bairro deve ser preenchido")
    @Size(min = 1, max = 25, message = "O bairro deve ter no máximo 25 caracteres")
    @Column(length = 25, nullable = false)
    private String bairro;

	@ApiModelProperty(required = true, value = "Campo cidade")
    @NotEmpty(message = "A cidade deve ser preenchido")
    @Size(min = 1, max = 30, message = "A cidade deve ter no máximo 30 caracteres")
    @Column(length = 30, nullable = false)
    private String cidade;

	@ApiModelProperty(required = true, value = "Campo estado")
    @NotEmpty(message = "O estado deve ser preenchido")
    @Size(min = 2, max = 2, message = "O estado deve ter 2 carecteres")
    @Column(length = 2, nullable = false)
    private String estado;

	@NotNull(message = "O id do correntista deve ser preenchido")
	@Column(name = "id_correntista", nullable = false)
	@JsonIgnore
	private Long idCorrentista;

	@ApiModelProperty(value = "Campo referente OBJETO CORRENTISTA",
			reference = "Relacionamento Muitas Contas para um Correntista")
    @ManyToOne(optional=false)
    @JoinColumn(name="id_correntista", insertable = false, updatable = false)
	@JsonIgnore
    private Correntista correntista;

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
	
	public String getLogradouro() {
		return logradouro;
	}
	
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getBairro() {
		return bairro;
	}
	
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public Correntista getCorrentista() {
		return correntista;
	}
	
	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}
	
	public Endereco(String logradouro, String numero, String complemento, String cep, String bairro, String cidade,
			String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
    
	public Endereco() {
		
	}

	public Long getIdCorrentista() {
		return idCorrentista;
	}

	public void setIdCorrentista(Long idCorrentista) {
		this.idCorrentista = idCorrentista;
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
		Endereco other = (Endereco) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", cep=" + cep + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado
				+ ", correntista=" + correntista + "]";
	}

}
