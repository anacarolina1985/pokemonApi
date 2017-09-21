package br.com.ana.alves.araujo.pokemon.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "LOGIN")
@JsonInclude(Include.NON_NULL)
public class Login {

	@ApiModelProperty(value = "Identificator field", hidden = true)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "Username value")
	@Column(name = "USER_NAME", nullable = false, unique = true)
	private String username;
	@ApiModelProperty(value = "Name value to be used on home")
	@Column(name = "NAME", nullable = false)
	private String name;
	@ApiModelProperty(value = "Email value to be used in login validate")
	@Column(name = "EMAIL", nullable = false, unique = true)
	private String email;
	@ApiModelProperty(value = "Password value")
	@Column(name = "PASSWORD", nullable = false)
	private String password;
	@OneToMany(mappedBy = "idLogin", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Team> teams;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team getTeam(Integer id) {
		Team teamReturn = null;
		if (this.getTeams() != null
				&& this.getTeams().stream().filter(team -> team.getId().equals(id)).findFirst().isPresent()) {
			teamReturn = this.getTeams().stream().filter(team -> team.getId().equals(id)).findFirst().get();
		}
		return teamReturn;
	}

	public boolean addTeam(Team team) {
		if (this.getTeams() == null) {
			this.setTeams(new ArrayList<>());
		}

		if (this.getTeams().isEmpty()) {
			this.getTeams().add(team);
			return true;
		}

		if (!this.getTeams().stream().filter(t -> t.getName().equals(team.getName())).findFirst().isPresent()) {
			this.getTeams().add(team);
			return true;
		}

		return false;
	}

}
