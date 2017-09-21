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
import br.com.ana.alves.araujo.pokemon.response.ResponseBase;
import br.com.ana.alves.araujo.pokemon.service.LoginService;
import br.com.ana.alves.araujo.pokemon.util.CustomErrorType;
import br.com.ana.alves.araujo.pokemon.util.LoginJWTUtils;

@RestController
@RequestMapping("/api/v1/pokemon/login")
public class LoginController {

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	@PostMapping("/")
	public ResponseEntity<?> login(@RequestBody Login login) {
		try {
			Login accessLogin = loginService.findByName(login.getUsername(), login.getPassword());
			if (accessLogin == null) {
				return new ResponseEntity<>(new CustomErrorType("Login not match"), HttpStatus.NOT_FOUND);

			}
			return new ResponseEntity<>(new ResponseBase(LoginJWTUtils.createJWT(login)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/create")
	public ResponseEntity<?> createLogin(@Validated @RequestBody Login login) {
		try {
			login = loginService.saveUser(login);
			if (login == null) {
				return new ResponseEntity<>(new CustomErrorType("login not Modified"),
						HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(new ResponseBase(LoginJWTUtils.createJWT(login)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new CustomErrorType(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
