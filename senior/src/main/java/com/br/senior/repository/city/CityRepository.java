package com.br.senior.repository.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.br.senior.model.City;

public interface CityRepository extends JpaRepository<City, Long>, CityCustomRepository, QuerydslPredicateExecutor<City>{

}
