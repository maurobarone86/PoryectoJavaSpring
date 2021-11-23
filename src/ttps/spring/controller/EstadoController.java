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

import ttps.spring.service.EstadoService;
import ttps.spring.model.model.Estado;

@RestController
@RequestMapping("/apiEstado")
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("/estado/{id}")
	public ResponseEntity<Estado> estado(@PathVariable("id") Long id){
		Estado estado= estadoService.findById(id);
		if (estado!=null) {
			return new ResponseEntity<Estado> (estado,HttpStatus.OK );
		}
		return new ResponseEntity<Estado> (HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/estadosActivos")
	public ResponseEntity<List<Estado>> estadoListaActivo(){
		List<Estado> lista= estadoService.obtenerLista();
		if (lista!=null) {
			return new ResponseEntity<List<Estado>> (lista,HttpStatus.OK );
		}
		return new ResponseEntity<List<Estado>> (HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<Estado> guardar(@RequestBody Estado estado){
		Estado estadoA= estadoService.agregar(estado);
		if (estadoA!=null) {
			return new ResponseEntity<Estado> (estadoA, HttpStatus.OK);
		}
		return new ResponseEntity<Estado>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/estado/{id}")
	public ResponseEntity<Estado> estadoPut(@PathVariable("id") Long id, @RequestBody Estado nuevo){
		Estado estado= estadoService.actualizar(id, nuevo);
		if (estado!=null) {
			return new ResponseEntity<Estado> (estado, HttpStatus.OK);
		}
		return new ResponseEntity<Estado>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id){
		Boolean data = estadoService.delete(id);
		if (data) {
			return new ResponseEntity<Boolean> (true, HttpStatus.OK);
		}
		return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping("/deleteLogico/{id}")
	public ResponseEntity<Estado> deleteLogico(@PathVariable("id") Long id){
		Estado estado= estadoService.borradoLogico(id);
		if (estado!=null) {
			return new ResponseEntity<Estado> (estado, HttpStatus.OK);
		}
		return new ResponseEntity<Estado>(HttpStatus.NO_CONTENT);
	}
}
