package net.cinema.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService{
	
	@Autowired
	private NoticiasRepository noticiasRepo;

	@Override
	public void guardar(Noticia noticia) {
		// TODO Auto-generated method stub
		noticiasRepo.save(noticia);
	}

	@Override
	public List<Noticia> buscarUltimas() {
		// TODO Auto-generated method stub
		List<Noticia> noticias = noticiasRepo.findTop3ByEstatusOrderByIdDesc("Activa");		
		return noticias;
	}

	@Override
	public List<Noticia> buscarTodas() {
		// TODO Auto-generated method stub
		return noticiasRepo.findAll();
	}

	@Override
	public void eliminar(int idNoticia) {
		// TODO Auto-generated method stub
		// noticiasRepo.delete(idNoticia); // Spring 4.3
				noticiasRepo.deleteById(idNoticia);
	}
	
	// Spring 4.3
//		@Override
//		public Noticia buscarPorId(int idNoticia) {
//			return noticiasRepo.findOne(idNoticia); 
//		}

	@Override
	public Noticia buscarPorId(int idNoticia) {
		Optional<Noticia> optional = noticiasRepo.findById(idNoticia);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

}
