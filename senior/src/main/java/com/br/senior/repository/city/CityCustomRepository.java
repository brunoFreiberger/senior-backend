package com.br.senior.repository.city;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.br.senior.dto.CityFilterDTO;
import com.br.senior.model.City;

public interface CityCustomRepository {

	public Page<City> findByFilters(PageRequest pageRequest, CityFilterDTO filter);
	
}
