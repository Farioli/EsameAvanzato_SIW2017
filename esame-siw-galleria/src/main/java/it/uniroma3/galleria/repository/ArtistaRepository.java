package it.uniroma3.galleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.galleria.model.Artista;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

}
