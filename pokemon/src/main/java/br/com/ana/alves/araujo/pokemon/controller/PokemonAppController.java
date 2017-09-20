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
		return "login";
	}
	
	@RequestMapping("/createlogin")
	String createLogin(ModelMap modal) {
		modal.addAttribute("title", "Pokemon Create Login");
		return "createlogin";
	}
	
	@RequestMapping("/createteam")
	String createTeam(ModelMap modal) {
		modal.addAttribute("title", "Pokemon Create Team");
		return "team";
	}
	
	@RequestMapping("/detailteam")
	String detailTeam(ModelMap modal) {
		modal.addAttribute("title", "Pokemon Detail Team");
		return "detailteam";
	}
	
	@RequestMapping("/partials/{page}")
	String partialHandler(@PathVariable("page") final String page) {
		return page;
	}
}
