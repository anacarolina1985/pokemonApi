package br.com.ana.alves.araujo.pokemon.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PokemonResponse {

	private List<BaseResponse> forms;
	private List<AbilityResponse> abilities;
	private List<StatResponse> stats;
	private Integer slot;
	@JsonProperty("is_hidden")
	private Boolean hidden;
	private BaseResponse pokemon;
	private String name;
	private Integer weight;
	private List<MoveResponse> moves;
	private SpritesResponse sprites;
	@JsonProperty("held_items")
	private List<?> heldItens;
	@JsonProperty("location_area_encounters")
	private String locationAreaEncounters;
	private Integer height;
	@JsonProperty("is_default")
	private Boolean defaultPokemon;
	private BaseResponse species;
	private Integer id;
	private Integer order;
	@JsonProperty("game_indices")
	private List<GameIndiceResponse> gameIndeces;
	@JsonProperty("base_experience")
	private Integer baseExperience;
	private List<TypeResponse> types;

	public List<BaseResponse> getForms() {
		return forms;
	}

	public void setForms(List<BaseResponse> forms) {
		this.forms = forms;
	}

	public List<AbilityResponse> getAbilities() {
		return abilities;
	}

	public void setAbilities(List<AbilityResponse> abilities) {
		this.abilities = abilities;
	}

	public List<StatResponse> getStats() {
		return stats;
	}

	public void setStats(List<StatResponse> stats) {
		this.stats = stats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public List<MoveResponse> getMoves() {
		return moves;
	}

	public void setMoves(List<MoveResponse> moves) {
		this.moves = moves;
	}

	public SpritesResponse getSprites() {
		return sprites;
	}

	public void setSprites(SpritesResponse sprites) {
		this.sprites = sprites;
	}

	public List<?> getHeldItens() {
		return heldItens;
	}

	public void setHeldItens(List<?> heldItens) {
		this.heldItens = heldItens;
	}

	public String getLocationAreaEncounters() {
		return locationAreaEncounters;
	}

	public void setLocationAreaEncounters(String locationAreaEncounters) {
		this.locationAreaEncounters = locationAreaEncounters;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Boolean getDefaultPokemon() {
		return defaultPokemon;
	}

	public void setDefaultPokemon(Boolean defaultPokemon) {
		this.defaultPokemon = defaultPokemon;
	}

	public BaseResponse getSpecies() {
		return species;
	}

	public void setSpecies(BaseResponse species) {
		this.species = species;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrder() {
		return order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<GameIndiceResponse> getGameIndeces() {
		return gameIndeces;
	}

	public void setGameIndeces(List<GameIndiceResponse> gameIndeces) {
		this.gameIndeces = gameIndeces;
	}

	public Integer getBaseExperience() {
		return baseExperience;
	}

	public void setBaseExperience(Integer baseExperience) {
		this.baseExperience = baseExperience;
	}

	public List<TypeResponse> getTypes() {
		return types;
	}

	public void setTypes(List<TypeResponse> types) {
		this.types = types;
	}

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public Boolean getHidden() {
		return hidden;
	}

	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}

	public BaseResponse getPokemon() {
		return pokemon;
	}

	public void setPokemon(BaseResponse pokemon) {
		this.pokemon = pokemon;
	}

}
