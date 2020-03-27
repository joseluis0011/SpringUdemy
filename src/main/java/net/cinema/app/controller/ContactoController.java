package net.cinema.app.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.cinema.app.model.Contacto;
import net.cinema.app.service.IPeliculasService;

@Controller
public class ContactoController {

	@Autowired
	IPeliculasService servicePeliculas;
	
	/**
	 * Metodo para mostrar el formulario de contacto
	 * @param contacto
	 * @return
	 */
	@GetMapping("/contacto")
	public String mostrarFormulario(@ModelAttribute("instanciaContacto") Contacto contacto) {
		 
		return "formContacto";
	}
	
	/**
	 * Metodo para guardar los datos del formulario de contacto
	 * @param contacto
	 * @param attributes
	 * @return
	 */
	@PostMapping("/contacto")
	public String guardar(@ModelAttribute("instanciaContacto") Contacto contacto, RedirectAttributes attributes) {
		// El objeto de modelo contacto podria ser almacenado en la BD ...
		System.out.println("Guardando datos del usuario: " + contacto);
		attributes.addFlashAttribute("msg", "Gracias por enviarnos tu opinion!.");
		return "redirect:/contacto";
	}
	
	@ModelAttribute("generos")
	public List<String> getGeneros(){
		return servicePeliculas.buscarGeneros();
	}
}