package br.com.ana.alves.araujo.pokemon.request;

public class PokemonTeamRequest {

	private Integer idPokemon;
	private Integer idTeam;
	private Integer idAbility;
	private Integer idMove;

	public Integer getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(Integer id) {
		this.idPokemon = id;
	}

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public Integer getIdAbility() {
		return idAbility;
	}

	public void setIdAbility(Integer idAbility) {
		this.idAbility = idAbility;
	}

	public Integer getIdMove() {
		return idMove;
	}

	public void setIdMove(Integer idMove) {
		this.idMove = idMove;
	}

}
