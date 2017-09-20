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
@Table(name = "POKEMON")
@JsonInclude(Include.NON_NULL)
public class Pokemon {

	@ApiModelProperty(value = "Identification of Pokemon", hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "Identification Team of Pokemon", hidden = true)
	private Integer idTeam;
	@ApiModelProperty(value = "name of Team")
	@Column(name = "NAME", nullable = false)
	private String name;
	@ApiModelProperty(value = "identificator of pokemon site api")
	@Column(name = "POKEMON_ID", nullable = false)
	private Integer pokemonId;
	@ApiModelProperty(value = "Url of pokemon site api")
	@Column(name = "POKEMON_URL", nullable = false)
	private String pokemonUrl;
	@ApiModelProperty(value = "List of ability pokemon site api")
	@OneToMany(mappedBy = "idPokemon", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Ability> abilities;
	@ApiModelProperty(value = "URL of image pokemon default")
	@Column(name = "IMAGE_DEFULT")
	private String imageDefault;
	@ApiModelProperty(value = "List of Moves pokemon site api")
	@OneToMany(mappedBy = "idPokemon", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Move> moves;

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

	public Integer getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(Integer pokemonId) {
		this.pokemonId = pokemonId;
	}

	public String getPokemonUrl() {
		return pokemonUrl;
	}

	public void setPokemonUrl(String pokemonUrl) {
		this.pokemonUrl = pokemonUrl;
	}

	public List<Ability> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<Ability> abilities) {
		this.abilities = abilities;
	}

	public Integer getIdTeam() {
		return idTeam;
	}

	public void setIdTeam(Integer idTeam) {
		this.idTeam = idTeam;
	}

	public String getImageDefault() {
		return imageDefault;
	}

	public void setImageDefault(String imageDefault) {
		this.imageDefault = imageDefault;
	}

	public List<Move> getMoves() {
		return moves;
	}

	public void setMoves(List<Move> moves) {
		this.moves = moves;
	}

	public boolean addMove(Move move) {
		if (this.getMoves() == null) {
			this.setMoves(new ArrayList<>());
		}

		if (this.getMoves().isEmpty()) {
			this.getMoves().add(move);
			return true;
		}

		if (!this.getMoves().stream().filter(mov -> mov.getMoveId().equals(move.getMoveId())).findFirst().isPresent()) {
			this.getMoves().add(move);
			return true;
		}

		return false;

	}

	public boolean addAbility(Ability ability) {
		if (this.getAbilities() == null) {
			this.setAbilities(new ArrayList<>());
		}

		if (this.getAbilities().isEmpty()) {
			this.getAbilities().add(ability);
			return true;
		}

		if (!this.getAbilities().stream().filter(abi -> abi.getAbilityId().equals(ability.getAbilityId())).findFirst()
				.isPresent()) {
			this.getAbilities().add(ability);
			return true;
		}

		return false;

	}

}
