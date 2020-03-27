package net.cinema.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cinema.app.model.Detalle;
import net.cinema.app.repository.DetalleRepository;

@Service
public class DetallesServiceJPA implements IDetallesService {

	@Autowired
	private DetalleRepository detallesRepo;
	
	@Override
	public void insertar(Detalle detalle) {
		// TODO Auto-generated method stub
		detallesRepo.save(detalle);
	}

	@Override
	public void eliminar(int idDetalle) {
		// TODO Auto-generated method stub
		detallesRepo.deleteById(idDetalle);
	}
	
}
