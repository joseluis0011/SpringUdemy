package net.cinema.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cinema.app.model.Usuario;
import net.cinema.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuariosService{

	@Autowired
	private UsuariosRepository usuariosRepo;
	
	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		usuariosRepo.save(usuario);
	}

}
