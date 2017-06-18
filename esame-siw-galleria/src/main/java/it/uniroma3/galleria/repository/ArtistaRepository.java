package it.uniroma3.galleria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.galleria.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
	

	Artista findByNome(String nome);

	List<Artista> findAllByNome(String nome);
	
	

}
