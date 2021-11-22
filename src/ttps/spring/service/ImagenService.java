package ttps.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.spring.model.dao.ImagenRepository;

@Service
@Transactional
public class ImagenService {
	
	@Autowired
	private ImagenRepository imagenRepository;

	public ImagenService(ImagenRepository imagenRepository) {
		super();
		this.imagenRepository = imagenRepository;
	}

	public ImagenRepository getImagenRepository() {
		return imagenRepository;
	}

	public void setImagenRepository(ImagenRepository imagenRepository) {
		this.imagenRepository = imagenRepository;
	}

	
}
