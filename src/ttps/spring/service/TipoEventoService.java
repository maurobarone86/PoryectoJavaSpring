package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.repository.TipoEventoRepository;

@Service
@Transactional
public class TipoEventoService {
	
	@Autowired
	private TipoEventoRepository tipoEventoRepository;

	public TipoEventoService(TipoEventoRepository tipoEventoRepository) {
		super();
		this.tipoEventoRepository = tipoEventoRepository;
	}

	public TipoEventoRepository getTipoEventoRepository() {
		return tipoEventoRepository;
	}

	public void setTipoEventoRepository(TipoEventoRepository tipoEventoRepository) {
		this.tipoEventoRepository = tipoEventoRepository;
	}
	

}
