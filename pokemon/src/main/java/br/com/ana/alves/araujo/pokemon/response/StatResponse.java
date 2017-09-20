package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class StatResponse {
	private BaseResponse stat;
	private Integer effort;
	@JsonProperty("base_stat")
	private Integer BaseStat;

	public BaseResponse getStat() {
		return stat;
	}

	public void setStat(BaseResponse stat) {
		this.stat = stat;
	}

	public Integer getEffort() {
		return effort;
	}

	public void setEffort(Integer effort) {
		this.effort = effort;
	}

	public Integer getBaseStat() {
		return BaseStat;
	}

	public void setBaseStat(Integer baseStat) {
		BaseStat = baseStat;
	}

}
