package net.cinema.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cinema.app.model.Banner;
import net.cinema.app.repository.BannersRepository;

@Service
public class BannersServiceJPA implements IBannersService{

	@Autowired
	private BannersRepository bannersRepo;
	
	
	@Override
	public void insertar(Banner banner) {
		// TODO Auto-generated method stub
		bannersRepo.save(banner);
	}

	@Override
	public List<Banner> buscarTodos() {
		// TODO Auto-generated method stub
		return bannersRepo.findAll();
	}

	@Override
	public List<Banner> buscarActivos() {
		// TODO Auto-generated method stub
		return bannersRepo.findByEstatusOrderByIdDesc("Activo");
	}

	@Override
	public void eliminar(int idBanner) {
		// TODO Auto-generated method stub
		bannersRepo.deleteById(idBanner);
	}

	@Override
	public Banner buscarPorId(int idBanner) {
		Optional<Banner> optional = bannersRepo.findById(idBanner);
		if (optional.isPresent())
			return optional.get();
		return null;
	}

}
