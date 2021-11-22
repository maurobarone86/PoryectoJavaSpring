package ttps.spring.model.dao;

import javax.persistence.Query;

import ttps.spring.model.model.TipoServicio;

public interface TipoServicioDAO extends GenericDAO<TipoServicio>  {
	public Query makeQuery(TipoServicio tipoServicio);

	public TipoServicio obtenerTipoServicio(String nombre);
	
}
