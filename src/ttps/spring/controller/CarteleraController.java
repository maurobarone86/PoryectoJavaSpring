package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ttps.spring.model.dao.CarteleraDAO;
import ttps.spring.model.model.Cartelera;

import java.util.List;
import java.util.function.Predicate;

/**
 * @author manuel
 */
@RestController
public class CarteleraController {

    @Autowired
    private CarteleraDAO carteleraDAO;

    @GetMapping(path = "/cartelera")
    public List<Cartelera> getCarteleras() {
        return carteleraDAO.getAllCarteleras();
    }

    @GetMapping(path = "/cartelera/{id}")
    public Cartelera getCarteleras(@PathVariable("id") final Long id) {
        return carteleraDAO.getAllCarteleras().stream().filter(
                new Predicate<Cartelera>() {
					@Override
					public boolean test(Cartelera cartelera) {
						return cartelera.getId().equals(id);
					}
				}
        ).findFirst().orElse(null);
    }

}
