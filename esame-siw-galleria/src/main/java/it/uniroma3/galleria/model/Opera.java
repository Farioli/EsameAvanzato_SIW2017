package it.uniroma3.galleria.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue()
	private Long id;
	
	@Size(min=1, message="Il nome deve essere di minimo un carattere")
	private String titolo;
	
	@Min(value=1, message="L'anno non pu� essere negativo!")
	@NotNull(message="Campo obbligatorio")
	private int anno;
	
	@NotNull(message="Campo obbligatorio")
	private String tecnica;
	
	@NotNull(message="Campo obbligatorio")
	@Column(name="dimensione_base")
	private float dimensioneAltezza;
	
	@NotNull(message="Campo obbligatorio")
	@Column(name="dimensione_base")
	private float dimensioneBase;
	
	@NotNull(message="Campo obbligatorio")
	@ManyToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(name="artista_id")
	private Artista artista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public float getDimensioneAltezza() {
		return dimensioneAltezza;
	}

	public void setDimensioneAltezza(float dimensioneAltezza) {
		this.dimensioneAltezza = dimensioneAltezza;
	}

	public float getDimensioneBase() {
		return dimensioneBase;
	}

	public void setDimensioneBase(float dimensioneBase) {
		this.dimensioneBase = dimensioneBase;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	
}
