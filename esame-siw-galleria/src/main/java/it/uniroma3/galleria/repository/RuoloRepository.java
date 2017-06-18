package it.uniroma3.galleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.galleria.model.Ruolo;

public interface RuoloRepository extends JpaRepository <Ruolo, Long> {

	Ruolo findByNome(String nome);

}
