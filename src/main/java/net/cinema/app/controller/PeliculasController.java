package net.cinema.app.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;  

import net.cinema.app.model.Pelicula;
import net.cinema.app.service.IDetallesService;
import net.cinema.app.service.IPeliculasService;
import net.cinema.app.util.Utileria;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {
	
	@Autowired
	private IDetallesService serviceDetalles;
	
	@Autowired
	private IPeliculasService servicePelicula;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Pelicula> lista =servicePelicula.buscarTodas();
		model.addAttribute("peliculas" , lista);
		return "peliculas/listPeliculas";
	}
		
	/**
	 * Metodo que muestra la lista de peliculas con paginacion
	 * @param model
	 * @param page
	 * @return
	 */
	@GetMapping(value = "/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Pelicula> lista = servicePelicula.buscarTodas(page);
		model.addAttribute("peliculas", lista);
		return "peliculas/listPeliculas";
	}
	
	
	@GetMapping("/create")
	public String crear(@ModelAttribute Pelicula pelicula,Model model) { 
		return "peliculas/fromPeliculas";
	} 
	
	@PostMapping("/save")
	public String guardar(@ModelAttribute Pelicula pelicula , BindingResult result,RedirectAttributes attributes,
			@RequestParam("archivoImagen") MultipartFile multiPart,HttpServletRequest request) {
		// VER LOS ERRORES DEL FORMULARIO
		if (result.hasErrors()) {
			System.out.println("errs");
			return "peliculas/fromPeliculas";
		}
		if (!multiPart.isEmpty()) {
			String nombreImagen =Utileria.guardarImagen(multiPart, request);
			pelicula.setImagen(nombreImagen);
		}	  
		serviceDetalles.insertar(pelicula.getDetalle()); 
		servicePelicula.insertar(pelicula); 
		attributes.addFlashAttribute("mensaje","El Registro fue guardado ");
		 
		return "redirect:/peliculas/indexPaginate";	
	}
	
	@GetMapping(value = "/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula, Model model) {
		 
		Pelicula pelicula =servicePelicula.buscarPorId(idPelicula);
		model.addAttribute("pelicula",pelicula);
		return "peliculas/fromPeliculas";
	}
	
	@GetMapping(value = "/delete/{id}")
	public String eliminar(@PathVariable("id") int idPelicula,RedirectAttributes attributes) {
		Pelicula pelicula = servicePelicula.buscarPorId(idPelicula);
		// primero eliminar la pelicula
		servicePelicula.eliminar(idPelicula);
		// despues eliminar los detaalles
		serviceDetalles.eliminar(pelicula.getDetalle().getId());
		
		attributes.addFlashAttribute("mensaje","La pelicula fue eliminada");
		return "redirect:/peliculas/indexPaginate";
	}
	
	@ModelAttribute("generos") // nivel global generos para todos los metodos
	public List<String> getGeneros(){
		return  servicePelicula.buscarGeneros();
	}
	
	// FORMATEAR LA FECHA
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class,"fechaEstreno", new CustomDateEditor(dateformat, false));
	}
}
