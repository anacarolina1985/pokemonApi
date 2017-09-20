package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class FlavorTextEntryResponse {
	@JsonProperty("flavor_text")
	private String flavorText;
	private BaseResponse language;
	@JsonProperty("version_group")
	private BaseResponse versionGroup;

	public String getFlavorText() {
		return flavorText;
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public BaseResponse getLanguage() {
		return language;
	}

	public void setLanguage(BaseResponse language) {
		this.language = language;
	}

	public BaseResponse getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(BaseResponse versionGroup) {
		this.versionGroup = versionGroup;
	}

}
