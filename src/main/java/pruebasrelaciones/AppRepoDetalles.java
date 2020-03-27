package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Detalle; 
import net.cinema.app.repository.DetalleRepository; 

public class AppRepoDetalles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("root-context.xml");
		
		DetalleRepository repo = context.getBean("detalleRepository", DetalleRepository.class);
		List<Detalle> lista=repo.findAll();
		for (Detalle detalle: lista) {
			System.out.println(detalle);
		}
		context.close();
	}

}
