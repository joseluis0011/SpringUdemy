package net.cinema.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.cinema.app.model.Pelicula;

@Service
public interface IPeliculasService {
	List<Pelicula> buscarTodas();
	Pelicula buscarPorId(int idPelicula);
}
