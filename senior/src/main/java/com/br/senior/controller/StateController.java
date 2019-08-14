package com.br.senior.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.senior.dto.StateDTO;
import com.br.senior.service.state.StateService;

@Controller
@RequestMapping(path = "/state")
public class StateController {
	
	@Autowired
	private StateService service;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<StateDTO> getAll() {
		Iterable<StateDTO> objs = this.service.findAllDTO();
		return objs;
	}

}
