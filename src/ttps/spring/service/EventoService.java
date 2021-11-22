package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.dao.EventoRepository;

@Service
@Transactional
public class EventoService {
	@Autowired
	private EventoRepository eventoRepository;

	public EventoService(EventoRepository eventoRepository) {
		super();
		this.eventoRepository = eventoRepository;
	}

	public EventoRepository getEventoRepository() {
		return eventoRepository;
	}

	public void setEventoRepository(EventoRepository eventoRepository) {
		this.eventoRepository = eventoRepository;
	}

}
