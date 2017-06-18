package it.uniroma3.galleria.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;
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
		
		List<Ruolo> ruoli = new ArrayList<Ruolo>();
		ruoli.add(ruoloAmministratore);
		ruoli.add(ruoloUtente);
		
		Utente utenteAmministratore = new Utente();
		utenteAmministratore.setNome("amministratore");
		utenteAmministratore.setEmail("admin@gmail.com");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		utenteAmministratore.setPassword(encoder.encode("admin"));
		utenteAmministratore.setEnabled(true);
		utenteAmministratore.setRuoli(ruoli);
		utenteRepository.save(utenteAmministratore);
		
		Utente utenteAmministratore2 = new Utente();
		utenteAmministratore2.setNome("amministratore_2");
		utenteAmministratore2.setEmail("admin2@gmail.com");
		utenteAmministratore2.setPassword(encoder.encode("admin2"));
		utenteAmministratore2.setEnabled(true);
		utenteAmministratore2.setRuoli(ruoli);
		utenteRepository.save(utenteAmministratore2);
		
		Artista artista = new Artista();
		artista.setNome("John");
		artista.setCognome("Avon");
		artista.setNazionalita("Inglese");
		
		//RISOLVERE!!
		artista.setDataNascita(new Date("6/6/1967"));
		
		
		Opera opera = new Opera();
		opera.setTitolo("Mountains");
		opera.setAnno(1998);
		opera.setTecnica("Olio su tela");
		opera.setDimensioneAltezza(57);
		opera.setDimensioneBase(31);
		
		artistaRepository.save(artista);
		opera.setArtista(artista);
		operaRepository.save(opera);
		
	}

}
