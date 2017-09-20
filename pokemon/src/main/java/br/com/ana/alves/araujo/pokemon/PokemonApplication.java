package br.com.ana.alves.araujo.pokemon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "br.com.ana.alves.araujo.pokemon" })

@ComponentScan({ "br.com.ana.alves.araujo" })
@EntityScan("br.com.ana.alves.araujo.pokemon.model")
@EnableJpaRepositories("br.com.ana.alves.araujo.pokemon.repository")
public class PokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}

}
