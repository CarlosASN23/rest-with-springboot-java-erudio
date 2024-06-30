package br.com.erudio.service;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public Double divisao(String numberOne, String numberTwo){
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }else if(convertToDouble(numberTwo)== 0){
            throw new UnsupportedMathOperationException("Don't exist division per 0");
        }
        else{
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        }
    }

    public Double soma(String numberOne, String numberTwo) {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        else{
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
        }
    }

    public Double multiplicacao(String numberOne, String numberTwo) {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        else{
            return convertToDouble(numberOne) * convertToDouble(numberTwo);
        }
    }

    public Double media(String numberOne, String numberTwo) {

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        else{
            return (convertToDouble(numberOne) + convertToDouble(numberTwo))/2;
        }
    }

    public Double raiz(String number) {

        if(!isNumeric(number)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        else{
            return Math.sqrt(convertToDouble(number));
        }
    }


    public static Double convertToDouble(String strNumber){

        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isNumeric(number))return Double.valueOf((number));
        return 0D;
    }
    private static boolean isNumeric(String strNumber) {

        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }


}
