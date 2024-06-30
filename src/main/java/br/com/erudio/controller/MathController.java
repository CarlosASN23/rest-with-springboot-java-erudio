package br.com.erudio.controller;

import java.util.concurrent.atomic.AtomicLong;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import static org.apache.tomcat.util.http.parser.HttpParser.isNumeric;

@RestController
public class MathController {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	// Método para realizações de soma
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return convertToDouble(numberOne) + convertToDouble(numberTwo);
	}

	// Método para realização de divisões
	@RequestMapping(value = "div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		} else{
			return convertToDouble(numberOne) * convertToDouble(numberTwo);
		}
	}

	// Método para realização da multiplicação
	@RequestMapping(value = "mult/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mult(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		} else if(convertToDouble(numberTwo) == 0){
			throw  new UnsupportedMathOperationException("Don't exist division per 0");
		}else{

			return convertToDouble(numberOne) / convertToDouble(numberTwo);
		}
	}

	// Método para calculo da média de 2 números
	@RequestMapping(value = "med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double med(@PathVariable(value = "numberOne") String numberOne,
					   @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}else{

			return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
		}
	}

	private boolean isNumeric(String strNumber) {

		if(strNumber == null) return false;
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	public Double convertToDouble(String strNumber){

		if(strNumber == null) return 0D;
		String number = strNumber.replaceAll(",",".");
		if(isNumeric(number))return Double.parseDouble(number);
		return 0D;
	}


}
