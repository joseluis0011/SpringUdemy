package net.cinema.app.controller;
 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.cinema.app.model.Banner;
import net.cinema.app.model.Horario;
import net.cinema.app.model.Noticia;
import net.cinema.app.model.Pelicula;
import net.cinema.app.service.IBannersService;
import net.cinema.app.service.IHorariosService;
import net.cinema.app.service.INoticiasService;
import net.cinema.app.service.IPeliculasService;
import net.cinema.app.util.Utileria;
 

@Controller
public class HomeController {
	
	@Autowired
	private IBannersService serviceBanners;
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IHorariosService serviceHorarios;
	
	@Autowired
	private INoticiasService serviceNoticias;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	 
	
	@RequestMapping(value = "/search", method=RequestMethod.POST)
	public String buscar(@RequestParam("fecha") Date fecha, Model model) {		
		try {			
			Date fechaSinHora = dateFormat.parse(dateFormat.format(fecha));
			List<String> listaFechas = Utileria.getNextDays(4);
			List<Pelicula> peliculas  = servicePeliculas.buscarPorFecha(fechaSinHora);
			model.addAttribute("fechas", listaFechas);			
			// Regresamos la fecha que selecciono el usuario con el mismo formato
			model.addAttribute("fechaBusqueda",dateFormat.format(fecha));			
			model.addAttribute("peliculas", peliculas);			
			return "home";
		} catch (ParseException e) {
			System.out.println("Error: HomeController.buscar" + e.getMessage());
		}
		return "home";
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		try {
			Date fechaSinHora = dateFormat.parse(dateFormat.format(new Date()));
			List<String> listaFechas = Utileria.getNextDays(4);		
			List<Pelicula> peliculas = servicePeliculas.buscarPorFecha(fechaSinHora);			
			model.addAttribute("fechas", listaFechas);
			model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
			model.addAttribute("peliculas", peliculas);
		} catch (ParseException e) {
			System.out.println("Error: HomeController.mostrarPrincipal" + e.getMessage());
		}
		return "home";
	} 
	  
	@RequestMapping(value = "/detail/{id}/{fecha}") 
	public String mostrarDetalle(@PathVariable("id") int idPelicula,@PathVariable("fecha") Date fecha, Model model) {
		
		List<Horario> horarios = serviceHorarios.buscarPorIdPelicula(idPelicula, fecha);
		model.addAttribute("horarios",horarios);
		model.addAttribute("fechaBusqueda",dateFormat.format(fecha));
		model.addAttribute("pelicula",servicePeliculas.buscarPorId(idPelicula));
		return "detalle";
	}
	
	/**
	 * Metodo que muestra la vista de la pagina de Acerca
	 * @return
	 */
	@RequestMapping(value = "/about")
	public String mostrarAcerca() {			
		return "acerca";
	}
	
	@RequestMapping(value = "/formLogin",method = RequestMethod.GET)
	public String mostrarLogin() {
		return "formLogin";
	}
	
	@ModelAttribute("noticias")
	public List<Noticia> getNoticias(){
		return serviceNoticias.buscarUltimas();
	}
	
	@ModelAttribute("banners")
	public List<Banner> getBanners(){
		return serviceBanners.buscarActivos();
	}
	
	// FORMATEAR LA FECHA
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {		
	   SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");		
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
