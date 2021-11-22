package ttps.spring.model.dao;

import javax.persistence.Query;

import ttps.spring.model.model.Estado;

public interface EstadoDAO extends GenericDAO<Estado>{
	public Query makeQuery(Estado estado);
	public Estado obtenerEstado(String nombre); 


}
