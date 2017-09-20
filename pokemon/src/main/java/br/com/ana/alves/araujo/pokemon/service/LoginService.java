package br.com.ana.alves.araujo.pokemon.service;

import java.util.List;

import br.com.ana.alves.araujo.pokemon.model.Login;

public interface LoginService {

	Login findById(Integer id);

	Login findByName(String username, String password);

	Login saveUser(Login login);

	Login updateUser(Login login);

	void deleteUserById(Integer id);

	void deleteAllUsers();

	List<Login> findAllUsers();

	boolean isUserExist(Login login);

	Login findByUserName(String username);

}
