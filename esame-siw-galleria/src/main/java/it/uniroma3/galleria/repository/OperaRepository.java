package it.uniroma3.galleria.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;

public interface OperaRepository extends JpaRepository <Opera, Long> {
	
	List<Opera> findByArtista(Artista artista, Pageable pageable);

}
