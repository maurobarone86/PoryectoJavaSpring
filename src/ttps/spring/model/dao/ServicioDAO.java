package ttps.spring.model.dao;


import javax.persistence.Query;

import ttps.spring.model.model.Servicio;

public interface ServicioDAO extends GenericDAO<Servicio>{
	public Query makeQuery(Servicio servicio);
	public Servicio obtenerServicio(String dato);
	
}
