package ttps.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.dao.EventoDAO;
import ttps.spring.model.model.Evento;
import ttps.spring.model.repository.EventoRepository;

@Service
@Transactional
public class EventoService {
	@Autowired
	private EventoRepository eventoRepository;

	@Autowired
	private EventoDAO eventoDAO;
	
	public EventoService(EventoRepository eventoRepository, EventoDAO eventoDAO) {
		super();
		this.eventoRepository = eventoRepository;
		this.eventoDAO=eventoDAO;
	}

	public EventoRepository getEventoRepository() {
		return eventoRepository;
	}
	
	public EventoDAO getEventoDAO() {
		return eventoDAO;
	}
	public void setEventoDAO(EventoDAO eventoDAO) {
		this.eventoDAO=eventoDAO;
	}

	public void setEventoRepository(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

	public Evento findById(Long id) {
		Optional<Evento> evento= getEventoRepository().findById(id);
		if (evento.isEmpty()) {
			return null;
		}
		return evento.get();
	}
	
	public List<Evento> recuperarTodos(){
		return getEventoRepository().findAll();
	}
	
	public Evento guardar(Evento evento) {
		if (evento.getNombre()!=null) {
			return getEventoRepository().save(evento);
		}
		return null;
	}
	
	public Boolean deleteEvento(Long id) {
		Evento evento=findById(id);
		if (evento!=null) {
			getEventoRepository().delete(evento);
			return true;
		}
		return false;
	}
	
	public Evento modificar(Long id, Evento nuevo) {
		Evento evento=findById(id);
		if (evento!=null) {
			evento.setNombre(nuevo.getNombre());
			evento.setActivo(nuevo.getActivo());
			evento.setCodigoPostal(nuevo.getCodigoPostal());
			evento.setProvincia(nuevo.getProvincia());
			evento.setEstado(nuevo.getEstado());
			evento.setFecha(nuevo.getFecha());
			evento.setGeolocalizacion(nuevo.getGeolocalizacion());
			evento.setHora(nuevo.getHora());
			evento.setReservas(nuevo.getReservas());
			evento.setTipo(nuevo.getTipo());
			return getEventoRepository().save(evento);
		}
		return null;
	}
}
