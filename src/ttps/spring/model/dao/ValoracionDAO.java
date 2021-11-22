package ttps.spring.model.dao;

import ttps.spring.model.model.Valoracion;

public interface ValoracionDAO extends GenericDAO<Valoracion>{

	void borradoLogico(Valoracion entity);

}
