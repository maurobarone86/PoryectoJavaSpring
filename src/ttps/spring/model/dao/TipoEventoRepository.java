package ttps.spring.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.model.TipoEvento;



public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long> {

}
