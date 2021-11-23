package ttps.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.model.Reserva;
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
	
	public Reserva findById(Long id){
		Optional<Reserva> reserva= getReservaRepository().findById(id);
		if (!reserva.isEmpty()) {
			return reserva.get();
		}
		return null;

	}
	
	public Reserva agregar(Reserva reserva) {
		return getReservaRepository().save(reserva);
	}
	
	public Reserva actualizar(Long id, Reserva nuevo) {
		Reserva reserva= findById(id);
		if (reserva != null) {
			reserva.setActivo(nuevo.getActivo());
			reserva.setEmail(nuevo.getEmail());
			reserva.setEstado(nuevo.getEstado());
			reserva.setEvento(nuevo.getEvento());
			reserva.setFormaPago(nuevo.getFormaPago());
			reserva.setServicio(nuevo.getServicio());
			reserva.setTelefono(nuevo.getTelefono());
			reserva.setUsuario(nuevo.getUsuario());
			return agregar(reserva);
		}
		return null;
	}
	
	public Boolean delete(Long id) {
		Reserva reserva= findById(id);
		if (reserva != null) {
			getReservaRepository().delete(reserva);
			return true;
		}
		return false;
	}
	
	public Reserva borradoLogico(Long id) {
		Reserva reserva = findById(id);
		if (reserva!=null) {
			reserva.setActivo(false);
			reserva= agregar(reserva);
		}
		return reserva;
	}
	
	public List<Reserva> obtenerLista(){
		return getReservaRepository().findByActivo();
	}

}
