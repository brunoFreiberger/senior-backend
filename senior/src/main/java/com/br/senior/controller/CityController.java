package com.br.senior.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.br.senior.dto.CityDTO;
import com.br.senior.dto.CustomPageable;
import com.br.senior.dto.PagebleData;
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
	@PostMapping(path = "/paginated")
	public @ResponseBody Page<CityDTO> getPaginatedData(@RequestBody PagebleData pageableData) {
		CustomPageable pageable = pageableData.getPageable();
		Sort sort = new Sort(pageable.getSort().getDirection(), pageable.getSort().getProperties());
		PageRequest pageRequest = PageRequest.of(pageable.getPage(), pageable.getSize(), sort);
		Page<CityDTO> data = this.service.findByFilters(pageRequest, pageableData.getFilter());
		return data;
	}

    @PostMapping(value = "/upload", consumes = "multipart/form-data")
    public @ResponseBody HttpStatus uploadMultipart(@RequestParam("file") MultipartFile file) {
        try {
			service.persistCsv(file.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
        return HttpStatus.OK;
    }
    
	@GetMapping(path = "/find/{id}")
	public @ResponseBody CityDTO getById(@PathVariable Long id) {
		CityDTO dto = this.service.findById(id);
		return dto;
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}

}
