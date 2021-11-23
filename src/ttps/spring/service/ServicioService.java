package ttps.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Servicio;
import ttps.spring.model.repository.ServicioRepository;

@Service
@Transactional
public class ServicioService {
	
	@Autowired
	private ServicioRepository servicioRepository;
	
	public ServicioRepository getServicioRepository() {
		return servicioRepository;
	}

	public void setServicioRepository(ServicioRepository servicioRepository) {
		this.servicioRepository = servicioRepository;
	}
	public ServicioService(ServicioRepository servicioRepository) {
		super();
		this.servicioRepository = servicioRepository;
	}

	public Servicio findById(Long id){
		Optional<Servicio> servicio= getServicioRepository().findById(id);
		if (!servicio.isEmpty()) {
			return servicio.get();
		}
		return null;

	}
	
	public Servicio agregar(Servicio servicio) {
		return getServicioRepository().save(servicio);
	}
	
	public Servicio actualizar(Long id, Servicio nuevo) {
		Servicio servicio= findById(id);
		if (servicio != null) {
			//falta agregar los otros campos
			servicio.setActivo(nuevo.getActivo());
			servicio.setNombre(nuevo.getNombre());
			return agregar(servicio);
		}
		return null;
	}
	
	public Boolean delete(Long id) {
		Servicio servicio= findById(id);
		if (servicio != null) {
			getServicioRepository().delete(servicio);
			return true;
		}
		return false;
	}
	
	public Servicio borradoLogico(Long id) {
		Servicio servicio = findById(id);
		if (servicio!=null) {
			servicio.setActivo(false);
			servicio= agregar(servicio);
		}
		return servicio;
	}
	
	public List<Servicio> obtenerLista(){
		return getServicioRepository().findByActivo();
	}
}
