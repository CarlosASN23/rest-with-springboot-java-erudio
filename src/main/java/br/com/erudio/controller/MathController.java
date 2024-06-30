package br.com.erudio.controller;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@Autowired
	private CalculadoraService service;

	// Método para realizações de soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) {
		return service.soma(numberOne, numberTwo);
	}

	// Método para realização de divisões
	@RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable String numberOne, @PathVariable String numberTwo){
		return service.divisao(numberOne, numberTwo);
	}

	// Método para realização da multiplicação
	@RequestMapping(value = "mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable String numberOne, @PathVariable String numberTwo) {
		return service.multiplicacao(numberOne, numberTwo);
	}

	// Método para calculo da média de 2 números
	@RequestMapping(value = "med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable String numberOne, @PathVariable String numberTwo){

		return service.media(numberOne, numberTwo);
	}

	// Método para calculo da raiz quadrada de um número
	@RequestMapping(value = "raiz/{number}", method = RequestMethod.GET)
	public Double med(@PathVariable String number){
		return service.raiz(number);
	}

}
