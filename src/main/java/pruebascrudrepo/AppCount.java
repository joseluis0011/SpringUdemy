package pruebascrudrepo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.repository.NoticiasRepository;

public class AppCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		long num=repo.count();
		System.out.println("se encontraron : " + num+ " registros.");
		 
		context.close();
	}

}
