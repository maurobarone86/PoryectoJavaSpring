package ttps.spring.model.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Usuario;
@Repository
public class UsuarioDAOImpl  extends GenericDAOImpl<Usuario> implements UsuarioDAO{

	@Autowired
	public UsuarioDAOImpl() {
		super(Usuario.class);
		// TODO Auto-generated constructor stub
	}

	
	
	

	@Override
    @Transactional(readOnly = true)
	public Usuario obtenerUser(String nombreUsuario) {
		Usuario userAux = new Usuario();
		userAux.setNombreUsuario(nombreUsuario);
		Usuario user= super.existe(userAux);
		return user;
	}
	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(Usuario usuario) {
		Query q = super.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :nombre AND u.activo = :activo");
		q.setParameter("nombre",usuario.getNombreUsuario());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}





	
	
	
	
}
