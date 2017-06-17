package it.uniroma3.galleria.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.repository.UtenteRepository;

@Service
@Transactional
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	public List<Utente> findAll(){
		return utenteRepository.findAll();
		
	}

	public Utente findOne(long id) {
		return utenteRepository.findOne(id);
	}

	public void save(Utente utente) {
		utenteRepository.save(utente);
		
	}

}
