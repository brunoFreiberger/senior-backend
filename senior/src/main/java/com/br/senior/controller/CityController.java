package com.br.senior.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.senior.dto.CityDTO;
import com.br.senior.service.city.CityService;

@Controller
@RequestMapping(path = "/city")
public class CityController implements ErrorController {
	
	@Autowired
	private CityService service;
	
	/**
	 * Salvar/Atualizar a cidade.
	 * 
	 * @param obj
	 * @return CityDTO
	 */
	@PostMapping(path = "/save")
	public @ResponseBody CityDTO save(@RequestBody CityDTO obj) {
		return this.service.save(obj);
	}
	
	/**
	 * Remover a cidade através do ID
	 * @param id
	 * @return
	 */
	@DeleteMapping(path = "/remove/{id}")
	public @ResponseBody HttpStatus remove(@PathVariable Long id) {
		this.service.deleteById(id);
		return HttpStatus.OK;
	}
	
	@PostMapping(path = "/remove")
	public @ResponseBody HttpStatus remove(@RequestBody List<CityDTO> batch) {
		this.service.deleteInBatch(batch);
		return HttpStatus.OK;
	}
	
	/**
	 * Buscar a quantidade total de cidades
	 * @return
	 */
	@GetMapping(path = "/count")
	public @ResponseBody Long count() {
		Long count = this.service.count();
		return count;
	}

	/**
	 * Retornar uma lista paginada de cidades.
	 * @param pageableData
	 * @return
	 */
	@PostMapping(path = "/paginatedListFilter")
	public @ResponseBody Page<CityDTO> getPaginatedData(@RequestBody PageRequest pageRequest) {
		return null;
	
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
