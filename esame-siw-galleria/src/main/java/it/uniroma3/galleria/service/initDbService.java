package it.uniroma3.galleria.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Ruolo;
import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.repository.ArtistaRepository;
import it.uniroma3.galleria.repository.OperaRepository;
import it.uniroma3.galleria.repository.RuoloRepository;
import it.uniroma3.galleria.repository.UtenteRepository;

@Transactional
@Service
public class initDbService {
	
	@Autowired
	private RuoloRepository ruoloRepository;
	
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private ArtistaRepository artistaRepository;
	
	@Autowired
	private OperaRepository operaRepository;
	
	@PostConstruct
	public void init(){
		
		Ruolo ruoloUtente = new Ruolo();
		ruoloUtente.setNome("RUOLO_UTENTE");
		ruoloRepository.save(ruoloUtente);
		
		Ruolo ruoloAmministratore = new Ruolo();
		ruoloAmministratore.setNome("RUOLO AMMINISTRATORE");
		ruoloRepository.save(ruoloAmministratore);
		
		Utente utenteAmministratore = new Utente();
		utenteAmministratore.setNome("amministratore");
		BCryptPasswordEncoder codificatore = new BCryptPasswordEncoder();
		utenteAmministratore.setPassword(codificatore.encode("amministratore"));
		utenteAmministratore.setEnabled(true);
		List<Ruolo> ruoli = new ArrayList<Ruolo>();
		ruoli.add(ruoloAmministratore);
		ruoli.add(ruoloUtente);
		utenteAmministratore.setRuolo(ruoli);
		utenteRepository.save(utenteAmministratore);
		
		//Artista artista = new Artista();
		
	}

}
