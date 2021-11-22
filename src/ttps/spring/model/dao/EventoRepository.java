package ttps.spring.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.model.Evento;


public interface EventoRepository extends JpaRepository<Evento, Long> {

}
