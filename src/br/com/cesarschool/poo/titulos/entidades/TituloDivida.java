package br.com.cesarschool.poo.titulos.entidades;

import java.time.LocalDate;

/*
 * Esta classe deve herdar de Ativo. - OK
 * E deve ter os seguintes atributos:
 * taxaJuros, do tipo double.
 * 
 * Deve ter um construtor público que inicializa os atributos, - OK
 * e métodos set/get públicos para os atributos.
 * 
 * Deve ter um método público double calcularPrecoTransacao(double montante): o preço - OK
 * da transação é montante vezes (1 - taxaJuros/100.0).
 */

public class TituloDivida extends Ativo{
    private double taxaJuros;

    public TituloDivida(int identificador, String nome, LocalDate dataValidade, double taxaJuros){
        super(identificador, nome, dataValidade);
        this.taxaJuros = taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros){
        this.taxaJuros = taxaJuros;
    }
    public double getTaxaJuros(){
        return taxaJuros;
    }

    public double calcularPrecoTransacao(double montante){
        return montante * (1 - (this.taxaJuros/100.0));
    }
    

}