package com.br.senior.service.city;

import java.io.InputStream;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.br.senior.dto.CityDTO;
import com.br.senior.dto.CityFilterDTO;

public interface CityService {
	
	public Page<CityDTO> findByFilters(PageRequest pageRequest, CityFilterDTO filter);
	
	public CityDTO findById(Long id);
	
	public Iterable<CityDTO> findAll();
	
	public Long count();
	
	public void deleteById(Long id);
	
	public void deleteInBatch(List<CityDTO> batch);
	
	public CityDTO save(CityDTO obj);
	
	public void saveAll(List<CityDTO> cities);
	
	public void persistCsv(InputStream inputStream);

}
