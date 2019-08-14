package com.br.senior.service.state;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.senior.dto.StateDTO;
import com.br.senior.model.State;
import com.br.senior.repository.state.StateRepository;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateRepository repository;
	
	
	@Override
	public List<State> findAll() {
		return repository.findAll();
	}

	@Override
	public State save(State state) {
		return repository.save(state);
	}

	@Override
	public List<StateDTO> findAllDTO() {
		ModelMapper mapper = new ModelMapper();
		return findAll().parallelStream().map(entity -> mapper.map(entity, StateDTO.class)).collect(Collectors.toList());
	}

}
