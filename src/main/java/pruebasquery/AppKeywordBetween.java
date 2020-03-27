package pruebasquery;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.cinema.app.model.Noticia;
import net.cinema.app.repository.NoticiasRepository;

public class AppKeywordBetween {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("root-context.xml");
		NoticiasRepository repo =context.getBean("noticiasRepository", NoticiasRepository.class);
		
		//List<Noticia> lista = repo.findByEstatus("Activa");
		
		// consulta fecha
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Noticia> lista=null;
		try {
			lista=repo.findByFechaBetween(format.parse("2020-03-20"), format.parse("2020-03-21"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		for (Noticia noticia : lista) {
			System.out.println(noticia);
		}
		
		context.close();
	}

}
