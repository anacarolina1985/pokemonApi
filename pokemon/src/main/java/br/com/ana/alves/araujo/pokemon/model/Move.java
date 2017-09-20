package br.com.ana.alves.araujo.pokemon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "ABILITY")
@JsonInclude(Include.NON_NULL)
public class Move {

	@ApiModelProperty(value = "Identification of Move", hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "Identification of Pokemon", hidden = true)
	private Integer idPokemon;
	@ApiModelProperty(value = "name of Move")
	@Column(name = "NAME", nullable = false)
	private String name;
	@ApiModelProperty(value = "identificator of ability site api")
	@Column(name = "ABILITY_ID", nullable = false)
	private Integer abilityId;
	@ApiModelProperty(value = "Url of ability site api")
	@Column(name = "ABILITY_URL", nullable = false)
	private String abilityUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(Integer idPokemon) {
		this.idPokemon = idPokemon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getMoveId() {
		return abilityId;
	}

	public void setMoveId(Integer abilityId) {
		this.abilityId = abilityId;
	}

	public String getMoveUrl() {
		return abilityUrl;
	}

	public void setMoveUrl(String abilityUrl) {
		this.abilityUrl = abilityUrl;
	}

}
