package br.com.proexp.mapaexclusaodigital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.proexp.mapaexclusaodigital.model.TipoProblema;
import br.com.proexp.mapaexclusaodigital.model.TipoProblema.NaturezaProblema;
import br.com.proexp.mapaexclusaodigital.repository.TipoProblemaRepository;

@Controller
@RequestMapping("questionario")
public class QuestionarioController {

	@Autowired
	private TipoProblemaRepository repository;

	@GetMapping("/{id}")
	public String mostar(@PathVariable("id") int id) {
		return "questionario/pergunta";
	}

	@PostMapping("/{id}/resposta")
	public String resposta(
			Model model,
			@PathVariable("id") int id,
			@RequestParam(value = "faltaRecurso", required = false) String faltaRecursoStr,
			@RequestParam(value = "faltaEstrutura", required = false) String faltaEstruturaStr,
			@RequestParam(value = "faltaConhecimento", required = false) String faltaConhecimentoStr) {

        List<NaturezaProblema> naturezas = new ArrayList<NaturezaProblema>();
        naturezas.add(NaturezaProblema.Outro);
        
		boolean faltaRecurso = getCheckBoxValue(faltaRecursoStr);
		if (faltaRecurso) {
			// buscar problemas do tipo recurso
			naturezas.add(NaturezaProblema.Recurso);
		}

		boolean faltaEstrutura = getCheckBoxValue(faltaEstruturaStr);
		if (faltaEstrutura) {
			// buscar problemas do tipo estrutura
			naturezas.add(NaturezaProblema.Estrutura);
		}
		
		boolean faltaConhecimento = getCheckBoxValue(faltaConhecimentoStr);
		if (faltaConhecimento) {
			// buscar problemas do tipo conhecimento
			naturezas.add(NaturezaProblema.Conhecimento);
		}

		List<TipoProblema> problemas = repository.findByNaturezaIn(naturezas);
		
		model.addAttribute("problemas", problemas);
		
		return "problema/list";
	}

	private boolean getCheckBoxValue(String checkboxValueStr) {
		return (checkboxValueStr != null);
	}

}
