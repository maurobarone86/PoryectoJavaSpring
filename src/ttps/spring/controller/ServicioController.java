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

import ttps.spring.model.model.Servicio;
import ttps.spring.service.ServicioService;

@RestController
@RequestMapping("/apiServicio")
public class ServicioController {
	@Autowired
	private ServicioService servicioService;
	
	@GetMapping("/servicio/{id}")
	public ResponseEntity<Servicio> servicio(@PathVariable("id") Long id){
		try {
		Servicio servicio= servicioService.findById(id);
		return new ResponseEntity<Servicio> (servicio,HttpStatus.OK );
		}
		catch(Exception e) {
			return new ResponseEntity<Servicio> (HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping("/serviciosActivos")
	public ResponseEntity<List<Servicio>> servicioListaActivo(){
		try {
		List<Servicio> lista= servicioService.obtenerLista();
		if (lista!=null) {
		return new ResponseEntity<List<Servicio>> (lista,HttpStatus.OK );
		}
		else {return new ResponseEntity<List<Servicio>> (HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<List<Servicio>> (HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping("/nuevo")
	public ResponseEntity<Servicio> guardar(@RequestBody Servicio servicio){
		try {
		Servicio servicioA= servicioService.agregar(servicio);
		if (servicioA!=null) {
			return new ResponseEntity<Servicio> (servicioA, HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Servicio>(HttpStatus.NO_CONTENT);
		}
		}
		catch(Exception e) {
			return new ResponseEntity<Servicio>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
	}
	
	@PutMapping("/servicio/{id}")
	public ResponseEntity<Servicio> servicioPut(@PathVariable("id") Long id, @RequestBody Servicio nuevo){
		try {
		Servicio servicio= servicioService.actualizar(id, nuevo);
		return new ResponseEntity<Servicio> (servicio, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<Servicio>(HttpStatus.NO_CONTENT);
		}
				
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Servicio> delete(@PathVariable("id") Long id){
		try {
		Boolean data = servicioService.delete(id);
		if (data) {
			return new ResponseEntity<Servicio> (HttpStatus.OK);
		}
		else {
		return new ResponseEntity<Servicio>(HttpStatus.NO_CONTENT);
		}
		}
		catch (Exception e) {
			return new ResponseEntity<Servicio>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
		}
	}
	
	@DeleteMapping("/deleteLogico/{id}")
	public ResponseEntity<Servicio> deleteLogico(@PathVariable("id") Long id){
		try {
		Servicio servicio= servicioService.borradoLogico(id);
		return new ResponseEntity<Servicio> (servicio, HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<Servicio>(HttpStatus.NO_CONTENT);
		}
		
		
	}
}
