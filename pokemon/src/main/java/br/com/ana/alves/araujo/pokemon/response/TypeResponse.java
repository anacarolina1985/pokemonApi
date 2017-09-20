package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class TypeResponse {

	private Integer slot;
	private BaseResponse type;

	public Integer getSlot() {
		return slot;
	}

	public void setSlot(Integer slot) {
		this.slot = slot;
	}

	public BaseResponse getType() {
		return type;
	}

	public void setType(BaseResponse type) {
		this.type = type;
	}

}
