package net.cinema.app.service;

import net.cinema.app.model.Noticia;

public class NoticiasServiceImpl implements INoticiasService{

	public NoticiasServiceImpl() {
		System.out.println("creando una instancia de la clse noticias service");
	}
	
	
	@Override
	public void guardar(Noticia noticia) {
		System.out.println("Guardando el objeto " +noticia + " en la bd");
		
	}

}
