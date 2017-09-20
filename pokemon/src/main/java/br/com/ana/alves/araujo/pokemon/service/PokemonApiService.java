package br.com.ana.alves.araujo.pokemon.service;

import java.util.List;

import br.com.ana.alves.araujo.pokemon.model.Ability;
import br.com.ana.alves.araujo.pokemon.model.Move;
import br.com.ana.alves.araujo.pokemon.model.Pokemon;

public interface PokemonApiService {

	List<Pokemon> getAllPokemons();

	Pokemon getPokemon(Integer id);

	List<Ability> getAllAbilities();

	Ability getAbility(Integer id);

	List<Move> getAllMoves();

	Move getMove(Integer id);
}
