package br.com.ana.alves.araujo.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ana.alves.araujo.pokemon.model.ParamConfiguration;

public interface ParamConfigurationRespository extends JpaRepository<ParamConfiguration, Integer> {

	@Query(value = "SELECT p FROM ParamConfiguration p where key = :key")
	ParamConfiguration findByKey(@Param("key") String key);
}
