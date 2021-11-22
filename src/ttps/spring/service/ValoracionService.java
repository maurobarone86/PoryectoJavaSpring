package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.dao.ValoracionRepository;

@Service
@Transactional
public class ValoracionService {
	
	@Autowired
	private ValoracionRepository valoracionRepository;

	public ValoracionService(ValoracionRepository valoracionRepository) {
		super();
		this.valoracionRepository = valoracionRepository;
	}

	public ValoracionRepository getValoracionRepository() {
		return valoracionRepository;
	}

	public void setValoracionRepository(ValoracionRepository valoracionRepository) {
		this.valoracionRepository = valoracionRepository;
	}
	
	
}
