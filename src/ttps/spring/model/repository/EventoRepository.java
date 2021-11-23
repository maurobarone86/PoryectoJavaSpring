package ttps.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.model.Evento;


public interface EventoRepository extends JpaRepository<Evento, Long> {

}
