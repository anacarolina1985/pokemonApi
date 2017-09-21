package br.com.ana.alves.araujo.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PokemonAppController {

	@RequestMapping("/")
	String home(ModelMap modal) {
		modal.addAttribute("title", "Pokemon");
		return "index";
	}

	@RequestMapping("/team")
	String team(ModelMap modal) {
		modal.addAttribute("title", "Team Pokemon");
		return "index";
	}

	@RequestMapping("/login")
	String login(ModelMap modal) {
		modal.addAttribute("title", "Login Pokemon");
		return "index";
	}

	@RequestMapping("/loginCreate")
	String loginCreate(ModelMap modal) {
		modal.addAttribute("title", "Login Create Pokemon");
		return "index";
	}
	
	@RequestMapping("/team/{id}")
	String teamDetail(ModelMap modal) {
		modal.addAttribute("title", "Team Detail Pokemon");
		return "index";
	}

	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}
}
