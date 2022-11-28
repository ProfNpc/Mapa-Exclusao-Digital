package br.com.proexp.mapaexclusaodigital.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.proexp.mapaexclusaodigital.model.TipoProblema;
import br.com.proexp.mapaexclusaodigital.model.TipoProblema.NaturezaProblema;

public interface TipoProblemaRepository extends CrudRepository<TipoProblema, Integer>{

	  List<TipoProblema> findByNaturezaIn(List<NaturezaProblema> naturezas);
	
}
