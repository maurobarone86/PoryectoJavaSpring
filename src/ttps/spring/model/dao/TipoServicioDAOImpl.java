package ttps.spring.model.dao;


import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.TipoServicio;

@Repository
public class TipoServicioDAOImpl extends GenericDAOImpl<TipoServicio> implements TipoServicioDAO  {
	@Autowired
	public TipoServicioDAOImpl() {
		super(TipoServicio.class);
		// TODO Auto-generated constructor stub
	}
	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(TipoServicio tipoServicio) {
		Query q = super.getEntityManager().createQuery("SELECT u FROM TipoServicio u WHERE u.nombre = :nombre AND u.activo = :activo");
		q.setParameter("nombre",tipoServicio.getNombre());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}
	

	@Override
    @Transactional(readOnly = true)
	public TipoServicio obtenerTipoServicio(String nombre) {
		// TODO Auto-generated method stub
		if (nombre !=null) {
			TipoServicio tipo= new TipoServicio(nombre);
			return super.existe(tipo);
		}
		return null;
	}
	
	
	
}
