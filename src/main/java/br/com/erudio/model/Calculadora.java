package br.com.erudio.model;

public class Calculadora {

    private Double numero01;
    private Double numero02;

    // Construtor sem passagem de parâmetros
    public Calculadora() {
    }

    // Construtor com passagem de parâmetros
    public Calculadora(Double numero01, Double numero02) {
        this.numero01 = numero01;
        this.numero02 = numero02;
    }

    // Criação dos Getters & Setters
    public Double getNumero01() {
        return numero01;
    }

    public void setNumero01(Double numero01) {
        this.numero01 = numero01;
    }

    public Double getNumero02() {
        return numero02;
    }

    public void setNumero02(Double numero02) {
        this.numero02 = numero02;
    }
}
