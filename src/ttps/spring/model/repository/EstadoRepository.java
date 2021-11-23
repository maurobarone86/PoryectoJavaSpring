package ttps.spring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ttps.spring.model.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
	@Query("SELECT e FROM Estado e WHERE e.activo=1")
	public List<Estado> findByActivo();
}
