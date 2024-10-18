package br.com.cesarschool.poo.titulos.entidades;
import java.time.LocalDateTime;

/*
 * Esta classe deve ter os seguintes atributos: - OK
 * entidadeCredito, do tipo EntidadeOperadora
 * entidadeDebito, do tipo EntidadeOperadora
 * acao, do tipo Acao
 * tituloDivida, do tipo TituloDivida
 * valorOperacao, do tipo double
 * dataHoraOperacao, do tipo LocalDateTime
 *  
 * Deve ter um construtor público que inicializa os atributos. - OK
 * Deve ter métodos get/set públicos para todos os atributos, que
 * são read-only fora da classe.
 *
 *
 */

 public class Transacao {
    private EntidadeOperadora entidadeCredito;
    private EntidadeOperadora entidadeDebito;
    private Acao acao;
    private TituloDivida tituloDivida;
    private double valorOperacao;
    private LocalDateTime dataHoraOperacao;

    public Transacao(EntidadeOperadora entidadeCredito, EntidadeOperadora entidadeDebito, 
                    Acao acao, TituloDivida tituloDivida, double valorOperacao, 
                    LocalDateTime dataHoraOperacao) {
        if (entidadeCredito == null || entidadeDebito == null) {
            throw new IllegalArgumentException("crédito e débito não podem ser nulas.");
        }
        this.entidadeCredito = entidadeCredito;
        this.entidadeDebito = entidadeDebito;
        this.acao = acao;
        this.tituloDivida = tituloDivida;
        this.valorOperacao = valorOperacao;
        this.dataHoraOperacao = dataHoraOperacao;
    }

    public EntidadeOperadora getEntidadeCredito() {
        return entidadeCredito;
    }

    public EntidadeOperadora getEntidadeDebito() {
        return entidadeDebito;
    }

    public Acao getAcao() {
        return acao;
    }

    public TituloDivida getTituloDivida() {
        return tituloDivida;
    }

    public double getValorOperacao() {
        return valorOperacao;
    }

    public LocalDateTime getDataHoraOperacao() {
        return dataHoraOperacao;
    }


    private void setEntidadeCredito(EntidadeOperadora entidadeCredito) {
        this.entidadeCredito = entidadeCredito;
    }

    private void setEntidadeDebito(EntidadeOperadora entidadeDebito) {
        this.entidadeDebito = entidadeDebito;
    }

    private void setAcao(Acao acao) {
        this.acao = acao;
    }

    private void setTituloDivida(TituloDivida tituloDivida) {
        this.tituloDivida = tituloDivida;
    }

    private void setValorOperacao(double valorOperacao) {
        this.valorOperacao = valorOperacao;
    }

    private void setDataHoraOperacao(LocalDateTime dataHoraOperacao) {
        this.dataHoraOperacao = dataHoraOperacao;
    }
    
}