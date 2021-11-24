package ttps.spring.controller;

import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import ttps.spring.model.model.Servicio;
import ttps.spring.model.model.Usuario;
import ttps.spring.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController extends GenericController<Usuario> {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	public ResponseEntity<String> guardar(@RequestBody Usuario usuario) {
		if (usuarioService.nombreUsuarioLibre(usuario.getNombreUsuario())) {
			try {
				this.usuarioService.guardar(usuario);
			}
			catch(Exception e) {
				System.out.println("Ocurrio un error cuando se intentaba guardar el usuario");
			}
			
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		
	}
	//prueba curl -v http://localhost:8080/proyectoJavaSpring/api/usuarios
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listAllUsuarios() {
		List<Usuario> usuarios= null;
		try {
		usuarios = usuarioService.getUsuarioRepository().findAll();
		}
		catch (Exception e) {
			System.out.println("Ocurrio un error mientras se buscar la lista de usuarios");
		}
		if(usuarios.isEmpty()){
			return new	ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	//prueba curl -v http://localhost:8080/proyectoJavaSpring/api/usuario/servicios/10
	@GetMapping("/usuario/servicios/{id}")
	public ResponseEntity<List<Servicio>> userServicios(@PathVariable("id") Long id) {
		if (existe(id)) {
			Usuario usuario = usuarioService.findById(id);
			if (usuario.getServicios()==null || usuario.getServicios().isEmpty()) {
				return new	ResponseEntity<List<Servicio>>(HttpStatus.NO_CONTENT);
				}
			else	{
				return new ResponseEntity<List<Servicio>>(usuario.getServicios(), HttpStatus.OK);
				}
			}
			else	{
				return new	ResponseEntity<List<Servicio>>(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
			}
	}
	
	@PostMapping("/usuario/altaServicio/{id}")
	public ResponseEntity<List<Servicio>> altaServicio(@PathVariable("id") Long id, @RequestBody Servicio nuevo) {
		Usuario user = usuarioService.altaServicio(id, nuevo);
		if(user == null){
			return new	ResponseEntity<List<Servicio>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Servicio>>(user.getServicios(), HttpStatus.OK);
	}
	
	@PostMapping("/usuario/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario user ) {
		Usuario usuario = usuarioService.loginUser(user);
		System.out.println(usuario);
		System.out.println(user);
		if(usuario==null){
			return new	ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	
	@PutMapping("/usuario/{id}")
	public ResponseEntity<Usuario> actualizar(@PathVariable("id") Long id ,@RequestBody Usuario userNuevo){
		Usuario user= usuarioService.findById(id);
		if (user!=null) {
			user.setApellido(userNuevo.getApellido());
			user.setDireccion(userNuevo.getDireccion());
			user.setNombre(userNuevo.getNombre());
			user.setNombreUsuario(user.getNombreUsuario());
			user.setPassword(userNuevo.getPassword());
			user = usuarioService.guardar(user);
			return new ResponseEntity<Usuario> (user, HttpStatus.OK);
		}
		return new ResponseEntity<Usuario> (HttpStatus.NO_CONTENT);
	}
	
	//prueba curl -v http://localhost:8080/proyectoJavaSpring/api/usuario/10
	@RequestMapping(value="/usuario/{usuarioId}", produces="application/json; charset=UTF-8",method=RequestMethod.GET)
	public ResponseEntity<String> getUsuario(@PathVariable("usuarioId") Long usuarioId){
		return getEntity( usuarioId);
	}
	
	public Boolean existe(Long id) {
		return usuarioService.existeUsuario(id);
	}
	
	public Usuario buscar(Long id) {
		return usuarioService.buscarPorId(id);
	}
	
	
	
}
