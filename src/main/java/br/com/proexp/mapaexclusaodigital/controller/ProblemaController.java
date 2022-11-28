package br.com.proexp.mapaexclusaodigital.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.proexp.mapaexclusaodigital.model.TipoProblema;
import br.com.proexp.mapaexclusaodigital.repository.TipoProblemaRepository;

@Controller
@RequestMapping("problema")
public class ProblemaController {

	@Autowired
	private TipoProblemaRepository repository;
	
	@PostMapping("/add")
	public String add(
			Model model,
			@RequestParam("tipoProblemaList") String tipoProblemaListStr ) {
		
		List<TipoProblema> tipoProblemaList = getTipoProblemaList(tipoProblemaListStr);
		
		model.addAttribute("tipos", tipoProblemaList);
		
		return "problema/add";
	}

	private List<TipoProblema> getTipoProblemaList(String tipoProblemaListStr) {
		List<TipoProblema> lista = new ArrayList<TipoProblema>();
		String[] listaCodigosTipoProblema = tipoProblemaListStr.split(",");
		for (String idTipoProblemaStr : listaCodigosTipoProblema) {
			int idTipoProblema = Integer.parseInt(idTipoProblemaStr);
			Optional<TipoProblema> tipo = repository.findById(idTipoProblema);
			if (tipo.isPresent()) {
				lista.add(tipo.get());
			}
		}
		return lista;
	}
	
}
