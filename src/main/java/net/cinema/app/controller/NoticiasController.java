package net.cinema.app.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping; 

import net.cinema.app.model.Noticia;
import net.cinema.app.service.INoticiasService; 

@Controller
// ACCESO A LA CARPETA VIEWS/NOTICIAS
@RequestMapping("/noticias")
public class NoticiasController {
	//  IMPORTAR HEREDAR INOTICIASSERVICE
	 @Autowired()
	 private INoticiasService serviceNoticias;
	 
	@GetMapping(value = "/create")
	public String crear() {
		return "noticias/formNoticia";
	}
	
	@PostMapping(value = "/save")
	public String guardar(Noticia noticia ) {
		 //serviceNoticias.guardar(noticia);
		// PENDIENTE GUARDAR EN LA BD
		 
		
		return "noticias/formNoticia";
	}
}
