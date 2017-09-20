package br.com.ana.alves.araujo.pokemon.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class BaseListResponse {

	@JsonProperty("count")
	private Integer size;
	@JsonProperty("previous")
	private String urlPrevius;
	@JsonProperty("next")
	private String urlNext;
	@JsonProperty("results")
	private List<BaseResponse> result;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getUrlPrevius() {
		return urlPrevius;
	}

	public void setUrlPrevius(String urlPrevius) {
		this.urlPrevius = urlPrevius;
	}

	public List<BaseResponse> getResult() {
		return result;
	}

	public void setResult(List<BaseResponse> pokemons) {
		this.result = pokemons;
	}

}
