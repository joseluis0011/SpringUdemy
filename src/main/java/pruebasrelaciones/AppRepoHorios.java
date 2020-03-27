package pruebasrelaciones;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
 
import net.cinema.app.model.Horario; 
import net.cinema.app.repository.HorariosRepository;

public class AppRepoHorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("root-context.xml");
		
		HorariosRepository repo = context.getBean("horariosRepository", HorariosRepository.class);
		List<Horario> lista=repo.findAll();
		for (Horario horario: lista) {
			System.out.println(horario);
		}
		context.close();
	}

}
