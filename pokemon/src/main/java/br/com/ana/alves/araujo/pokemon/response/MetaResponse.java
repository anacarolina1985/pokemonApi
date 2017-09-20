package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetaResponse {

	private BaseResponse category;
	private Integer healing;
	@JsonProperty("max_turns")
	private Integer maxTurns;
	private Integer drain;
	private BaseResponse ailment;
	@JsonProperty("stat_chance")
	private Integer statChance;
	@JsonProperty("flinch_chance")
	private Integer flinchChance;
	@JsonProperty("min_hits")
	private Integer minHits;
	@JsonProperty("ailment_chance")
	private Integer ailmentChance;
	@JsonProperty("crit_rate")
	private Integer critRate;
	@JsonProperty("min_turns")
	private Integer minTurns;
	@JsonProperty("max_hits")
	private Integer maxHits;

	public BaseResponse getCategory() {
		return category;
	}

	public void setCategory(BaseResponse category) {
		this.category = category;
	}

	public Integer getHealing() {
		return healing;
	}

	public void setHealing(Integer healing) {
		this.healing = healing;
	}

	public Integer getMaxTurns() {
		return maxTurns;
	}

	public void setMaxTurns(Integer maxTurns) {
		this.maxTurns = maxTurns;
	}

	public Integer getDrain() {
		return drain;
	}

	public void setDrain(Integer drain) {
		this.drain = drain;
	}

	public BaseResponse getAilment() {
		return ailment;
	}

	public void setAilment(BaseResponse ailment) {
		this.ailment = ailment;
	}

	public Integer getStatChance() {
		return statChance;
	}

	public void setStatChance(Integer statChance) {
		this.statChance = statChance;
	}

	public Integer getFlinchChance() {
		return flinchChance;
	}

	public void setFlinchChance(Integer flinchChance) {
		this.flinchChance = flinchChance;
	}

	public Integer getMinHits() {
		return minHits;
	}

	public void setMinHits(Integer minHits) {
		this.minHits = minHits;
	}

	public Integer getAilmentChance() {
		return ailmentChance;
	}

	public void setAilmentChance(Integer ailmentChance) {
		this.ailmentChance = ailmentChance;
	}

	public Integer getCritRate() {
		return critRate;
	}

	public void setCritRate(Integer critRate) {
		this.critRate = critRate;
	}

	public Integer getMinTurns() {
		return minTurns;
	}

	public void setMinTurns(Integer minTurns) {
		this.minTurns = minTurns;
	}

	public Integer getMaxHits() {
		return maxHits;
	}

	public void setMaxHits(Integer maxHits) {
		this.maxHits = maxHits;
	}

}
