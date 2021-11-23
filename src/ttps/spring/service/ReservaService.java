package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.repository.ReservaRepository;

@Service
@Transactional
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;

	public ReservaService(ReservaRepository reservaRepository) {
		super();
		this.reservaRepository = reservaRepository;
	}

	public ReservaRepository getReservaRepository() {
		return reservaRepository;
	}

	public void setReservaRepository(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}

}
