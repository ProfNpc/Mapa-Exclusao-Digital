package br.com.proexp.mapaexclusaodigital;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.proexp.mapaexclusaodigital.model.TipoProblema;
import br.com.proexp.mapaexclusaodigital.model.TipoProblema.NaturezaProblema;
import br.com.proexp.mapaexclusaodigital.repository.TipoProblemaRepository;
import ch.qos.logback.classic.Logger;

@RestController
@SpringBootApplication
public class MapaexclusaodigitalApplication {
	
	Logger logger = (Logger) LoggerFactory.getLogger(MapaexclusaodigitalApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(MapaexclusaodigitalApplication.class, args);
	}

	@GetMapping("onAir")
	public String onAir() {
		return "No AR!";
	}
	
	@Bean
	public CommandLineRunner loadData(TipoProblemaRepository repository) {
	    return (args) -> {

	    	logger.info("loadData()");
	    	
	        repository.save(new TipoProblema(0, 
	        		NaturezaProblema.Outro, 
	        		"Outro", "Outro"));
	        
	        List<NaturezaProblema> naturezas = new ArrayList<NaturezaProblema>();
	        naturezas.add(NaturezaProblema.Outro);
	        
	        List<TipoProblema> problemas = repository.findByNaturezaIn(naturezas);
	        
	        for(TipoProblema p : problemas) {
	        	logger.info(p.getDescricao());
	        }
	    	
	    };
	}
}
