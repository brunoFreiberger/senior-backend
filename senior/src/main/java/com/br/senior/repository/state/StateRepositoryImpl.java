package com.br.senior.repository.state;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class StateRepositoryImpl implements StateCustomRepository {
	
	@Autowired
	private EntityManager em;
	
}
