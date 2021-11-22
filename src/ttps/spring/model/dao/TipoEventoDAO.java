package ttps.spring.model.dao;

import javax.persistence.Query;

import ttps.spring.model.model.TipoEvento;

public interface TipoEventoDAO extends GenericDAO<TipoEvento>{
	public Query makeQuery(TipoEvento tipoEvento);
	public TipoEvento obtenerTipoE(String nombre, Boolean publicado);
	
}
