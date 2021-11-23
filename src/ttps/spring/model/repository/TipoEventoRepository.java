package ttps.spring.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.model.TipoEvento;



public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long> {

}
