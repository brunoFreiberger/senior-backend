package com.br.senior.dto;

import java.util.HashSet;
import java.util.Set;

public class StateDTO {

	private Long id;
	private String name;
	private String uf;
	private CityDTO capital;
	private Set<CityDTO> cities = new HashSet<>();

	public StateDTO() {
		// TODO Auto-generated constructor stub
	}

	public StateDTO(Long id, String name, String uf, CityDTO capital, Set<CityDTO> cities) {
		this.id = id;
		this.name = name;
		this.uf = uf;
		this.capital = capital;
		this.cities = cities;
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

	public CityDTO getCapital() {
		return capital;
	}

	public void setCapital(CityDTO capital) {
		this.capital = capital;
	}

	public Set<CityDTO> getCities() {
		return cities;
	}

	public void setCities(Set<CityDTO> cities) {
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
		StateDTO other = (StateDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
