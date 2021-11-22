package ttps.spring.model.dao;


import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Valoracion;
@Repository
public class ValoracionDAOImpl  extends GenericDAOImpl<Valoracion> implements ValoracionDAO {
	
	@Autowired
	public ValoracionDAOImpl() {
		super(Valoracion.class);
		// TODO Auto-generated constructor stub
	}

	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(Valoracion valoracion) {
		Query q = super.getEntityManager().createQuery("SELECT u FROM TipoEvento u WHERE u.nombre = :nombre AND u.activo = :activo AND u.servicio = :servicio");
		q.setParameter("nombre",valoracion.getNombre());
		//q.setParameter("servicio",valoracion.getServicio());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}
	@Override
    @Transactional(readOnly = true)
	public void borradoLogico(Valoracion entity) {
		entity=	this.recuperar(entity.getId());
		entity.setActivo(false);
		this.actualizar(entity);
	}

}
