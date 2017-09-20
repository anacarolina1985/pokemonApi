package br.com.ana.alves.araujo.pokemon.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ContestResponse {

	@JsonProperty("use_after")
	private List<BaseResponse> useAfter;
	@JsonProperty("use_before")
	private List<BaseResponse> useBefore;

	public List<BaseResponse> getUseAfter() {
		return useAfter;
	}

	public void setUseAfter(List<BaseResponse> useAfter) {
		this.useAfter = useAfter;
	}

	public List<BaseResponse> getUseBefore() {
		return useBefore;
	}

	public void setUseBefore(List<BaseResponse> useBefore) {
		this.useBefore = useBefore;
	}

}
