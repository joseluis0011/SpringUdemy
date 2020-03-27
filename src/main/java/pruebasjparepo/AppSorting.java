package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Sort;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

public class AppSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//List<Noticia> lista =repo.findAll(Sort.by("titulo").descending());// ORDEN ALFABETICO ASC-- DESC
		
		List<Noticia> lista =repo.findAll(Sort.by("fecha").descending().and(Sort.by("titulo").ascending()));
		
		for (Noticia noticia : lista) {
			System.out.println(noticia);
		}
		
		context.close();
	}

}
