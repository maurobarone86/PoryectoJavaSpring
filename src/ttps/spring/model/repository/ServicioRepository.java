package ttps.spring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ttps.spring.model.model.Servicio;
import ttps.spring.model.model.Usuario;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
	List<Servicio> findByNombre(String nombre);
	
	@Query("SELECT e FROM Servicio e WHERE e.activo=1")
	public List<Servicio> findByActivo();
}
