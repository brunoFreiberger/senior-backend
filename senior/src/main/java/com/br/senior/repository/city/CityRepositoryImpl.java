package com.br.senior.repository.city;

import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.br.senior.model.City;

public class CityRepositoryImpl implements CityCustomRepository {

	@Override
	public Page<City> findByFilters(PageRequest pageRequest, Map<String, String> filters) {
		return null;
	}

}
