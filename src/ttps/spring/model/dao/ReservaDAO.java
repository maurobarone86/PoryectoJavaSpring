package ttps.spring.model.dao;

import javax.persistence.Query;

import ttps.spring.model.model.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva> {
	public Query makeQuery(Reserva reserva);
}
