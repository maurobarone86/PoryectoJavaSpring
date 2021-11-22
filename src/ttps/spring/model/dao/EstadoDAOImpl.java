package ttps.spring.model.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Estado;

@Repository
public class EstadoDAOImpl extends GenericDAOImpl<Estado> implements EstadoDAO {

	@Autowired
	public EstadoDAOImpl() {
		super(Estado.class);
		// TODO Auto-generated constructor stub
	}


	@Override
    @Transactional(readOnly = true)
	public Estado obtenerEstado(String nombre) {
		Estado estado=new Estado(nombre);
		return super.existe(estado);
	}
	
	
	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(Estado estado) {
		Query q = super.getEntityManager().createQuery("SELECT e FROM Estado e WHERE e.nombre = :nombre AND e.activo = :activo");
		q.setParameter("nombre",estado.getNombre());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}
	

}
