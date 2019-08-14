package com.br.senior.dto;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

/**
 * @author bruno.freiberger
 *
 */
public class Sort {
	
	private List<String> properties;
	private Direction direction;
	
	public Sort(List<String> properties, Direction direction) {
		this.properties = properties;
		this.direction = direction;
	}
	
	public Sort() {
		// TODO Auto-generated constructor stub
	}
	
	public List<String> getProperties() {
		return properties;
	}
	public void setProperties(List<String> properties) {
		this.properties = properties;
	}
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction direction) {
		this.direction = direction;
	}

}
