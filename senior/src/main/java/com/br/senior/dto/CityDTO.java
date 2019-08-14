package com.br.senior.dto;

/**
 * 
 * @author Bruno H. Freiberger
 *
 */
public class CityDTO {

	private Long id;
	private String ibgeId;
	private String name;
	private String lon;
	private String lat;
	private String alternativeName;
	private String stateUf;
	private boolean capital;
	private String noAccents;
	private String microregion;
	private String mesoregion;

	public CityDTO() {
		// TODO Auto-generated constructor stub
	}

	public CityDTO(String ibgeId, String name, String lon, String lat, String alternativeName, String stateUf,
			boolean capital, String noAccents, String microregion, String mesoregion) {
		this.ibgeId = ibgeId;
		this.name = name;
		this.lon = lon;
		this.lat = lat;
		this.alternativeName = alternativeName;
		this.stateUf = stateUf;
		this.capital = capital;
		this.noAccents = noAccents;
		this.microregion = microregion;
		this.mesoregion = mesoregion;
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

	public String getStateUf() {
		return stateUf;
	}

	public void setStateUf(String stateUf) {
		this.stateUf = stateUf;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
	}

	public Boolean getCapital() {
		return capital;
	}

	public void setCapital(Boolean capital) {
		this.capital = capital;
	}
	
	public String getIbgeId() {
		return ibgeId;
	}

	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}
	
	public String getNoAccents() {
		return noAccents;
	}

	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}
	
	public String getMicroregion() {
		return microregion;
	}

	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}

	public String getMesoregion() {
		return mesoregion;
	}

	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
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
