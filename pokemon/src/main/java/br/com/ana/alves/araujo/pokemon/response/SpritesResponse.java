package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class SpritesResponse {
	@JsonProperty("back_female")
	private String backFemale;
	@JsonProperty("back_shiny_female")
	private String backShinyFemale;
	@JsonProperty("back_default")
	private String backDefault;
	@JsonProperty("front_female")
	private String frontFemale;
	@JsonProperty("front_shiny_female")
	private String frontShinyFemale;
	@JsonProperty("back_shiny")
	private String backShiny;
	@JsonProperty("front_default")
	private String frontDefault;
	@JsonProperty("front_shiny")
	private String frontShiny;

	public String getBackFemale() {
		return backFemale;
	}

	public void setBackFemale(String backFemale) {
		this.backFemale = backFemale;
	}

	public String getBackShinyFemale() {
		return backShinyFemale;
	}

	public void setBackShinyFemale(String backShinyFemale) {
		this.backShinyFemale = backShinyFemale;
	}

	public String getBackDefault() {
		return backDefault;
	}

	public void setBackDefault(String backDefault) {
		this.backDefault = backDefault;
	}

	public String getFrontFemale() {
		return frontFemale;
	}

	public void setFrontFemale(String frontFemale) {
		this.frontFemale = frontFemale;
	}

	public String getFrontShinyFemale() {
		return frontShinyFemale;
	}

	public void setFrontShinyFemale(String frontShinyFemale) {
		this.frontShinyFemale = frontShinyFemale;
	}

	public String getBackShiny() {
		return backShiny;
	}

	public void setBackShiny(String backShiny) {
		this.backShiny = backShiny;
	}

	public String getFrontDefault() {
		return frontDefault;
	}

	public void setFrontDefault(String frontDefault) {
		this.frontDefault = frontDefault;
	}

	public String getFrontShiny() {
		return frontShiny;
	}

	public void setFrontShiny(String frontShiny) {
		this.frontShiny = frontShiny;
	}

}
