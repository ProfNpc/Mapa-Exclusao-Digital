package br.com.proexp.mapaexclusaodigital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("questionario")
public class QuestionarioController {

	@GetMapping("/{id}")
	public String mostar(@PathVariable("id") int id) {
		return "questionario/pergunta";
	}

	@PostMapping("/{id}/resposta")
	public String resposta(@PathVariable("id") int id,
			@RequestParam(value = "faltaRecurso", required = false) String faltaRecursoStr,
			@RequestParam(value = "faltaEstrutura", required = false) String faltaEstruturaStr,
			@RequestParam(value = "faltaConhecimento", required = false) String faltaConhecimentoStr) {

		boolean faltaRecurso = getCheckBoxValue(faltaRecursoStr);
		if (faltaRecurso) {
			// buscar problemas do tipo recurso
		}

		boolean faltaEstrutura = getCheckBoxValue(faltaEstruturaStr);
		if (faltaEstrutura) {
			// buscar problemas do tipo estrutura
		}
		
		boolean faltaConhecimento = getCheckBoxValue(faltaConhecimentoStr);
		if (faltaConhecimento) {
			// buscar problemas do tipo conhecimento
		}

		return "problema/list";
	}

	private boolean getCheckBoxValue(String checkboxValueStr) {
		return (checkboxValueStr != null);
	}

}
