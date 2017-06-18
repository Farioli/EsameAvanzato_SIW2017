package it.uniroma3.galleria.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="app_utente")
public class Utente {
	
	@Id
	@GeneratedValue()
	private Long id;
	
	@NotNull(message="Campo obbligatorio")
	private String nome;
		
	@Size(min=1, message="Email non valida!")
	@Email(message="Email non valida!")
	@Column(unique=true)
	private String email;
	
	@Size(min=5, message="La password deve essere minimo di 5 caratteri")
	private String password;
	
	@ManyToMany
	@JoinTable
	private List<Ruolo> ruoli;
	
	private boolean enabled;
	
	//Getters & setters

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(List<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public int hashCode() {
		return this.nome.hashCode()+this.email.hashCode() + this.password.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	
}
