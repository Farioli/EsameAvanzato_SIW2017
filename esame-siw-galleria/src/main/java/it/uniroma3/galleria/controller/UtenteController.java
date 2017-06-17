package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.service.UtenteService;

@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	@ModelAttribute("utente")
	public Utente construtto(){
		return new Utente();
	}
	
	@RequestMapping("/utenti")
	public String utenti(Model modello){
		modello.addAttribute("utente", utenteService.findAll());
		return "utenti";
	}
	
	@RequestMapping("/utenti/{id}")
	public String dettagli(Model modello, @PathVariable long id){
		modello.addAttribute("utente", utenteService.findOne(id));
		return "dettagli-utente";
	}
	
	//inserire questo nella voce "Sign-up" della navbar dell'index.
	@RequestMapping("/registratore")
	public String mostraRegistritatore(){
		return "registratore-utente";
	}
	
	@RequestMapping(value="registratore", method=RequestMethod.POST)
	public String eseguiRegistritatore(@ModelAttribute("utente") Utente utente){
		utenteService.save(utente);
		return "registratore-utente";
	}
	
	

}
