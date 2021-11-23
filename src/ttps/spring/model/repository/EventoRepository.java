package ttps.spring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ttps.spring.model.model.Evento;


public interface EventoRepository extends JpaRepository<Evento, Long> {
	
	@Query("SELECT e FROM Evento e WHERE e.activo=1")
	public List<Evento> findByActivo();
}
