package it.uniroma3.galleria.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.service.ArtistaService;
import it.uniroma3.galleria.service.UtenteService;

@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private ArtistaService artistaService;
	
	@ModelAttribute("utente")
	public Utente construtto(){
		return new Utente();
	}
	
	@RequestMapping(value="/account")
	public String account(Model modello, Principal principale){
		String nomeUtente = principale.getName();
		modello.addAttribute("utente", utenteService.findOneWithNome(nomeUtente));
		return "dettagli-utente";
	}
	
	@RequestMapping("artista/rimuovi/{id}")
	public String rimuoviArtista(@PathVariable long id){
		Artista artista = artistaService.findOne(id);
		artistaService.delete(artista);
		return "redirect:/artisti.html";
	}
	

}
