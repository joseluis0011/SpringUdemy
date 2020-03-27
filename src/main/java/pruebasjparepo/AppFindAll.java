package pruebasjparepo;

import java.util.List;
import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Noticia> lista = repo.findAll();
		 for (Noticia noticia : lista) {
			System.out.println(noticia);
		}
		context.close();
	}

}
 