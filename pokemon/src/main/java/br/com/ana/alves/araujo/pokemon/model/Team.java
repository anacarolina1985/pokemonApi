package br.com.ana.alves.araujo.pokemon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "TEAM")
@JsonInclude(Include.NON_NULL)
public class Team {

	@ApiModelProperty(value = "Identification of Team", hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "id of Login", hidden = true)
	private Integer idLogin;
	@ApiModelProperty(value = "name of Team")
	@Column(name = "NAME", nullable = false)
	private String name;
	@ApiModelProperty(value = "list of pokemon at the Team")
	@OneToMany(mappedBy = "idTeam", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Pokemon> pokemons;

	public Integer getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Integer idLogin) {
		this.idLogin = idLogin;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(List<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	public boolean addPokemon(Pokemon pokemon) {
		if (this.getPokemons() == null) {
			this.setPokemons(new ArrayList<>());
		}

		if (this.getPokemons().isEmpty()) {
			this.getPokemons().add(pokemon);
			return true;
		}

		if (!this.getPokemons().stream().filter(pok -> pok.getPokemonId().equals(pokemon.getPokemonId())).findFirst()
				.isPresent()) {
			this.getPokemons().add(pokemon);
			return true;
		}

		return false;
	}

	public Pokemon getPokemon(Integer id) {
		Pokemon pokemonReturn = null;
		if (this.getPokemons() != null
				&& this.getPokemons().stream().filter(pokemon -> pokemon.getId().equals(id)).findFirst().isPresent()) {
			pokemonReturn = this.getPokemons().stream().filter(pokemon -> pokemon.getId().equals(id)).findFirst().get();
		}
		return pokemonReturn;
	}

}
