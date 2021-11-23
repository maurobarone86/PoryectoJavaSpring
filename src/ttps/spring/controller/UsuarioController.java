package ttps.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import ttps.spring.model.model.Servicio;
import ttps.spring.model.model.Usuario;
import ttps.spring.service.UsuarioService;

@RestController
@RequestMapping("/api")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping("/usuario")
	public Usuario guardar(@RequestBody Usuario usuario) {
	//validaciones
	return this.usuarioService.guardar(usuario);
	}
	@GetMapping("/usuarios")
	public ResponseEntity<List<Usuario>> listAllUsuarios() {
		List<Usuario> usuarios = usuarioService.getUsuarioRepository().findAll();
		if(usuarios.isEmpty()){
			return new	ResponseEntity<List<Usuario>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/usuario/servicios/{id}")
	public ResponseEntity<List<Servicio>> userServicios(@PathVariable("id") Long id) {
		Usuario usuario = usuarioService.findById(id);
		if(usuario == null){
			return new	ResponseEntity<List<Servicio>>(HttpStatus.NO_CONTENT);
			}
		return new ResponseEntity<List<Servicio>>(usuario.getServicios(), HttpStatus.OK);
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
	
	//@GetMapping("/usuario/{usuarioId}")
	@RequestMapping(value="/usuario/{usuarioId}", produces="application/json; charset=UTF-8",method=RequestMethod.GET)
	public ResponseEntity<String> getUsuario(@PathVariable("usuarioId") Long usuarioId){
        Usuario usuario;
        //metodo de jpa Repository
		usuario = usuarioService.findById(usuarioId);
        //metodo de UsuarioDAO
		//usuario = usuarioService.buscarPorId(usuarioId);
		System.out.println(usuario);
        
        if(usuario == null) {
            throw new RuntimeException("User id not found -"+usuarioId);
        }
        //retornará al usuario con id pasado en la url
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString= null;
        try {
        	jsonInString = mapper.writeValueAsString(usuario);
        	}
        catch (Exception e) {
        	System.out.println("No se pudo convertir a json");
        	}
        return new ResponseEntity<String>(jsonInString,HttpStatus.OK);
    }
}
