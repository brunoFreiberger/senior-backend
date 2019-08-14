package com.br.senior.config;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.br.senior.model.State;
import com.br.senior.service.state.StateService;

@Component
public class DataLoaderBean {

	private static final Logger LOG = Logger.getLogger(DataLoaderBean.class);

	@Autowired
	private StateService stateService;

	@PostConstruct
	public void init() {
		List<State> states = Arrays.asList(new State("Acre", "AC"), new State("Alagoas", "AL"),
				new State("Amapá", "AP"), new State("Amazonas", "AM"), new State("Bahia", "BA"),
				new State("Ceará", "CE"), new State("Distrito Federal", "DF"), new State("Espírito Santo", "ES"),
				new State("Goiás", "GO"), new State("Maranhão", "MA"), new State("Mato Grosso", "MT"),
				new State("Mato Grosso do Sul", "MS"), new State("Minas Gerais", "MG"), new State("Pará", "PA"),
				new State("Paraíba", "PB"), new State("Paraná", "PR"), new State("Pernambuco", "PE"),
				new State("Piauí", "PI"), new State("Rio de Janeiro", "RJ"), new State("Rio Grande do Norte", "RN"),
				new State("Rio Grande do Sul", "RS"), new State("Rondônia", "RO"), new State("Roraima", "RR"),
				new State("Santa Catarina", "SC"), new State("São Paulo", "SP"), new State("Sergipe", "SE"),
				new State("Tocantins", "TO"));
		
		states.stream().forEach(state -> {
			stateService.save(state);
		});
		
		LOG.info("Estados criados com sucesso!");
	}
}
