package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class NameResponse {

	private String name;
	private BaseResponse language;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseResponse getLanguage() {
		return language;
	}

	public void setLanguage(BaseResponse language) {
		this.language = language;
	}

}
