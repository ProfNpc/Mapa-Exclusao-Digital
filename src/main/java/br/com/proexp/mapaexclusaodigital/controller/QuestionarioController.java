package br.com.proexp.mapaexclusaodigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("questionario")
public class QuestionarioController {

	@GetMapping("/{id}")
	public String mostar(@PathVariable("id") int id) {
		return "questionario/pergunta";
	}
}
