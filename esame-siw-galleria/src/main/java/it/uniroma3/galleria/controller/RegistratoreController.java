package it.uniroma3.galleria.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.service.UtenteService;

@Controller
public class RegistratoreController {
	
	private UtenteService utenteService;

	//inserire questo nella voce "Sign-up" della navbar dell'index.
		@RequestMapping("/registratore")
		public String mostraRegistritatore(){
			return "registratore-utente";
		}
		
		@RequestMapping(value="/registratore", method=RequestMethod.POST)
		public String eseguiRegistritazione(@Valid @ModelAttribute("utente") Utente utente, BindingResult risultato, RedirectAttributes redirectAttributes){
			if(risultato.hasErrors()){
				return "registratore-utente";
			}
			utenteService.save(utente);
			redirectAttributes.addFlashAttribute("success",true);
			return "redirect:/registratore-utente.html";
		}

}
