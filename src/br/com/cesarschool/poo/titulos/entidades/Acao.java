package br.com.cesarschool.poo.titulos.entidades;
import java.time.LocalDate; 
/*
 * Esta classe deve herdar de Ativo. - ok
 * E deve ter os seguintes atributos:
 * valorUnitario, do tipo double. - ok
 * 
 * Deve ter um construtor público que inicializa os atributos,  - ok
 * e métodos set/get públicos para os atributos.
 * 
 * Deve ter um método público double calcularPrecoTransacao(double montante): o preço 
 * da transação é o produto do montante pelo valorUnitario. - ok
 */
public class Acao extends Ativo {
	
    private double valorUnitario;
    
    public Acao(int identificador, String nome, LocalDate dataValidade, double valorUnitario) {
        super(identificador, nome, dataValidade); 
        this.valorUnitario = valorUnitario; 
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    public double getValorUnitario() {
        return valorUnitario;
    }
    public double calcularPrecoTransacao(double montante) {
        return montante * valorUnitario;
    }
}
