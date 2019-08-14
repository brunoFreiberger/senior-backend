package com.br.senior.dto;

public class CityFilterDTO {
	
	private Long stateId;
	private String ibgeId;
	private boolean capital;
	
	public CityFilterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getStateId() {
		return stateId;
	}
	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}
	public String getIbgeId() {
		return ibgeId;
	}
	public void setIbgeId(String ibgeId) {
		this.ibgeId = ibgeId;
	}
	public boolean isCapital() {
		return capital;
	}
	public void setCapital(boolean capital) {
		this.capital = capital;
	}
}
