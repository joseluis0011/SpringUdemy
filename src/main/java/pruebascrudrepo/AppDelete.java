package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.repository.NoticiasRepository;

public class AppDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		int idNoticia=1;
		repo.deleteById(idNoticia);
		//System.out.println(repo.existsById(idNoticia));
		 
		context.close();
	}

}
