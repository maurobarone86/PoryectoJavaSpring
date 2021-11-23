package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	

}
