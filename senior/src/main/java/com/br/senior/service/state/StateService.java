package com.br.senior.service.state;

import java.util.List;

import com.br.senior.dto.StateDTO;
import com.br.senior.model.State;

public interface StateService {
	
	public List<State> findAll();
	
	public List<StateDTO> findAllDTO();
	
	public State save(State state);
	
	public State findByUf(String uf);

}
