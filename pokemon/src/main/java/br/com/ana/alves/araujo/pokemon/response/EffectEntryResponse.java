package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class EffectEntryResponse {

	@JsonProperty("short_effect")
	private String shortEffect;

	public String getShortEffect() {
		return shortEffect;
	}

	public void setShortEffect(String shortEffect) {
		this.shortEffect = shortEffect;
	}

	private String effect;
	private BaseResponse language;

	public String getEffect() {
		return effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	public BaseResponse getLanguage() {
		return language;
	}

	public void setLanguage(BaseResponse language) {
		this.language = language;
	}

}
