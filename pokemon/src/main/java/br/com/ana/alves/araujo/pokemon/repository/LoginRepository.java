package br.com.ana.alves.araujo.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ana.alves.araujo.pokemon.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query(value = "SELECT l FROM Login l where username = :username AND password = :password")
	Login findByUserNameAnPassword(@Param("username") String username, @Param("password") String password);

	@Query(value = "SELECT l FROM Login l where username = :username")
	Login findByUserName(@Param("username") String username);
}
