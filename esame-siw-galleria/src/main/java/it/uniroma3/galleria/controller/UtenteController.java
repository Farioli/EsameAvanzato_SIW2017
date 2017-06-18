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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.service.ArtistaService;
import it.uniroma3.galleria.service.UtenteService;

@Controller
public class UtenteController {
	
	@Autowired
	private UtenteService utenteService;
	
	
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
	
	@RequestMapping("/registratore")
	public String mostraRegistritatore(){
		return "formUtente";
	}
	
	@RequestMapping(value="/registratore", method=RequestMethod.POST)
	public String eseguiRegistritazione(@Valid @ModelAttribute("utente") Utente utente, BindingResult risultato, RedirectAttributes redirectAttributes){
		if(risultato.hasErrors()){
			return "formUtente";
		}
		else{
			utenteService.save(utente);
			redirectAttributes.addFlashAttribute("success",true);
			return "redirect:/formUtente";
		}
	}
	

}
