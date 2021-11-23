package ttps.spring.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ttps.spring.model.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNombre(String nombre);
	List<Usuario> findAll();
	@Query("SELECT e FROM Usuario e WHERE e.activo=1 AND e.nombreUsuario =:name AND e.password= :pass")
	Usuario findByNameByPass(@Param("name") String name, @Param("pass") String pass);
	
}
