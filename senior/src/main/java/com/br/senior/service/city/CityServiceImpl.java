package com.br.senior.service.city;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.br.senior.dto.CityDTO;
import com.br.senior.model.City;
import com.br.senior.repository.city.CityRepository;
import com.br.senior.utils.ObjectMapperUtils;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityRepository repository;

	private ModelMapper mapper;

	@Override
	public Page<CityDTO> findByFilters(PageRequest pageRequest, Map<String, String> filters) {
		mapper = new ModelMapper();
		Page<City> entities = repository.findByFilters(pageRequest, filters);
		Collection<CityDTO> dtos = ObjectMapperUtils.mapAll(entities.getContent(), CityDTO.class);
		return new PageImpl<CityDTO>(dtos.stream().collect(Collectors.toList()), entities.getPageable(), entities.getTotalElements());
	}

	@Override
	public CityDTO findById(Long id) {
		mapper = new ModelMapper();
		City entity = repository.findById(id).orElse(null);
		return mapper.map(entity, CityDTO.class);
	}

	@Override
	public Iterable<CityDTO> findAll() {
		mapper = new ModelMapper();
		List<City> data = repository.findAll();
		return data.parallelStream().map(entity -> mapper.map(entity, CityDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Long count() {
		return repository.count();
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public void deleteInBatch(List<CityDTO> batch) {
		mapper = new ModelMapper();
		List<City> entities = batch.parallelStream().map(dto -> mapper.map(dto, City.class))
				.collect(Collectors.toList());
		repository.deleteAll(entities);
	}

	@Override
	public CityDTO save(CityDTO obj) {
		mapper = new ModelMapper();
		City entity = mapper.map(obj, City.class);
		entity = repository.save(entity);
		obj = mapper.map(entity, CityDTO.class);
		return obj;
	}

}
