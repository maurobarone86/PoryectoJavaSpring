package ttps.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ttps.spring.model.model.Reserva;
import ttps.spring.service.ReservaService;

@RestController
@RequestMapping("/apiReserva")
public class ReservaController {
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/reserva/{id}")
	public ResponseEntity<Reserva> reserva(@PathVariable("id") Long id){
		Reserva reserva= reservaService.findById(id);
		if (reserva!=null) {
			return new ResponseEntity<Reserva> (reserva,HttpStatus.OK );
		}
		return new ResponseEntity<Reserva> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/reservasActivos")
	public ResponseEntity<List<Reserva>> reservaListaActivo(){
		List<Reserva> lista= reservaService.obtenerLista();
		if (lista!=null) {
			return new ResponseEntity<List<Reserva>> (lista,HttpStatus.OK );
		}
		return new ResponseEntity<List<Reserva>> (HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<Reserva> guardar(@RequestBody Reserva reserva){
		Reserva reservaA= reservaService.agregar(reserva);
		if (reservaA!=null) {
			return new ResponseEntity<Reserva> (reservaA, HttpStatus.OK);
		}
		return new ResponseEntity<Reserva>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/reserva/{id}")
	public ResponseEntity<Reserva> reservaPut(@PathVariable("id") Long id, @RequestBody Reserva nuevo){
		Reserva reserva= reservaService.actualizar(id, nuevo);
		if (reserva!=null) {
			return new ResponseEntity<Reserva> (reserva, HttpStatus.OK);
		}
		return new ResponseEntity<Reserva>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
		Boolean data = reservaService.delete(id);
		if (data) {
			return new ResponseEntity<Boolean> (true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/deleteLogico/{id}")
	public ResponseEntity<Reserva> deleteLogico(@PathVariable("id") Long id){
		Reserva reserva= reservaService.borradoLogico(id);
		if (reserva!=null) {
			return new ResponseEntity<Reserva> (reserva, HttpStatus.OK);
		}
		return new ResponseEntity<Reserva>(HttpStatus.NO_CONTENT);
	}
}
