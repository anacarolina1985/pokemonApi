package br.com.ana.alves.araujo.pokemon.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ana.alves.araujo.pokemon.model.Ability;
import br.com.ana.alves.araujo.pokemon.model.Move;
import br.com.ana.alves.araujo.pokemon.model.Pokemon;
import br.com.ana.alves.araujo.pokemon.response.AbilityResponse;
import br.com.ana.alves.araujo.pokemon.response.BaseListResponse;
import br.com.ana.alves.araujo.pokemon.response.MoveResponse;
import br.com.ana.alves.araujo.pokemon.response.PokemonResponse;
import br.com.ana.alves.araujo.pokemon.util.RestClientHttp;

@Service("pokemonApiService")
@Transactional
public class PokemonApiServiceImpl implements PokemonApiService {

	@Override
	public List<Pokemon> getAllPokemons() {
		List<Pokemon> pokemons = new ArrayList<>();
		RestClientHttp<BaseListResponse> restClient = new RestClientHttp<>();
		BaseListResponse response = restClient.get("http://pokeapi.co/api/v2/pokemon", BaseListResponse.class);

		if (response == null || response.getSize() <= 0) {
			return null;
		}

		response = restClient.get("http://pokeapi.co/api/v2/pokemon/?limit=" + response.getSize(),
				BaseListResponse.class);
		response.getResult().forEach(pokemon -> {
			Pokemon pokemonLocal = this.getPokemon(
					Integer.valueOf((pokemon.getUrl().split("http://pokeapi.co/api/v2/pokemon/")[1]).split("/")[0]));
			pokemons.add(pokemonLocal);
		});

		return pokemons;
	}

	@Override
	public Pokemon getPokemon(Integer id) {
		RestClientHttp<PokemonResponse> restClient = new RestClientHttp<>();
		PokemonResponse response = restClient.get("http://pokeapi.co/api/v2/pokemon/" + id, PokemonResponse.class);

		if (response == null) {
			return null;
		}

		Pokemon pokemon = new Pokemon();
		pokemon.setPokemonId(response.getId());
		pokemon.setName(response.getName());
		pokemon.setPokemonUrl("http://pokeapi.co/api/v2/pokemon/" + id);
		pokemon.setImageDefault(
				response.getSprites() != null
						? StringUtils.isNotBlank(response.getSprites().getFrontDefault())
								? response.getSprites().getFrontDefault() : response.getSprites().getBackDefault()
						: null);
		return pokemon;
	}

	@Override
	public List<Ability> getAllAbilities() {
		List<Ability> abilities = new ArrayList<>();
		RestClientHttp<BaseListResponse> restClient = new RestClientHttp<>();
		BaseListResponse response = restClient.get("http://pokeapi.co/api/v2/ability", BaseListResponse.class);

		if (response == null || response.getSize() <= 0) {
			return null;
		}

		response = restClient.get("http://pokeapi.co/api/v2/ability/?limit=" + response.getSize(),
				BaseListResponse.class);
		response.getResult().forEach(ability -> {
			Ability abilityLocal = this.getAbility(
					Integer.valueOf((ability.getUrl().split("http://pokeapi.co/api/v2/ability/")[1]).split("/")[0]));
			abilities.add(abilityLocal);
		});

		return abilities;
	}

	@Override
	public Ability getAbility(Integer id) {
		RestClientHttp<AbilityResponse> restClient = new RestClientHttp<>();
		AbilityResponse response = restClient.get("http://pokeapi.co/api/v2/ability/" + id, AbilityResponse.class);

		if (response == null) {
			return null;
		}

		Ability ability = new Ability();
		ability.setAbilityId(response.getId());
		ability.setName(response.getName());
		ability.setAbilityUrl("http://pokeapi.co/api/v2/pokemon/" + id);
		return ability;
	}

	@Override
	public List<Move> getAllMoves() {
		List<Move> moves = new ArrayList<>();
		RestClientHttp<BaseListResponse> restClient = new RestClientHttp<>();
		BaseListResponse response = restClient.get("http://pokeapi.co/api/v2/move", BaseListResponse.class);

		if (response == null || response.getSize() <= 0) {
			return null;
		}

		response = restClient.get("http://pokeapi.co/api/v2/move/?limit=" + response.getSize(), BaseListResponse.class);
		response.getResult().forEach(ability -> {
			Move moveLocal = this.getMove(
					Integer.valueOf((ability.getUrl().split("http://pokeapi.co/api/v2/move/")[1]).split("/")[0]));
			moves.add(moveLocal);
		});

		return moves;
	}

	@Override
	public Move getMove(Integer id) {
		RestClientHttp<MoveResponse> restClient = new RestClientHttp<>();
		MoveResponse response = restClient.get("http://pokeapi.co/api/v2/move/" + id, MoveResponse.class);

		if (response == null) {
			return null;
		}

		Move move = new Move();
		move.setMoveId(response.getId());
		move.setName(response.getName());
		move.setMoveUrl("http://pokeapi.co/api/v2/pokemon/" + id);
		return move;
	}

}
