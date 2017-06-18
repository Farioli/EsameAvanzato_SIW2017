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

import it.uniroma3.galleria.model.Artista;
import it.uniroma3.galleria.model.Opera;
import it.uniroma3.galleria.service.ArtistaService;

@Controller
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;
	
	@ModelAttribute("artista")
	public Artista construtto(){
		return new Artista();
	}
	
	@RequestMapping("/artisti")
	public String opere(Model modello){
		modello.addAttribute("artisti", artistaService.findAll());
		return "artisti";
	}
	
	@RequestMapping("/artisti/{id}")
	public String dettagli(Model modello, @PathVariable long id){
		modello.addAttribute("artista", artistaService.findOne(id));
		return "dettagli-artista";
	}
	
	@RequestMapping("/formArtista")
	public String formArtista(){
		return "form-Artista";
	}
	
	@RequestMapping(value="/formArtista", method=RequestMethod.POST)
	public String registraArtista(@Valid @ModelAttribute("artista") Artista artista, BindingResult risultato, RedirectAttributes redirectAttributes){
		if(risultato.hasErrors()){
			return "form-Artista";
		}
		else{
			artistaService.save(artista);
			redirectAttributes.addFlashAttribute("success",true);
			return "redirect:/formArtista";
		}
	}
	

}
