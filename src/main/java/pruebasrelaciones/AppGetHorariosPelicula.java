package pruebasrelaciones;

import java.util.Optional;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Pelicula;
import net.cinema.app.repository.PeliculasRepository;

public class AppGetHorariosPelicula {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("root-context.xml");
		
		PeliculasRepository repo=context.getBean("peliculasRepository", PeliculasRepository.class);
		
		Optional<Pelicula>op = repo.findById(1);
		
		System.out.println(op.get().getHorarios().size());
		
		context.close();
	}

}
