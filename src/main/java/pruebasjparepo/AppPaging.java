package pruebasjparepo;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

public class AppPaging {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		// Obtener todas las entidades por paginacion
		//Page<Noticia> page = repo.findAll(PageRequest.of(0, 2));// PAGINA / REGISTRO
		
		// Obtener todas las entidades por paginacion
		  Page<Noticia> page = repo.findAll(PageRequest.of(1, 2,Sort.by("titulo")));//N° PAGINA / N° REGISTRO / Tipo ORDENAMIENTO
		
		for (Noticia noticia : page) {
			System.out.println(noticia);
		}
		
		context.close();
	}

}
