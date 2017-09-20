package br.com.ana.alves.araujo.pokemon.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class EffectChangeResponse {
	@JsonProperty("effect_entries")
	private List<EffectEntryResponse> effectEntries;
	@JsonProperty("version_group")
	private BaseResponse versionGroup;

	public List<EffectEntryResponse> getEffectEntries() {
		return effectEntries;
	}

	public void setEffectEntries(List<EffectEntryResponse> effectEntries) {
		this.effectEntries = effectEntries;
	}

	public BaseResponse getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(BaseResponse versionGroup) {
		this.versionGroup = versionGroup;
	}

}
