package br.com.ana.alves.araujo.pokemon.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class AbilityResponse {

	@JsonProperty("effect_changes")
	private List<EffectChangeResponse> effectChanges;
	private String name;
	private BaseResponse generation;
	private List<PokemonResponse> pokemon;
	@JsonProperty("is_main_series")
	private Boolean mainSeries;
	@JsonProperty("effect_entries")
	private List<EffectEntryResponse> effectEntries;
	private List<NameResponse> names;
	@JsonProperty("flavor_text_entries")
	private List<FlavorTextEntryResponse> flavorTextEntries;
	private Integer id;
	private Integer slot;
	@JsonProperty("is_hidden")
	private Boolean hidden;
	private BaseResponse ability;

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

	public BaseResponse getAbility() {
		return ability;
	}

	public void setAbility(BaseResponse ability) {
		this.ability = ability;
	}

	public List<EffectChangeResponse> getEffectChanges() {
		return effectChanges;
	}

	public void setEffectChanges(List<EffectChangeResponse> effectChanges) {
		this.effectChanges = effectChanges;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseResponse getGeneration() {
		return generation;
	}

	public void setGeneration(BaseResponse generation) {
		this.generation = generation;
	}

	public List<PokemonResponse> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<PokemonResponse> pokemon) {
		this.pokemon = pokemon;
	}

	public Boolean getMainSeries() {
		return mainSeries;
	}

	public void setMainSeries(Boolean mainSeries) {
		this.mainSeries = mainSeries;
	}

	public List<EffectEntryResponse> getEffectEntries() {
		return effectEntries;
	}

	public void setEffectEntries(List<EffectEntryResponse> effectEntries) {
		this.effectEntries = effectEntries;
	}

	public List<NameResponse> getNames() {
		return names;
	}

	public void setNames(List<NameResponse> names) {
		this.names = names;
	}

	public List<FlavorTextEntryResponse> getFlavorTextEntries() {
		return flavorTextEntries;
	}

	public void setFlavorTextEntries(List<FlavorTextEntryResponse> flavorTextEntries) {
		this.flavorTextEntries = flavorTextEntries;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
