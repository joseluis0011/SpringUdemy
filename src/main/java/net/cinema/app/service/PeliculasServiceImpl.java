package net.cinema.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sun.org.apache.regexp.internal.recompile;

import net.cinema.app.model.Pelicula;

@Service
public class PeliculasServiceImpl implements IPeliculasService{

	private List<Pelicula> lista =null;
	
	public PeliculasServiceImpl() {
		
		System.out.println("creando una instancia de la clase pelicula service");
		SimpleDateFormat formatter =new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			lista =new LinkedList<>();
			
			Pelicula pelicula1= new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Powe Rangers");
			pelicula1.setDuracion(120);
			pelicula1.setCalificacion("B");
			pelicula1.setGenero("Aventura");
			pelicula1.setFechaEstado(formatter.parse("24-02-2020"));
			pelicula1.setImagen("dora.jpg");
			
			Pelicula pelicula2=new Pelicula();
			pelicula2.setId(2);
			pelicula2.setTitulo("La Bella y la Bestia");
			pelicula2.setDuracion(132);
			pelicula2.setCalificacion("A");
			pelicula2.setGenero("Infantil");
			pelicula2.setFechaEstado(formatter.parse("25-02-2020"));
			pelicula2.setImagen("farfan.jpg");
			
			Pelicula pelicula3=new Pelicula();
			pelicula3.setId(3);
			pelicula3.setTitulo("Contratiempo");
			pelicula3.setDuracion(106);
			pelicula3.setCalificacion("B");
			pelicula3.setGenero("Thriller");
			pelicula3.setFechaEstado(formatter.parse("26-02-2020"));
			pelicula3.setImagen("sony.jpg");
			
			//Agregamos los objetos Pelicula a la lista
			lista.add(pelicula1);
			lista.add(pelicula2);
			lista.add(pelicula3);
			  
		} catch (ParseException e) {
			System.out.println("error: " +e.getMessage());
			 
		}
	}
	
	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		for (Pelicula p:lista) {
			if (p.getId()== idPelicula) {
				return p;
			}
		}
		return null;
	}

}
