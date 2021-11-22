package ttps.spring.model.dao;

import javax.persistence.Query;

import ttps.spring.model.model.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
	
	public Usuario obtenerUser(String nombreUsuario);
	public Query makeQuery(Usuario usuario);
	
}
