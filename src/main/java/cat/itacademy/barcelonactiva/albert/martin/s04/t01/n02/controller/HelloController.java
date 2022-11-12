package cat.itacademy.barcelonactiva.albert.martin.s04.t01.n02.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/HelloWorld")
	public String saludo(@RequestParam (value = "nom", defaultValue = "UNKNOWN") String nom) {
		return "Hola " + nom + ". Estàs executant un projecte Gradle.";
	}
		
	@GetMapping(value = {"/HelloWorld2", "/HelloWorld2/{nom}"})
	public String saludo2(@PathVariable(value = "nom")Optional <String> nom) {
		if (nom.isPresent()) {
			return "Hola " + nom + ". Estàs executant un projecte Gradle.";	
		} else {
			return "Hola UNKNOWN. Estàs executant un projecte Gradle.";
		}
	}
	
	@GetMapping(value = {"/HelloWorld3", "/HelloWorld3/{nom}"})
	public String saludo3(@PathVariable(required = false) String nom) {
	    if (nom == null) {
	    	return "Hola UNKNOWN. Estàs executant un projecte Gradle.";
	    } else {
	    	return "Hola " + nom + ". Estàs executant un projecte Gradle.";
	    }
	}

}
