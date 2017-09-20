package br.com.ana.alves.araujo.pokemon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "PARAM_CONFIG")
public class ParamConfiguration {

	@ApiModelProperty(value = "Identification of Param")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ApiModelProperty(value = "key Identification of Param")
	@Column(name = "KEY_PARAM", nullable = false, unique = true)
	private String key;

	@ApiModelProperty(value = "value of Param")
	@Column(name = "VALUE_PARAM", nullable = false)
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
