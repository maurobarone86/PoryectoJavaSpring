package ttps.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Estado;
import ttps.spring.model.repository.EstadoRepository;


@Service
@Transactional
public class EstadoService {
	@Autowired
	private EstadoRepository estadoRepository;

	public EstadoService(EstadoRepository estadoRepository) {
		super();
		this.estadoRepository = estadoRepository;
	}

	public EstadoRepository getEstadoRepository() {
		return estadoRepository;
	}

	public void setEstadoRepository(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}
	
	public Estado findById(Long id){
		Optional<Estado> estado= getEstadoRepository().findById(id);
		if (!estado.isEmpty()) {
			return estado.get();
		}
		return null;

	}
	
	public Estado agregar(Estado estado) {
		return getEstadoRepository().save(estado);
	}
	
	public Estado actualizar(Long id, Estado nuevo) {
		Estado estado= findById(id);
		if (estado != null) {
			estado.setActivo(nuevo.getActivo());
			estado.setNombre(nuevo.getNombre());
			return agregar(estado);
		}
		return null;
	}
	
	public Boolean delete(Long id) {
		Estado estado= findById(id);
		if (estado != null) {
			getEstadoRepository().delete(estado);
			return true;
		}
		return false;
	}
	
	public Estado borradoLogico(Long id) {
		Estado estado = findById(id);
		if (estado!=null) {
			estado.setActivo(false);
			estado= agregar(estado);
		}
		return estado;
	}
	
	public List<Estado> obtenerLista(){
		return getEstadoRepository().findByActivo();
	}

}
