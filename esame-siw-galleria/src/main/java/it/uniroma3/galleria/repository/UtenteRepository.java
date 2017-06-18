package it.uniroma3.galleria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.galleria.model.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

	Utente findByNome(String nome);
	
	Utente findByEmail(String email);


}
