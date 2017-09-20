package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class GameIndiceResponse {

	private BaseResponse version;
	@JsonProperty("game_index")
	private Integer gameIndex;

	public BaseResponse getVersion() {
		return version;
	}

	public void setVersion(BaseResponse version) {
		this.version = version;
	}

	public Integer getGameIndex() {
		return gameIndex;
	}

	public void setGameIndex(Integer gameIndex) {
		this.gameIndex = gameIndex;
	}

}
