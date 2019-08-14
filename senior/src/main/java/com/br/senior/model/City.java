package com.br.senior.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@Table(name = "city")
@SequenceGenerator(name = "gen_city", sequenceName = "seq_city", allocationSize = 50)
public class City {

	@Id
	@SequenceGenerator(name = "gen_city", sequenceName = "seq_city", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_city")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lon")
	private String lon;

	@Column(name = "lat")
	private String lat;

	@Column(name = "alternativeName")
	private String alternativeName;

	@ManyToOne(fetch = FetchType.EAGER)
	private State state;

	@Column(name = "capital")
	private boolean capital;

	@Column(name = "microregion")
	private String microregion;

	@Column(name = "mesoregion")
	private String mesoregion;

	@Column(name = "ibge_id")
	private String ibgeId;

	@Column(name = "no_accents")
	private String noAccents;

	public City() {
		// TODO Auto-generated constructor stub
	}

	public City(String name, String lon, String lat, String alternativeName, State state, boolean capital,
			String microregion, String mesoregion, String ibgeId, String noAccents) {
		this.name = name;
		this.lon = lon;
		this.lat = lat;
		this.alternativeName = alternativeName;
		this.state = state;
		this.capital = capital;
		this.microregion = microregion;
		this.mesoregion = mesoregion;
		this.ibgeId = ibgeId;
		this.noAccents = noAccents;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isCapital() {
		return capital;
	}

	public void setCapital(boolean capital) {
		this.capital = capital;
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
		City other = (City) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
