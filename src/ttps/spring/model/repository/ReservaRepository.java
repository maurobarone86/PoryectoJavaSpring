package ttps.spring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ttps.spring.model.model.Reserva;


public interface ReservaRepository extends JpaRepository<Reserva, Long> {

	@Query("SELECT r FROM Reserva r WHERE r.activo=1")
	public List<Reserva> findByActivo();
}
