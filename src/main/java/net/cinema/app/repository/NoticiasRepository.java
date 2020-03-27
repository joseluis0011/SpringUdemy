package net.cinema.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import net.cinema.app.model.Noticia;

@Repository
//public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
public interface NoticiasRepository extends JpaRepository<Noticia, Integer> {
	// select * from noticias where estado=?
	List<Noticia> findByEstatus(String estatus);
	
	List<Noticia> findByFecha(Date fecha);
	
	List<Noticia> findByEstatusAndFecha(String estatus,Date fecha);
	
	List<Noticia> findByEstatusOrFecha(String estatus,Date fecha);
	
	List<Noticia> findByFechaBetween(Date fecha1,Date fecha2);
	
	List<Noticia> findByIdBetween(int n1,int n2);
	
	// select * from Noticias where estatus = ? order by id desc limit 3
		public List<Noticia> findTop3ByEstatusOrderByIdDesc(String estatus);
}
