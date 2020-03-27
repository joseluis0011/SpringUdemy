package net.cinema.app.service;
 
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import net.cinema.app.model.Pelicula;

@Service
public interface IPeliculasService {
	void insertar(Pelicula pelicula);
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
	List<String> buscarGeneros();
	
	List<Pelicula> buscarActivas();
	List<Pelicula> buscarPorFecha(Date fecha);
	Page<Pelicula> buscarTodas(Pageable page);
	void eliminar(int idPelicula);
	//Page<Pelicula> buscarTodas(Pageable page);
}
