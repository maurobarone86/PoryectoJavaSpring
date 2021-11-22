package ttps.spring.model.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Servicio;
@Repository
public class ServicioDAOImpl extends GenericDAOImpl<Servicio> implements ServicioDAO{
	@Autowired
	public ServicioDAOImpl() {
		super(Servicio.class);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
    @Transactional(readOnly = true)
	public Servicio obtenerServicio(String dato) {
		Servicio ser=new Servicio();
		ser.setNombre(dato);
		return super.existe(ser);
	}
	
	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(Servicio ser) {
		Query q = super.getEntityManager().createQuery("SELECT s FROM Servicio s WHERE s.nombre = :nombre AND s.activo = :activo");
		q.setParameter("nombre",ser.getNombre());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}
}
