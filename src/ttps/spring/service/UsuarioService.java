package ttps.spring.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.dao.UsuarioDAO;
import ttps.spring.model.model.Servicio;
import ttps.spring.model.model.Usuario;
import ttps.spring.model.repository.ServicioRepository;
import ttps.spring.model.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ServicioService servicioService;
	
	

	public ServicioService getServicioService() {
		return servicioService;
	}

	public void setServicioService(ServicioService servicioService) {
		this.servicioService = servicioService;
	}

	@Autowired
	private UsuarioDAO usuarioDAOImpl;

	public UsuarioDAO getUsuarioDAOImpl() {
		return usuarioDAOImpl;
	}

	public void setUsuarioDAOImpl(UsuarioDAO usuarioDAOImpl) {
		this.usuarioDAOImpl = usuarioDAOImpl;
	}

	public UsuarioService(UsuarioRepository usuarioRepository,UsuarioDAO usuarioDAOImpl) {
		super();
		this.usuarioRepository = usuarioRepository;
		this.usuarioDAOImpl = usuarioDAOImpl;
	}

	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}

	public void setUsuarioRepository(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public Usuario guardar(Usuario usuario) {
		if (nombreUsuarioLibre(usuario.getNombreUsuario())) {
			try {
				return getUsuarioRepository().save(usuario);	
			}
			catch(Exception e) {
				System.out.println("Ocurrio un error cuando se intentaba guardar el usuario");
			}
		}
		return null;
	}
	
	public Usuario findById(Long id) {
		if (existeUsuario(id)) {
			Optional<Usuario> optionalEntity = getUsuarioRepository().findById(id);
			Usuario usuario = optionalEntity.get();
			return usuario;
		}else{
			return null;
		}
		
	}
	public Usuario buscarPorId(Long id) {
		return getUsuarioDAOImpl().recuperar(id);
	}
	
	public Usuario loginUser(Usuario user) {
		return getUsuarioRepository().findByNameByPass(user.getNombreUsuario(), user.getPassword());
	}
	
	public Usuario altaServicio(Long id, Servicio nuevo) {
		if (existeUsuario(id)) {
			Usuario user= findById(id);
			if (user != null && getServicioService().nombreServicioLibre(nuevo.getNombre())) {
				user.getServicios().add(nuevo);
				user=getUsuarioRepository().save(user);
				return user;
			}
		}
		return null;
	}
	public Boolean existeUsuario(Long id) {
		return getUsuarioRepository().existsById(id);
	}
	public Boolean nombreUsuarioLibre(String nuevoNombreUsuario) {
		Boolean resultado=false;
		try {
			List<Usuario> listaUsuarios = getUsuarioRepository().findByNombreUsuario(nuevoNombreUsuario);
			if (listaUsuarios.isEmpty()) {
				resultado=true; 
				}
		}
		catch(Exception e){
			System.out.println("la lista de usuarios devolvio algo inesperado");	
		}
		return resultado;
		
	}
	
	public Usuario actualizar(Usuario userNuevo, Long id) {
		try {
			Usuario user= findById(id);
			if (user!= null) {
				if (userNuevo.getApellido() != null) {user.setApellido(userNuevo.getApellido());}
				if (userNuevo.getDireccion() !=null) {user.setDireccion(userNuevo.getDireccion());}
				if (userNuevo.getNombre() !=null) {user.setNombre(userNuevo.getNombre());}
				if (userNuevo.getNombreUsuario() !=null) {user.setNombreUsuario(userNuevo.getNombreUsuario());}
				if (userNuevo.getPassword() !=null) {user.setPassword(userNuevo.getPassword());}
				if (userNuevo.getFechaNac()!=null) {user.setFechaNac(userNuevo.getFechaNac());}
				user =getUsuarioRepository().save(user);
				return user;
			}
		}
		catch(Exception e) {}
		return null;
	}
}
