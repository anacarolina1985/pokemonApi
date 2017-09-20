package br.com.ana.alves.araujo.pokemon.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class MoveResponse {
	@JsonProperty("version_group_details")
	private List<VersionDetailGroupResponse> versionGroupDetail;
	private BaseResponse move;
	private Integer id;
	private String name;
	private Integer accuracy;
	@JsonProperty("effect_chance")
	private Integer effectChance;
	private BaseResponse generation;
	@JsonProperty("stat_changes")
	private List<StatResponse> statChanges;
	@JsonProperty("effect_changes")
	private List<EffectChangeResponse> effectChanges;
	private List<NameResponse> names;
	private List<?> machines;
	@JsonProperty("pp")
	private Integer powerPoints;
	private Integer priority;
	private Integer power;
	@JsonProperty("contest_combos")
	private ContestComboSetResponse ContestComboSets;
	@JsonProperty("effect_entries")
	private List<EffectEntryResponse> effectEntries;
	@JsonProperty("contest_type")
	private BaseListResponse contestType;
	@JsonProperty("contest_effect")
	private BaseResponse contestEffect;
	private BaseResponse type;
	@JsonProperty("past_values")
	private List<?> pastValues;
	private BaseResponse target;
	@JsonProperty("super_contest_effect")
	private BaseResponse superContestEffect;
	@JsonProperty("flavor_text_entries")
	private List<FlavorTextEntryResponse> flavorTextEntries;
	@JsonProperty("damage_class")
	private BaseResponse damageClass;
	private MetaResponse meta;

	public List<VersionDetailGroupResponse> getVersionGroupDetail() {
		return versionGroupDetail;
	}

	public void setVersionGroupDetail(List<VersionDetailGroupResponse> versionGroupDetail) {
		this.versionGroupDetail = versionGroupDetail;
	}

	public BaseResponse getMove() {
		return move;
	}

	public void setMove(BaseResponse move) {
		this.move = move;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(Integer accuracy) {
		this.accuracy = accuracy;
	}

	public Integer getEffectChance() {
		return effectChance;
	}

	public void setEffectChance(Integer effectChance) {
		this.effectChance = effectChance;
	}

	public BaseResponse getGeneration() {
		return generation;
	}

	public void setGeneration(BaseResponse generation) {
		this.generation = generation;
	}

	public List<StatResponse> getStatChanges() {
		return statChanges;
	}

	public void setStatChanges(List<StatResponse> statChanges) {
		this.statChanges = statChanges;
	}

	public List<EffectChangeResponse> getEffectChanges() {
		return effectChanges;
	}

	public void setEffectChanges(List<EffectChangeResponse> effectChanges) {
		this.effectChanges = effectChanges;
	}

	public List<NameResponse> getNames() {
		return names;
	}

	public void setNames(List<NameResponse> names) {
		this.names = names;
	}

	public List<?> getMachines() {
		return machines;
	}

	public void setMachines(List<?> machines) {
		this.machines = machines;
	}

	public Integer getPowerPoints() {
		return powerPoints;
	}

	public void setPowerPoints(Integer powerPoints) {
		this.powerPoints = powerPoints;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public ContestComboSetResponse getContestComboSets() {
		return ContestComboSets;
	}

	public void setContestComboSets(ContestComboSetResponse contestComboSets) {
		ContestComboSets = contestComboSets;
	}

	public List<EffectEntryResponse> getEffectEntries() {
		return effectEntries;
	}

	public void setEffectEntries(List<EffectEntryResponse> effectEntries) {
		this.effectEntries = effectEntries;
	}

	public BaseListResponse getContestType() {
		return contestType;
	}

	public void setContestType(BaseListResponse contestType) {
		this.contestType = contestType;
	}

	public BaseResponse getContestEffect() {
		return contestEffect;
	}

	public void setContestEffect(BaseResponse contestEffect) {
		this.contestEffect = contestEffect;
	}

	public BaseResponse getType() {
		return type;
	}

	public void setType(BaseResponse type) {
		this.type = type;
	}

	public List<?> getPastValues() {
		return pastValues;
	}

	public void setPastValues(List<?> pastValues) {
		this.pastValues = pastValues;
	}

	public BaseResponse getTarget() {
		return target;
	}

	public void setTarget(BaseResponse target) {
		this.target = target;
	}

	public BaseResponse getSuperContestEffect() {
		return superContestEffect;
	}

	public void setSuperContestEffect(BaseResponse superContestEffect) {
		this.superContestEffect = superContestEffect;
	}

	public List<FlavorTextEntryResponse> getFlavorTextEntries() {
		return flavorTextEntries;
	}

	public void setFlavorTextEntries(List<FlavorTextEntryResponse> flavorTextEntries) {
		this.flavorTextEntries = flavorTextEntries;
	}

	public BaseResponse getDamageClass() {
		return damageClass;
	}

	public void setDamageClass(BaseResponse damageClass) {
		this.damageClass = damageClass;
	}

	public MetaResponse getMeta() {
		return meta;
	}

	public void setMeta(MetaResponse meta) {
		this.meta = meta;
	}

}
