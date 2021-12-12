package ttps.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ttps.spring.model.dao.Usuario1DAO;
import ttps.spring.model.model.Credentials;
import ttps.spring.model.model.UsernaneAndPassword;
import ttps.spring.model.model.Usuario1;
import ttps.spring.service.TokenServices;

/**
 * @author manuel
 */
@RestController
public class LoginController {

    @Autowired
    private Usuario1DAO usuario1DAO;

    @Autowired
    private TokenServices tokenServices;

    // un dia
    private final int EXPIRATION_IN_SEC = 100;

    @PostMapping(path = "/auth")
    public ResponseEntity<?> authenticate(@RequestBody UsernaneAndPassword userpass) {

        if(isLoginSuccess(userpass.getUsername(), userpass.getPassword())) {
        	System.out.println("Ingreso al login");
            String token = tokenServices.generateToken(userpass.getUsername(), EXPIRATION_IN_SEC);
            return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, userpass.getUsername()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o password incorrecto");
        }
    }

    private boolean isLoginSuccess(String username, String password) {
        // recupero el usuario de la base de usuarios
        Usuario1 u = usuario1DAO.getUsuarioPorUsername(username);

        // chequeo que el usuario exista y el password sea correcto
        return (u != null && u.getPassword().equals(password));
    }
}
