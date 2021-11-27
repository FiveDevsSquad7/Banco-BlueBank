package com.banco.bluebank.model;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

@Entity
@Table(name = "contato_cliente")
public class ContatoCliente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contato_pessoa")
    private Long id;
    
    @NotBlank(message = "Telefone deve ser preenchido")
    @Size(min = 8, max = 15, message = "Telefone deve ter no mínimo 8 e no máximo 15 números")
    @Column(length = 15, nullable = true)
    private String telefone;
    
    @NotBlank(message = "Email deve ser preenchido")
    @Size(min = 10, max = 50, message = "Email deve ter no mínimo 8 e no máximo 15 carecteres")
    @Column(length = 50, nullable = false)
    private String email;
    
    @NotBlank(message = "Recado deve ser preenchido")
    @Size(min = 10, max = 50, message = "Recado deve ter no mínimo 10 e no máximo 50 caracteres")
    @Column(name="info_recado",length = 50, nullable = true)
    private String infoRecado;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="id_correntista")
    private Correntista correntista;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfoRecado() {
		return infoRecado;
	}

	public void setInfoRecado(String infoRecado) {
		this.infoRecado = infoRecado;
	}
	
	public Correntista getCorrentista() {
		return correntista;
	}

	public void setCorrentista(Correntista correntista) {
		this.correntista = correntista;
	}

	public ContatoCliente(String telefone, String email, String infoRecado) {
		this.telefone = telefone;
		this.email = email;
		this.infoRecado = infoRecado;
	}

	public ContatoCliente() {
		
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
		ContatoCliente other = (ContatoCliente) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "ContatoCliente [id=" + id + ", telefone=" + telefone + ", email=" + email + ", infoRecado=" + infoRecado
				+ ", correntista=" + correntista + "]";
	}
	
	
}
