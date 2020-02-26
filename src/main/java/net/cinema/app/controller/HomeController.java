package net.cinema.app.controller;
 
import java.text.SimpleDateFormat;
import java.util.Date; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.cinema.app.model.Pelicula;
import net.cinema.app.service.IPeliculasService;
import net.cinema.app.util.Utileria;
 

@Controller
public class HomeController {
	
	@Autowired
	private IPeliculasService servicePeliculas;
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/home", method=RequestMethod.GET)
	public String goHome() {
		return "home";
	}
	
	@RequestMapping(value ="search",method = RequestMethod.POST )
	public String buscar(@RequestParam("fecha") String fecha,Model model) {
		List<String> listaFechas =Utileria.getNextDays(4); 
		List<Pelicula> peliculas= servicePeliculas.buscarTodas(); 
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda", fecha);
		model.addAttribute("peliculas", peliculas);
		
		System.out.println("buscando peliculas " + fecha);
		return "home";
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String mostrarPrincipal(Model model) {
		List<String> listaFechas =Utileria.getNextDays(4); 
		
		List<Pelicula> peliculas= servicePeliculas.buscarTodas();
	//	peliculas.add("Rapidos y furiosos");
	//	peliculas.add("El aro 2");
	//	peliculas.add("Aliens");
		model.addAttribute("fechas",listaFechas);
		model.addAttribute("fechaBusqueda", dateFormat.format(new Date()));
		model.addAttribute("peliculas", peliculas);
		return "home";
	} 
	  
	@RequestMapping(value = "/detalle",method = RequestMethod.GET) 
	public String mostrarDetalle(Model model,@RequestParam("idmovie") int idPelicula,@RequestParam("fecha") String fecha) {
		
		System.out.println("idPelicula: " + idPelicula);
		System.out.println("fecha: " + fecha); 
		model.addAttribute("pelicula",servicePeliculas.buscarPorId(idPelicula));
		return "detalle";
	}
}
