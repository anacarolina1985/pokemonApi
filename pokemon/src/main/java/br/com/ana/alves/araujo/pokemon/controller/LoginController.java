package br.com.ana.alves.araujo.pokemon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ana.alves.araujo.pokemon.model.Login;
import br.com.ana.alves.araujo.pokemon.service.LoginService;
import br.com.ana.alves.araujo.pokemon.util.LoginJWTUtils;

@RestController
@RequestMapping("/api/v1/pokemon/login")
public class LoginController {

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	@PostMapping("/")
	public ResponseEntity<String> login(@RequestBody Login login) {
		Login accessLogin = loginService.findByName(login.getUsername(), login.getPassword());
		if (accessLogin == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>(LoginJWTUtils.createJWT(accessLogin), HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<String> createLogin(@Validated @RequestBody Login login) {
		if (login == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		loginService.saveUser(login);
		return new ResponseEntity<String>(LoginJWTUtils.createJWT(login), HttpStatus.OK);
	}
}
