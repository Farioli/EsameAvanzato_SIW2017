package it.uniroma3.galleria.controller;

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

import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.model.Utente;
import it.uniroma3.galleria.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	
	@ModelAttribute("opera")
	public Opera construtto(){
		return new Opera();
	}
	
	@RequestMapping("/opere")
	public String opere(Model modello){
		modello.addAttribute("opere", operaService.findAll());
		return "opere";
	}
	
	@RequestMapping("/opere/{id}")
	public String dettagli(Model modello, @PathVariable long id){
		modello.addAttribute("opera", operaService.findOne(id));
		return "dettagli-opera";
	}
	
	@RequestMapping("/formOpera")
	public String formOpera(){
		return "form-Opera";
	}
	
	@RequestMapping(value="/formOpera", method=RequestMethod.POST)
	public String registraOpera(@Valid @ModelAttribute("opera") Opera opera, BindingResult risultato, RedirectAttributes redirectAttributes){
		if(risultato.hasErrors()){
			return "formOpera";
		}
		else{
			operaService.save(opera);
			redirectAttributes.addFlashAttribute("success",true);
			return "redirect:/formOpera";
		}
	}
	

}
