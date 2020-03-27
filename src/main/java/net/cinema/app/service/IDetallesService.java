package net.cinema.app.service;

import net.cinema.app.model.Detalle;

public interface IDetallesService {
	void insertar(Detalle detalle);
	void eliminar(int idDetalle);
}
