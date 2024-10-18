package br.com.cesarschool.poo.titulos.entidades;
import java.time.LocalDate; 
/*
 * Esta classe deve ter os seguintes atributos:
 * identificador, do tipo int - ok
 * nome, do tipo String - ok
 * data de validade, do tipo LocalDate(um impot local e data) - ok
 * 
 * Deve ter um construtor público que inicializa os atributos, 
 * e métodos set/get públicos para os atributos. - ok
 * O atributo identificador é read-only fora da classe.
 */
public class Ativo {
	
	private int identificador;
	private String nome;
	private LocalDate dataValidade;
	
	public Ativo(int identificador,String nome, LocalDate dataValidade) {
		this.identificador = identificador;
		this.nome = nome;
		this.dataValidade = dataValidade;
	}
	public int getIdentificador() {
		return identificador;
	}
	public void setNome(String nome) {
		if (nome == null || nome.isEmpty()) {
			throw new IllegalArgumentException("nome vazio.");
		}
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setDataValidade (LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}
	public LocalDate getDataValidade() {
		return dataValidade;
	}
}