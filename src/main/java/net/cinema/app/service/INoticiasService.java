package net.cinema.app.service;

import org.springframework.stereotype.Service;

import net.cinema.app.model.Noticia;

@Service
public interface INoticiasService {
	void guardar(Noticia noticia);
}
