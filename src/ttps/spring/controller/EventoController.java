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

import ttps.spring.model.model.Evento;
import ttps.spring.service.EventoService;

@RestController
@RequestMapping("/apiEvento")
public class EventoController {

	@Autowired
	private EventoService eventoService;

	@GetMapping("/eventos/lista")
	public ResponseEntity<List<Evento>> obtenerLista(){
		List<Evento> lista= eventoService.recuperarTodos();
		if (lista!=null) {
			return new ResponseEntity<List<Evento>>(lista, HttpStatus.OK);
		}
		return new ResponseEntity<List<Evento>>(HttpStatus.NO_CONTENT);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Evento> obtener(@PathVariable("id") Long id){
		Evento evento= eventoService.findById(id);
		if (evento!=null) {
			return new ResponseEntity<Evento>(evento, HttpStatus.OK);
		}
		return new ResponseEntity<Evento>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/guardar")
	public ResponseEntity<Evento> guardar(@RequestBody Evento evento){
		Evento eventoG= eventoService.guardar(evento);
		if (eventoG!=null) {
			return new ResponseEntity<Evento>(eventoG, HttpStatus.OK);
		}
		return new ResponseEntity<Evento>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteEvento(@PathVariable("id") Long id){
		Boolean dato= eventoService.deleteEvento(id);
		if (dato) {
			return new ResponseEntity<Boolean>(dato, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<Evento> modificarEvento(@PathVariable("id") Long id, @RequestBody Evento nuevo){
		Evento evento= eventoService.modificar(id, nuevo);
		if (evento!=null) {
			return new ResponseEntity<Evento>(evento, HttpStatus.OK);
		}
		return new ResponseEntity<Evento>(HttpStatus.NO_CONTENT);
	}
}
