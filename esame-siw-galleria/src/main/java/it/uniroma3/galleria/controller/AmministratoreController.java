package it.uniroma3.galleria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.service.ArtistaService;
import it.uniroma3.galleria.service.OperaService;
import it.uniroma3.galleria.service.UtenteService;

@Controller
@RequestMapping("/utenti")
public class AmministratoreController {
	
	@Autowired
	private UtenteService utenteService;
	private ArtistaService artistaService;
	private OperaService operaService;
	
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
		return "redirect:/utenti";
	}
	
	@RequestMapping("artisti/rimuovi/{id}")
	public String rimuoviArtista(@PathVariable long id){
		Artista artista = artistaService.findOne(id);
		artistaService.delete(artista);
		return "redirect:/artisti.html";
	}
	
	@RequestMapping("opere/rimuovi/{id}")
	public String rimuoviOpera(@PathVariable long id){
		Opera opera = operaService.findOne(id);
		operaService.delete(opera);
		return "redirect:/opere.html";
	}
	
	

}
