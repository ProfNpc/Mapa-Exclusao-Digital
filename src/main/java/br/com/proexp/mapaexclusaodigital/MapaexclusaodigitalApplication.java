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
	    	
//	    	repository.deleteAll();
//	    	
//			repository.save(new TipoProblema(0, NaturezaProblema.Outro, "Outro", "Outro"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Recurso, "Não tenho computador", "Não tenho computador"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Recurso, "Preciso de um computador mais rápido", "Preciso de um computador mais rápido"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Recurso, "Preciso de um computador com mais memória", "Preciso de um computador com mais memória"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Estrutura, "Não tenho acesso à internet", "Não tenho acesso à internet"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Estrutura, "Preciso de internet banda larga", "Preciso de internet banda larga"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Conhecimento, "Preciso usar um programa mas não sei como fazê-lo", "Preciso usar um programa mas não sei como fazê-lo"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Conhecimento, "Minha impressora estava funcionando mas agora parou de funcionar", "Minha impressora estava funcionando mas agora parou de funcionar"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Conhecimento, "Como faço para enviar um e-mail?", "Como faço para enviar um e-mail?"));
//			repository.save(new TipoProblema(0, NaturezaProblema.Conhecimento, "Como faço para pagar um boleto pelo aplicativo do meu banco?","Como faço para pagar um boleto pelo aplicativo do meu banco?"));
		       
	        List<NaturezaProblema> naturezas = new ArrayList<NaturezaProblema>();
	        naturezas.add(NaturezaProblema.Outro);
	        naturezas.add(NaturezaProblema.Recurso);
	        naturezas.add(NaturezaProblema.Estrutura);
	        naturezas.add(NaturezaProblema.Conhecimento);
	        
	        List<TipoProblema> problemas = repository.findByNaturezaIn(naturezas);
	        
	        for(TipoProblema p : problemas) {
	        	logger.info(p.toString());
	        }
	    	
	    };
	}
}
