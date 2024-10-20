package br.com.cesarschool.poo.titulos.entidades;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException; 
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

    public Acao(int identificador, String nome, String dataValidadeStr, double valorUnitario) {
        super(identificador, nome, converterStringParaLocalDate(dataValidadeStr)); 
        this.valorUnitario = valorUnitario; 
    }

    private static LocalDate converterStringParaLocalDate(String dataValidadeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Formato de data esperado
        try {
            return LocalDate.parse(dataValidadeStr, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Data de validade inválida: " + dataValidadeStr);
        }
    }

    public void setValorUnitario(double valorUnitario) {
        if (valorUnitario < 0) {
            throw new IllegalArgumentException("O valor unitário só pode ser positivo.");
        }
        this.valorUnitario = valorUnitario;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public double calcularPrecoTransacao(double montante) {
        return montante * valorUnitario;
    }
}
