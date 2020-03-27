package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

public class AppCreate {

	public static void main(String[] args) {
		Noticia noticia = new Noticia();
		noticia.setTitulo("Proximo extreno");
		noticia.setDetalle("el mes de setiempre se estreara la pelicula");
		
		Noticia noticia1 = new Noticia();
		noticia1.setTitulo("El gato con Botas");
		noticia1.setDetalle("el mes de setiempre se estreara la pelicula");
		
		Noticia noticia2 = new Noticia();
		noticia2.setTitulo("La sombra oscura");
		noticia2.setDetalle("el mes de setiempre se estreara la pelicula");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo= context.getBean("noticiasRepository", NoticiasRepository.class);
		
		repo.save(noticia);
		repo.save(noticia1);
		repo.save(noticia2);
		
		context.close();
	}
}
