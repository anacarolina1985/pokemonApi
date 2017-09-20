package br.com.ana.alves.araujo.pokemon.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class VersionDetailGroupResponse {
	@JsonProperty("move_learn_method")
	private BaseResponse moveLearnMethod;
	@JsonProperty("level_learned_at")
	private Integer levelLernedAt;
	@JsonProperty("version_group")
	private BaseResponse versionGroup;

	public BaseResponse getMoveLearnMethod() {
		return moveLearnMethod;
	}

	public void setMoveLearnMethod(BaseResponse moveLearnMethod) {
		this.moveLearnMethod = moveLearnMethod;
	}

	public Integer getLevelLernedAt() {
		return levelLernedAt;
	}

	public void setLevelLernedAt(Integer levelLernedAt) {
		this.levelLernedAt = levelLernedAt;
	}

	public BaseResponse getVersionGroup() {
		return versionGroup;
	}

	public void setVersionGroup(BaseResponse versionGroup) {
		this.versionGroup = versionGroup;
	}

}
