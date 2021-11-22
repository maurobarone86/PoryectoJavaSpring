package ttps.spring.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.spring.model.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNombre(String nombre);

	
}
