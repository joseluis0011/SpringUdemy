package pruebascrudrepo;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

public class AppUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		Optional<Noticia> opcional = repo.findById(1);
		
		if (opcional.isPresent()) {
			Noticia noticia = opcional.get();
			//System.out.println(noticia);
			noticia.setEstatus("Inactiva");
			repo.save(noticia);
		}
		 
		context.close();
	}

}
