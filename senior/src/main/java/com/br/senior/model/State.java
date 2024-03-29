package com.br.senior.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 
 * @author Bruno H. Freiberger
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "state")
@SequenceGenerator(name = "gen_state", sequenceName = "seq_state", allocationSize = 50)
public class State {

	@Id
	@SequenceGenerator(name = "gen_state", sequenceName = "seq_state", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_state")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "uf")
	private String uf;

	@OneToMany(mappedBy = "state", fetch = FetchType.LAZY)
	private List<City> cities = new ArrayList<>();

	public State() {
	}

	public State(String name, String uf) {
		this.name = name;
		this.uf = uf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
