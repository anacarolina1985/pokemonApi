package br.com.ana.alves.araujo.pokemon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ana.alves.araujo.pokemon.model.ParamConfiguration;
import br.com.ana.alves.araujo.pokemon.service.ParamConfigurationService;

@RestController
@RequestMapping("/api/v1/pokemon/param_config")
public class ParamConfigurationController {

	public static final Logger logger = LoggerFactory.getLogger(ParamConfigurationController.class);

	@Autowired
	private ParamConfigurationService paramConfigurationService;

	@GetMapping("/{id}")
	public ParamConfiguration findById(@PathVariable Integer id) {
		return paramConfigurationService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteParamById(@PathVariable Integer id) {
		paramConfigurationService.deleteParamById(id);
	}

	@DeleteMapping("/")
	public void deleteAllParams() {
		paramConfigurationService.deleteAllParams();
	}

	@GetMapping("/")
	public List<ParamConfiguration> findAllParams() {
		return paramConfigurationService.findAllParams();
	}

	@PostMapping("/exists")
	public boolean isParamExist(@RequestBody ParamConfiguration param) {
		return paramConfigurationService.isParamExist(param);
	}

	@PostMapping("/")
	public void save(@RequestBody ParamConfiguration param) {
		paramConfigurationService.save(param);
	}
}
