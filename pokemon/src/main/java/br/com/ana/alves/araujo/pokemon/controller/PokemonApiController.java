package br.com.ana.alves.araujo.pokemon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ana.alves.araujo.pokemon.model.Ability;
import br.com.ana.alves.araujo.pokemon.model.Move;
import br.com.ana.alves.araujo.pokemon.model.Pokemon;
import br.com.ana.alves.araujo.pokemon.service.PokemonApiService;

@RestController
@RequestMapping("/api/v1/pokemon/api")
public class PokemonApiController {

	public static final Logger logger = LoggerFactory.getLogger(PokemonApiController.class);

	@Autowired
	PokemonApiService pokemonApiService;

	@GetMapping("/pokemon")
	public ResponseEntity<List<Pokemon>> getAllPokemons() {
		return new ResponseEntity<List<Pokemon>>(pokemonApiService.getAllPokemons(), HttpStatus.OK);
	}

	@GetMapping("/pokemon/{id}")
	public ResponseEntity<Pokemon> getPokemonById(@PathVariable Integer id) {
		return new ResponseEntity<Pokemon>(pokemonApiService.getPokemon(id), HttpStatus.OK);
	}

	@GetMapping("/ability")
	public ResponseEntity<List<Ability>> getAllAbilities() {
		return new ResponseEntity<List<Ability>>(pokemonApiService.getAllAbilities(), HttpStatus.OK);
	}

	@GetMapping("/ability/{id}")
	public ResponseEntity<Ability> getAbilityById(@PathVariable Integer id) {
		return new ResponseEntity<Ability>(pokemonApiService.getAbility(id), HttpStatus.OK);
	}

	@GetMapping("/move")
	public ResponseEntity<List<Move>> getAllMoves() {
		return new ResponseEntity<List<Move>>(pokemonApiService.getAllMoves(), HttpStatus.OK);
	}

	@GetMapping("/move/{id}")
	public ResponseEntity<Move> getMoveById(@PathVariable Integer id) {
		return new ResponseEntity<Move>(pokemonApiService.getMove(id), HttpStatus.OK);
	}

}
