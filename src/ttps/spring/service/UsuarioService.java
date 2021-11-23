package ttps.spring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.dao.UsuarioDAO;
import ttps.spring.model.model.Servicio;
import ttps.spring.model.model.Usuario;
import ttps.spring.model.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
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
		
		if (usuario != null) {
			return getUsuarioRepository().save(usuario);
			
		}
		return null;
	}
	public Usuario findById(Long id) {
		Optional<Usuario> optionalEntity = getUsuarioRepository().findById(id);
		Usuario usuario = optionalEntity.get();
		return usuario;
	}
	public Usuario buscarPorId(Long id) {
		return getUsuarioDAOImpl().recuperar(id);
		
	}
	public Usuario loginUser(Usuario user) {
		return getUsuarioRepository().findByNameByPass(user.getNombreUsuario(), user.getPassword());
	}
	
	public Usuario altaServicio(Long id, Servicio nuevo) {
		Usuario user= findById(id);
		if (user != null) {
			user.getServicios().add(nuevo);
			user=guardar(user);
		}
		return user;
	}
}
