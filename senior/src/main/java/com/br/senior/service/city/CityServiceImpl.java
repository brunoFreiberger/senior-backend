package com.br.senior.service.city;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.br.senior.dto.CityCsvDTO;
import com.br.senior.dto.CityDTO;
import com.br.senior.dto.CityFilterDTO;
import com.br.senior.model.City;
import com.br.senior.model.State;
import com.br.senior.repository.city.CityRepository;
import com.br.senior.service.state.StateService;
import com.br.senior.utils.CsvUtils;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateService stateService;

	private ModelMapper mapper;

	@Override
	public Page<CityDTO> findByFilters(PageRequest pageRequest, CityFilterDTO filter) {
		mapper = new ModelMapper();
		mapper.getConfiguration()
		  .setMatchingStrategy(MatchingStrategies.LOOSE);
		Page<City> page = cityRepository.findByFilters(pageRequest, filter);
		List<CityDTO> dtos = page.getContent().parallelStream().map(entity -> mapper.map(entity, CityDTO.class)).collect(Collectors.toList());
		return new PageImpl<CityDTO>(dtos, page.getPageable(), page.getTotalElements());
	}

	@Override
	public CityDTO findById(Long id) {
		mapper = new ModelMapper();
		City entity = cityRepository.findById(id).orElse(null);
		return mapper.map(entity, CityDTO.class);
	}

	@Override
	public Iterable<CityDTO> findAll() {
		mapper = new ModelMapper();
		List<City> data = cityRepository.findAll();
		return data.parallelStream().map(entity -> mapper.map(entity, CityDTO.class)).collect(Collectors.toList());
	}

	@Override
	public Long count() {
		return cityRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		cityRepository.deleteById(id);
	}

	@Override
	public void deleteInBatch(List<CityDTO> batch) {
		mapper = new ModelMapper();
		List<City> entities = batch.parallelStream().map(dto -> mapper.map(dto, City.class))
				.collect(Collectors.toList());
		cityRepository.deleteAll(entities);
	}

	@Override
	public CityDTO save(CityDTO obj) {
		mapper = new ModelMapper();
		City entity = mapper.map(obj, City.class);
		State state = stateService.findByUf(obj.getStateUf());
		entity.setState(state);
		entity = cityRepository.save(entity);
		obj = mapper.map(entity, CityDTO.class);
		return obj;
	}

	@Override
	public void saveAll(List<CityDTO> cities) {
		
	}

	@Override
	public void persistCsv(InputStream inputStream) {
		try {
			List<State> loadedStates = stateService.findAll();
			List<CityCsvDTO> csvDtos = CsvUtils.read(CityCsvDTO.class, inputStream);
			csvDtos.parallelStream().forEach(csvDto -> {
				Optional<State> stateOpt = loadedStates.parallelStream().filter(s -> s.getUf().equals(csvDto.getUf())).findFirst();
				stateOpt.ifPresent(state -> cityRepository.save(new City(csvDto.getName(), csvDto.getLon(), csvDto.getLat(), csvDto.getAlternative_names(), state, csvDto.getCapital(), csvDto.getMicroregion(), csvDto.getMesoregion(), csvDto.getIbge_id(), csvDto.getNo_accents())));
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
