package ttps.spring.model.dao;

import java.util.Date;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Evento;
@Repository
public class EventoDAOImpl extends GenericDAOImpl<Evento> implements EventoDAO {
	@Autowired
	public EventoDAOImpl() {
		super(Evento.class);
		// TODO Auto-generated constructor stub
	}
	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(Evento evento) {
		Query q = super.getEntityManager().createQuery("SELECT u FROM Evento u WHERE u.nombre = :nombre AND u.activo = :activo AND u.direccion = :direccion AND u.fecha = :fecha");
		q.setParameter("nombre",evento.getNombre());
		q.setParameter("direccion",evento.getDireccion());
		q.setParameter("fecha",evento.getFecha());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}
	
	
	@Override
    @Transactional(readOnly = true)
	public Evento obtenerEvento(String dato, String direccion,Date fecha) {
		Evento evento= new Evento(dato);
		evento.setDireccion(direccion);
		evento.setFecha(fecha);
		return super.existe(evento);
	}
	
}
