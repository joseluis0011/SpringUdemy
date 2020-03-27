package pruebascrudrepo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

public class AppFindAllById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		List<Integer> ids= new LinkedList<Integer>();
		ids.add(6);
		ids.add(8);
		
		Iterable<Noticia> it= repo.findAllById(ids);
		 for (Noticia noticia : it) {
			System.out.println(noticia);
		}
		context.close();
	}

}
