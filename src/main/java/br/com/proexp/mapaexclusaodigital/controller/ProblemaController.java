package br.com.proexp.mapaexclusaodigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("problema")
public class ProblemaController {

	@PostMapping("/mais-detalhes")
	public String maisDetalhes(@RequestParam("problemaList") String problemaList ) {
		return "problema/mais-detalhes";
	}
}
