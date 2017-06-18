package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.service.UtenteService;

@Controller
@RequestMapping("/utenti")
public class AmministratoreController {
	
	@Autowired
	private UtenteService utenteService;
	
	@RequestMapping
	public String utenti(Model modello){
		modello.addAttribute("utente", utenteService.findAll());
		return "utenti";
	}
	
	@RequestMapping("/{id}")
	public String dettagliUtente(Model modello, @PathVariable long id){
		modello.addAttribute("utente", utenteService.findOne(id));
		return "dettagli-utente";
	}
	
	@RequestMapping("/rimuovi/{id}")
	public String rimuoviUtente(@PathVariable long id){
		Utente utente = utenteService.findOne(id);
		utenteService.delete(utente);
		return "redirect:/utenti.html";
	}
	
	

}
