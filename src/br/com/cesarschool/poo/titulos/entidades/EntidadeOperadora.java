package br.com.cesarschool.poo.titulos.entidades;
/*
 * Esta classe deve ter os seguintes atributos: - OK
 * identificador, do tipo long
 * nome, do tipo String
 * autorizadoAcao, do tipo double
 * saldoAcao, do tipo double
 * saldoTituloDivida, do tipo double
 * 
 * Deve ter um construtor público que inicializa os atributos identificador, nome - OK
 * e autorizadoAcao. Deve ter métodos set/get públicos para os atributos identificador, nome
 * e autorizadoAcao. 
 * 
 * O atributo identificador é read-only fora da classe.
 * 
 * Os atributos saldoAcao e saldoTituloDivida devem ter apenas métodos get públicos. - OK
 * 
 * Outros métodos públicos: - OK
 *  void creditarSaldoAcao(double valor): deve adicionar valor ao saldoAcao
 *  void debitarSaldoAcao(double valor): deve diminuir valor de saldoAcao
 *  void creditarSaldoTituloDivida(double valor): deve adicionar valor ao saldoTituloDivida
 *  void debitarSaldoTituloDivida(double valor): deve diminuir valor de saldoTituloDivida  
 */

import java.time.LocalDate;

public class EntidadeOperadora {
    private long identificador;
    private String nome;
    private double autorizadoAcao;
    private double saldoAcao;
    private double saldoTituloDivida;
    private LocalDate dataValidade;
    private double valorUnitario;

    public EntidadeOperadora(long identificador, String nome, double autorizadoAcao, LocalDate dataValidade, double valorUnitario) {
        this.identificador = identificador;
        this.nome = nome;
        this.autorizadoAcao = autorizadoAcao;
        this.saldoAcao = 0;
        this.saldoTituloDivida = 0;
        this.dataValidade = dataValidade;   //
        this.valorUnitario = valorUnitario; //
    }

    //tem que ser read only
    //public void setIdentificador(long identificador){
    //    this.identificador = identificador;
    //}
    public long getIdentificador(){
        return this.identificador;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }

    public void setAutorizadoAcao(double autorizadoAcao){
        this.autorizadoAcao = autorizadoAcao;
    }
    public double getAutorizadoAcao(){
        return autorizadoAcao;
    }

    public double getSaldoAcao(){
        return this.saldoAcao;
    }

    public double getSaldoTituloDivida(){
        return this.saldoTituloDivida;
    }

    public void creditarSaldoAcao(double valor){
        this.saldoAcao += valor;
    }

    public void debitarSaldoAcao(double valor){
        this.saldoAcao -= valor;
    }

    public void creditarSaldoTituloDivida(double valor){
        this.saldoTituloDivida += valor;
    }

    public void debitarSaldoTituloDivida(double valor){
        this.saldoTituloDivida -= valor;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    @Override
    public String toString() {
        return "EntidadeOperadora [identificador=" + identificador + ", nome=" + nome + 
               ", autorizadoAcao=" + autorizadoAcao + ", saldoAcao=" + saldoAcao + 
               ", saldoTituloDivida=" + saldoTituloDivida + ", dataValidade=" + dataValidade + ", valorUnitario=" + valorUnitario + "]";
    }
}