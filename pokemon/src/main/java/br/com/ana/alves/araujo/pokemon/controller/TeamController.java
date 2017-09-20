package br.com.ana.alves.araujo.pokemon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ana.alves.araujo.pokemon.model.Login;
import br.com.ana.alves.araujo.pokemon.model.Move;
import br.com.ana.alves.araujo.pokemon.model.Pokemon;
import br.com.ana.alves.araujo.pokemon.model.Team;
import br.com.ana.alves.araujo.pokemon.request.PokemonTeamRequest;
import br.com.ana.alves.araujo.pokemon.service.LoginService;
import br.com.ana.alves.araujo.pokemon.service.ParamConfigurationService;
import br.com.ana.alves.araujo.pokemon.service.PokemonApiService;
import br.com.ana.alves.araujo.pokemon.util.LoginJWTUtils;

@RestController
@RequestMapping("/api/v1/pokemon/team")
public class TeamController {

	public static final Logger logger = LoggerFactory.getLogger(TeamController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	ParamConfigurationService paramConfigurationService;

	@Autowired
	PokemonApiService pokemonApiService;

	@PostMapping("/addPokemon")
	public ResponseEntity<String> addPokemon(@RequestHeader String token, @RequestBody PokemonTeamRequest teamRequest) {
		Login accessLogin = LoginJWTUtils.parseJWT(token);
		if (accessLogin == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
		accessLogin = loginService.findByName(accessLogin.getUsername(), accessLogin.getPassword());
		if (accessLogin == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		Team team = accessLogin.getTeam(teamRequest.getIdTeam());

		if (team == null) {
			return new ResponseEntity<String>("Team not found", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Integer maxPokemon = Integer.valueOf(paramConfigurationService.findByKey("max_pokemon").getValue());

		if (team.getPokemons() != null && team.getPokemons().size() >= maxPokemon) {
			return new ResponseEntity<String>("Quantidade máxima de " + maxPokemon + " pokemon Excedida",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Pokemon pokemon = pokemonApiService.getPokemon(teamRequest.getIdPokemon());

		boolean added = team.addPokemon(pokemon);
		if (!added) {
			return new ResponseEntity<String>("Pokemon não adicionada", HttpStatus.NOT_MODIFIED);
		}
		accessLogin = loginService.updateUser(accessLogin);

		return new ResponseEntity<String>(LoginJWTUtils.createJWT(accessLogin), HttpStatus.OK);
	}

	@PostMapping("/addMove")
	public ResponseEntity<String> addMove(@RequestHeader String token, @RequestBody PokemonTeamRequest teamRequest) {
		Login accessLogin = LoginJWTUtils.parseJWT(token);
		if (accessLogin == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		accessLogin = loginService.findByName(accessLogin.getUsername(), accessLogin.getPassword());
		if (accessLogin == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		Team team = accessLogin.getTeam(teamRequest.getIdTeam());
		if (team == null) {
			return new ResponseEntity<String>("Team não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Pokemon pokemon = team.getPokemon(teamRequest.getIdPokemon());

		if (pokemon == null) {
			return new ResponseEntity<String>("Pokemon não encontrado", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Integer maxMoves = Integer.valueOf(paramConfigurationService.findByKey("max_moves").getValue());

		if (pokemon.getMoves() != null && pokemon.getMoves().size() >= maxMoves) {
			return new ResponseEntity<String>("Quantidade máxima de " + maxMoves + " Habilidades Excedida",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}

		Move move = pokemonApiService.getMove(teamRequest.getIdMove());

		boolean added = pokemon.addMove(move);
		if (!added) {
			return new ResponseEntity<String>("Habilidade não adicionada", HttpStatus.NOT_MODIFIED);
		}

		accessLogin = loginService.updateUser(accessLogin);
		return new ResponseEntity<String>(LoginJWTUtils.createJWT(accessLogin), HttpStatus.OK);
	}

	@PostMapping("/")
	public ResponseEntity<String> addTeam(@RequestHeader String token, @RequestBody Team team) {

		Login accessLogin = LoginJWTUtils.parseJWT(token);
		if (accessLogin == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		accessLogin = loginService.findByName(accessLogin.getUsername(), accessLogin.getPassword());
		if (accessLogin == null) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}

		boolean added = accessLogin.addTeam(team);

		if (!added) {
			return new ResponseEntity<String>("Team não criado", HttpStatus.NOT_MODIFIED);
		}

		accessLogin = loginService.updateUser(accessLogin);
		return new ResponseEntity<String>(LoginJWTUtils.createJWT(accessLogin), HttpStatus.OK);
	}
}
