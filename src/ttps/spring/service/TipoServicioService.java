package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.dao.TipoServicioRepository;

@Service
@Transactional
public class TipoServicioService {
	
	@Autowired
	private TipoServicioRepository tipoServicioRepository;

	public TipoServicioService(TipoServicioRepository tipoServicioRepository) {
		super();
		this.tipoServicioRepository = tipoServicioRepository;
	}

	public TipoServicioRepository getTipoServicioRepository() {
		return tipoServicioRepository;
	}

	public void setTipoServicioRepository(TipoServicioRepository tipoServicioRepository) {
		this.tipoServicioRepository = tipoServicioRepository;
	}
	
	

}
