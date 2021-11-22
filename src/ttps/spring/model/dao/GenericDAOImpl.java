package ttps.spring.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;




@Transactional
abstract public class GenericDAOImpl<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	@Autowired
	public GenericDAOImpl(Class<T> clase) {
		this.persistentClass = clase;
	}
	
	private EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
    @Transactional
	public T persistir(T entity) {
	this.getEntityManager().persist(entity);
	return entity;
	}
	
	/*
	@Override
	public T persistir(T entity) {
		EntityManager em = Conexion.getManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
			}
		catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			System.out.println("No se pudo persistir la entidad");
			throw e; 
			}
		finally {
			em.close();
			}
	return entity;
	}*/
	@Override
    @Transactional
	public T actualizar(T entity) {
		return this.getEntityManager().merge(entity);
	}
	
	/*
	public T actualizar(T entity) {
		EntityManager em= Conexion.getManager();
		EntityTransaction etx= em.getTransaction();
		etx.begin();
		T entityAux = em.merge(entity);
		etx.commit();
		em.close();
	return entityAux;
	}*/
	
	@Override
    @Transactional
	public void borrar(T entity) {
		this.getEntityManager().remove(entity);
	    	}
	
	/*
	 @Override
	public void borrar(T entity) {
		EntityManager em = Conexion.getManager();
	    EntityTransaction tx = null;
	    try {
	    	tx = em.getTransaction();
	    	tx.begin();
	    	em.remove(entity);
	    	tx.commit();
	    	}
	    catch (RuntimeException e) {
	    	if ( tx != null && tx.isActive() ) tx.rollback();
	    	throw e; // escribir en un log o mostrar un mensaje
	    	} 
	    finally {
	    	em.close();
	    	}
	}
	  */
	/*
	 @Override
	public T borrar(Serializable id) {
		EntityManager em = Conexion.getManager();
		T entity=em.find(this.getPersistentClass(), id);
		if (entity != null) {
			this.borrar(entity);
			}
		em.close();
		return entity;
	}
	 */
	
	@Override
    @Transactional
	public T borrar(Serializable id) {
		EntityManager em = this.getEntityManager();
		T entity=em.find(this.getPersistentClass(), id);
		if (entity != null) {
			this.borrar(entity);
			}
		
		return entity;
	}
	
	private Class<T> getPersistentClass() {
		return persistentClass;
	}
	@Override
    @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> recuperarTodos(String columnOrder) throws Exception {
		List<T> resultado = null;
		try {
			Query consulta=this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName()+" e order by e."+columnOrder);
			resultado = (List<T>) consulta.getResultList();
		}
		catch (Exception e) {
			throw e;
		}
	return resultado;
	}
	@Override
    @Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<T> recuperarActivos() throws Exception {
		List<T> resultado = null;
		try {
			Query consulta=this.getEntityManager().createQuery("select e from "+ getPersistentClass().getSimpleName()+" e WHERE e.activo = :logic");
			consulta.setParameter("logic", Boolean.TRUE);
			resultado = (List<T>) consulta.getResultList();
		}
		catch (Exception e) {
			throw e;
		}
	return resultado;
	}
	
	@Override
    @Transactional(readOnly = true)
	public T recuperar(Serializable id) {
		return this.getEntityManager().find(getPersistentClass(), id);
			}
	
	public T save(T entity) throws Exception {
		// TODO Auto-generated method stub
		try {
			T entityAux = existe(entity);
			if (entityAux != null){
				return this.actualizar(entityAux);
				}
			else {
				return this.persistir(entity);
				}
			}
		catch (Exception e) {
			throw e;
			}
	}
	
	abstract public Query makeQuery(T entity);
	@Override
    @Transactional(readOnly = true)
    public T existe(T entity)throws NoResultException, NonUniqueResultException{
		
		Query q = this.makeQuery(entity);
			
		try {
			@SuppressWarnings("unchecked")
			T teAux =(T) q.getSingleResult();
			System.out.println("existe el "+getPersistentClass().toString()+", lo actualizo");
			
			return teAux;
			}
		catch (NoResultException e) {
			System.out.println("la consulta no trajo nada, se persiste el "+getPersistentClass().toString());
			return null;
		}
		catch (NonUniqueResultException e1) {
			System.out.println(entity.toString()+ "existe mas de un "+getPersistentClass().toString()+" activo, no se puede actualizar");
			throw e1;
		}
	
	}


}
