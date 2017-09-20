package br.com.ana.alves.araujo.pokemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ana.alves.araujo.pokemon.model.ParamConfiguration;
import br.com.ana.alves.araujo.pokemon.repository.ParamConfigurationRespository;;

@Component
public class ParamConfigurationServiceImpl implements ParamConfigurationService {

	@Autowired
	private ParamConfigurationRespository paramConfigurationReposity;

	@Override
	public ParamConfiguration findById(Integer id) {
		return paramConfigurationReposity.findOne(id);
	}

	@Override
	public void deleteParamById(Integer id) {
		paramConfigurationReposity.delete(id);
	}

	@Override
	public void deleteAllParams() {
		paramConfigurationReposity.deleteAll();
	}

	@Override
	public List<ParamConfiguration> findAllParams() {
		return paramConfigurationReposity.findAll();
	}

	@Override
	public boolean isParamExist(ParamConfiguration param) {
		return paramConfigurationReposity.findByKey(param.getKey()) != null;
	}

	@Override
	public void save(ParamConfiguration param) {
		paramConfigurationReposity.save(param);
	}

	@Override
	public ParamConfiguration findByKey(String key) {
		return paramConfigurationReposity.findByKey(key);
	}
}
