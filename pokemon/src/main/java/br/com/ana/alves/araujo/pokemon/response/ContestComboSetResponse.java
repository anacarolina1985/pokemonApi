package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContestComboSetResponse {

	@JsonProperty("super")
	private ContestResponse superResponse;
	private ContestResponse normal;

	public ContestResponse getSuperResponse() {
		return superResponse;
	}

	public void setSuperResponse(ContestResponse superResponse) {
		this.superResponse = superResponse;
	}

	public ContestResponse getNormal() {
		return normal;
	}

	public void setNormal(ContestResponse normal) {
		this.normal = normal;
	}

}
