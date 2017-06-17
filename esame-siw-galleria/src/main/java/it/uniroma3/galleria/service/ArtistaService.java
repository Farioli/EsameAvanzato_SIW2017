package it.uniroma3.galleria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.repository.ArtistaRepository;
import it.uniroma3.galleria.repository.OperaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository artistaRepository;
	
	@Autowired
	private OperaRepository operaRepository;
	
	public Artista findOne(long id){
		return artistaRepository.findOne(id); 
	}
	
	@Transactional
	public Artista findOneWithOpere(long id){
		Artista artista = findOne(id);
		List<Opera> opere = operaRepository.findByArtista(artista, new PageRequest(0,10,Direction.DESC,"anno"));
		artista.setOpere(opere);
		return artista;
	}
	

}
