package ttps.spring.model.dao;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Imagen;

@Repository
public class ImagenDAOImpl extends GenericDAOImpl<Imagen> implements ImagenDAO{
	@Autowired
	public ImagenDAOImpl() {
		super(Imagen.class);
		// TODO Auto-generated constructor stub
	}

	@Override
    @Transactional(readOnly = true)
	public Query makeQuery(Imagen imagen) {
		Query q = super.getEntityManager().createQuery("SELECT u FROM TipoEvento u WHERE u.nombre = :nombre AND u.activo = :activo AND u.servicio = :servicio");
		q.setParameter("nombre",imagen.getNombre());
		q.setParameter("servicio",imagen.getServicio());
		q.setParameter("activo",Boolean.TRUE);
		return q;
	}

	

}
