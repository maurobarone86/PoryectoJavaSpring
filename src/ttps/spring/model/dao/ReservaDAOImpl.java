package ttps.spring.model.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Reserva;
@Repository
public class ReservaDAOImpl extends GenericDAOImpl<Reserva> implements ReservaDAO {
	@Autowired
	public ReservaDAOImpl() {
		super(Reserva.class);
		// TODO Auto-generated constructor stub
	} 
	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(Reserva reserva) {
		Query q = super.getEntityManager().createQuery("SELECT u FROM Reserva u WHERE u.usuario = :usuario AND u.activo = :activo AND u.servicio = :servicio");
		q.setParameter("servicio",reserva.getServicio());
		q.setParameter("usuario",reserva.getUsuario());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}

	
	
}
