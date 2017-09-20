package br.com.ana.alves.araujo.pokemon.service;

import java.util.List;

import br.com.ana.alves.araujo.pokemon.model.ParamConfiguration;

public interface ParamConfigurationService {

	ParamConfiguration findById(Integer id);

	void deleteParamById(Integer id);

	void deleteAllParams();

	List<ParamConfiguration> findAllParams();

	boolean isParamExist(ParamConfiguration param);

	ParamConfiguration findByKey(String key);

	void save(ParamConfiguration param);
}
