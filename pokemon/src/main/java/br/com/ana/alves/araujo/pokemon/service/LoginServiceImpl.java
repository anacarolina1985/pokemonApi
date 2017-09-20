package br.com.ana.alves.araujo.pokemon.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ana.alves.araujo.pokemon.model.Login;
import br.com.ana.alves.araujo.pokemon.repository.LoginRepository;

@Component
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository loginReposity;

	public Login findById(Integer id) {
		return loginReposity.findOne(id);
	}

	public Login findByName(String username, String password) {
		return loginReposity.findByUserNameAnPassword(username,
				Base64.getEncoder().encodeToString(password.getBytes()));
	}

	public Login saveUser(Login login) {
		login.setPassword(Base64.getEncoder().encodeToString(login.getPassword().getBytes()));
		return loginReposity.save(login);
	}

	public Login updateUser(Login login) {
		return saveUser(login);
	}

	public void deleteUserById(Integer id) {
		loginReposity.delete(id);
	}

	public void deleteAllUsers() {
		loginReposity.deleteAll();
	}

	public List<Login> findAllUsers() {
		return loginReposity.findAll();
	}

	public boolean isUserExist(Login login) {
		return findByUserName(login.getUsername()) != null;
	}

	public Login findByUserName(String username) {
		return loginReposity.findByUserName(username);
	}
}
