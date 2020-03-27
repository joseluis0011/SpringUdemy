package net.cinema.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cinema.app.model.Perfil;
import net.cinema.app.repository.PerfilesRepository;
 
@Service
public class PerfilesServiceJPA implements IPerfilesService{

	@Autowired
	private PerfilesRepository perfilesRepo;  
	
	@Override
	public void guardar(Perfil perfil) {
		// TODO Auto-generated method stub
		perfilesRepo.save(perfil);
	}

}
