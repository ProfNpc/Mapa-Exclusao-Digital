package br.com.proexp.mapaexclusaodigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GraficoController {

	@GetMapping("graficos/regiao")
	public String porRegiao() {
		return "graficos/regiao";
	}
	
	@GetMapping("graficos/tipo")
	public String porProblema() {
		return "graficos/tipo";
	}
}
