package it.uniroma3.galleria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.repository.ArtistaRepository;
import it.uniroma3.galleria.repository.OperaRepository;

@Service
@Transactional
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository artistaRepository;
	
	@Autowired
	private OperaRepository operaRepository;
	
	public Artista findOne(long id){
		return artistaRepository.findOne(id); 
	}
	
	public List<Artista> findAll() {
		return artistaRepository.findAll();
	}
	
	
	public Artista findOneWithOpere(long id){
		Artista artista = findOne(id);
		List<Opera> opere = operaRepository.findByArtista(artista);
		artista.setOpere(opere);
		return artista;
	}
	
	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void save(Artista artista) {
		artistaRepository.save(artista);
	}
	
	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void delete(long id) {
		artistaRepository.delete(id);
	}
	
	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void delete(Artista artista) {
		artistaRepository.delete(artista);
	}

}
