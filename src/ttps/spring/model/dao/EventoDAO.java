package ttps.spring.model.dao;

import java.util.Date;

import javax.persistence.Query;

import ttps.spring.model.model.Evento;

public interface EventoDAO extends GenericDAO<Evento>{
	public Query makeQuery(Evento evento);
	public Evento obtenerEvento(String nombre, String direccion, Date fecha );
}
