package com.br.senior.service.city;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.br.senior.dto.CityDTO;

public interface CityService {
	
	public Page<CityDTO> findByFilters(PageRequest pageRequest, Map<String, String> filters);
	
	public CityDTO findById(Long id);
	
	public Iterable<CityDTO> findAll();
	
	public Long count();
	
	public void deleteById(Long id);
	
	public void deleteInBatch(List<CityDTO> batch);
	
	public CityDTO save(CityDTO obj);

}
