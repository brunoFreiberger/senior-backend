package com.br.senior.repository.state;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.br.senior.model.City;
import com.br.senior.model.State;

public interface StateRepository extends JpaRepository<State, Long>, StateCustomRepository, QuerydslPredicateExecutor<State>{

}
