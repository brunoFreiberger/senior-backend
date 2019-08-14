package com.br.senior.repository.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.br.senior.dto.CityFilterDTO;
import com.br.senior.model.City;
import com.br.senior.model.QCity;
import com.br.senior.utils.CommonUtils;
import com.querydsl.core.BooleanBuilder;

public class CityRepositoryImpl implements CityCustomRepository {
	
	@Autowired
	private CityRepository cityRepository;

	@Override
	public Page<City> findByFilters(PageRequest pageRequest, CityFilterDTO filter) {
		QCity city = QCity.city;

		BooleanBuilder predicate = new BooleanBuilder();

		if (!CommonUtils.isNull(filter.getIbgeId())) {
			predicate.and(city.ibgeId.eq(filter.getIbgeId()));
		}

		if (!CommonUtils.isNull(filter.getStateId())) {
			predicate.and(city.state.id.eq(filter.getStateId()));
		}
		
		predicate.and(city.capital.eq(filter.isCapital()));

		Page<City> cities = this.cityRepository.findAll(predicate, pageRequest);
		
		return cities;
	}

}
