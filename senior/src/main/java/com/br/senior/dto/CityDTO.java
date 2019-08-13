package com.br.senior.dto;

/**
 * 
 * @author Bruno H. Freiberger
 *
 */
public class CityDTO {
	
	private Long id;
	private String name;
	private String lon;
	private String lat;
	private String alternativeName;
	private StateDTO state;
	
	public CityDTO() {
		// TODO Auto-generated constructor stub
	}

	public CityDTO(Long id, String name, String lon, String lat, String alternativeName, StateDTO state) {
		this.id = id;
		this.name = name;
		this.lon = lon;
		this.lat = lat;
		this.alternativeName = alternativeName;
		this.state = state;
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

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getAlternativeName() {
		return alternativeName;
	}

	public void setAlternativeName(String alternativeName) {
		this.alternativeName = alternativeName;
	}

	public StateDTO getState() {
		return state;
	}

	public void setState(StateDTO state) {
		this.state = state;
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
		CityDTO other = (CityDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
