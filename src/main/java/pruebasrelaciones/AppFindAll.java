package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Pelicula;
import net.cinema.app.repository.PeliculasRepository;

public class AppFindAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository repo = context.getBean("peliculasRepository", PeliculasRepository.class);
		List<Pelicula> lista=repo.findAll();
		for (Pelicula pelicula : lista) {
			System.out.println(pelicula);
		}
		context.close();
	}

}
