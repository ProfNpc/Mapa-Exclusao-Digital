package br.com.proexp.mapaexclusaodigital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class MapaexclusaodigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapaexclusaodigitalApplication.class, args);
	}

	@GetMapping("onAir")
	public String onAir() {
		return "No AR!";
	}
}
