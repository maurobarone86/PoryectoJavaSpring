package ttps.spring.model.dao;

import org.springframework.stereotype.Repository;
import ttps.spring.model.model.Usuario1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author manuel
 */
@Repository
public class Usuario1DAO {

    List<Usuario1> usuarios;

    public Usuario1DAO() {
        this.usuarios = new ArrayList<>();
        this.usuarios.add(new Usuario1("Manuel", "manuel", "Prueba123"));
        this.usuarios.add(new Usuario1("Pepe", "pepeluis", "Prueba123"));
    }

    public Usuario1 getUsuarioPorUsername(final String username) {
        return this.usuarios.stream().filter(  new Predicate<Usuario1>() {
			@Override
			public boolean test(Usuario1 u) {
				return u.getUsername().equals(username);
			}
		} ).findFirst().orElse(null);
    }
}
