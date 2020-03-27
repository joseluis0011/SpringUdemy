package net.cinema.app.service;
 
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.cinema.app.model.Horario;
import net.cinema.app.model.Pelicula;
import net.cinema.app.repository.HorariosRepository;
import net.cinema.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService{

	@Autowired
	private PeliculasRepository peliculasRepo;
	
	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired	
	private HorariosRepository horariosRepo;
    
	@Override
	public void insertar(Pelicula pelicula) {
		// TODO Auto-generated method stub
		peliculasRepo.save(pelicula);
		
	}

	@Override
	public List<Pelicula> buscarTodas() {
		// TODO Auto-generated method stub
		return peliculasRepo.findAll();
	}

	@Override
	public Pelicula buscarPorId(int idPelicula) {
		Optional<Pelicula> op =peliculasRepo.findById(idPelicula);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	@Override
	public List<String> buscarGeneros() {
		// TODO Auto-generated method stub
		List<String> generos =new LinkedList<>();
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventura");
		generos.add("Romantica"); 
		return generos;
	}

	@Override
	public void eliminar(int idPelicula) {
		// TODO Auto-generated method stub
		 peliculasRepo.deleteById(idPelicula);
	}

	@Override
	public List<Pelicula> buscarActivas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPorFecha(Date fecha) {
		List<Pelicula> peliculas = null;
		// Buscamos en la tabla de horarios, [agrupando por idPelicula]
		List<Horario> horarios = horariosRepo.findByFecha(fecha);
		peliculas = new LinkedList<>();

		// Formamos la lista final de Peliculas que regresaremos.
		for (Horario h : horarios) {
			// Solo nos interesa de cada registro de horario, el registro de pelicula.
			peliculas.add(h.getPelicula());
		}		
		return peliculas;
	}

	@Override
	public Page<Pelicula> buscarTodas(Pageable page) {
		return peliculasRepo.findAll(page);
	} 

}
