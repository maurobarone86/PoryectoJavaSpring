package ttps.spring.model.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.TipoEvento;

@Repository
public class TipoEventoDAOImpl extends GenericDAOImpl<TipoEvento> implements TipoEventoDAO {
	@Autowired
	public TipoEventoDAOImpl() {
		super(TipoEvento.class);
		// TODO Auto-generated constructor stub
	}
	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(TipoEvento tipoEvento) {
		Query q = super.getEntityManager().createQuery("SELECT u FROM TipoEvento u WHERE u.nombre = :nombre AND u.activo = :activo");
		q.setParameter("nombre",tipoEvento.getNombre());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}
	

	@Override
    @Transactional(readOnly = true)
	public TipoEvento obtenerTipoE(String nombre, Boolean publicado) {
		// TODO Auto-generated method stub
		if (nombre!=null) {
			TipoEvento tipoEventoAux=new TipoEvento(nombre, publicado);
			return super.existe(tipoEventoAux);
		}
		return null;
	}
	
	
}
