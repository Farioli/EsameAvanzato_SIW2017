package it.uniroma3.galleria.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Ruolo;
import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.repository.RuoloRepository;
import it.uniroma3.galleria.repository.UtenteRepository;

@Service
@Transactional
public class UtenteService {
	
	@Autowired
	private UtenteRepository utenteRepository;
	@Autowired
	private RuoloRepository ruoloRepository;
	
	public List<Utente> findAll(){
		return utenteRepository.findAll();
		
	}

	public Utente findOne(long id) {
		return utenteRepository.findOne(id);
	}
	
	public Utente findOneWithNome(String nome) {
		Utente utente = utenteRepository.findByNome(nome);
		return findOne(utente.getId());
	}
	
	public Utente findOneWithEmail(String emailUser) {
		Utente utente = utenteRepository.findByEmail(emailUser);
		return findOne(utente.getId());
	}


	
	public void save(Utente utente) {
		utente.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		utente.setPassword(encoder.encode(utente.getPassword()));
		
		List<Ruolo> ruoli = new ArrayList<Ruolo>();
		ruoli.add(ruoloRepository.findByNome("RUOLO_UTENTE"));
		utente.setRuoli(ruoli);
		
		utenteRepository.save(utente);
	}
	
	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void delete(long id){
		utenteRepository.delete(id);
	}

	@PreAuthorize("hasRole('RUOLO_AMMINISTRATORE')")
	public void delete(Utente utente) {
		utenteRepository.delete(utente);
		
	}

}
