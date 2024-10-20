package br.com.cesarschool.poo.titulos.mediators;
//100% OK

import java.time.LocalDate;
import br.com.cesarschool.poo.titulos.entidades.Acao;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioAcao;
/*
 * Deve ser um singleton. - OK
 * 
 * Deve ter um atributo repositorioAcao, do tipo RepositorioAcao, que deve - OK
 * ser inicializado na sua declaração. Este atributo será usado exclusivamente
 * pela classe, não tendo, portanto, métodos set e get.
 * 
 * Métodos: 
 * 
 * pivate String validar(Acao acao): deve validar os dados do objeto recebido nos seguintes termos:  - OK 
 * identificador: deve ser maior que zero e menor que 100000 (1)- OK
 * nome: deve ser preenchido, diferente de branco e de null (2). deve ter entre 10 e 100 caracteres (3). - OK
 * data de validade: deve ser maior do que a data atual mais 30 dias (4). - OK
 * valorUnitario: deve ser maior que zero (5). - OK
 * O método validar deve retornar null se o objeto estiver válido, e uma mensagem pertinente (ver abaixo) - OK
 * se algum valor de atributo estiver inválido. - OK
 * 
 * (1) - Identificador deve estar entre 1 e 99999. - OK
 * (2) - Nome deve ser preenchido.- OK
 * (3) - Nome deve ter entre 10 e 100 caracteres. - OK
 * (4) - Data de validade deve ter pelo menos 30 dias na frente da data atual. - OK
 * (5) - Valor unitário deve ser maior que zero. - OK
 *
 * public String incluir(Acao acao): deve chamar o método validar. Se ele retornar null, deve incluir acao no repositório. Retornos possíveis: - OK 
 * (1) null, se o retorno do validar for null e o retorno do incluir do repositório for true. - OK
 * (2) a mensagem retornada pelo validar, se o retorno deste for diferente
 * de null. - OK
 * (3) A mensagem "Ação já existente", se o retorno do validar for null
 * e o retorno do repositório for false. - OK
 *
 * public String alterar(Acao acao): deve chamar o método validar. Se ele retornar null, deve alterar acao no repositório. Retornos possíveis: - OK
 * (1) null, se o retorno do validar for null e o retorno do alterar do repositório for true. - OK
 * (2) a mensagem retornada pelo validar, se o retorno deste for diferente de null. - OK
 * (3) A mensagem "Ação inexistente", se o retorno do validar for null e o retorno do repositório for false.- OK
 * 
 * public String excluir(int identificador): deve validar o identificador. - OK 
 * Se este for válido, deve chamar o excluir do repositório. Retornos possíveis:
 * (1) null, se o retorno do excluir do repositório for true. - OK
 * (2) A mensagem "Ação inexistente", se o retorno do repositório for false ou se o identificador for inválido. - OK
 * 
 * public Acao buscar(int identificador): deve validar o identificador. - OK
 * Se este for válido, deve chamar o buscar do repositório, retornando o que ele retornar. Se o identificador for inválido, retornar null. - OK
 */

public class MediatorAcao {

    private static final MediatorAcao INSTANCE = new MediatorAcao();
    private final RepositorioAcao repositorioAcao = new RepositorioAcao();
    private MediatorAcao() {
    }
    public static MediatorAcao getInstance() {
        return INSTANCE;
    }
    private String validar(Acao acao) {
        if (acao.getIdentificador() <= 0 || acao.getIdentificador() >= 100000) {
            return "Identificador deve estar entre 1 e 99999.";
        }
        if (acao.getNome() == null || acao.getNome().isBlank()) {
            return "Nome deve ser preenchido.";
        }
        if (acao.getNome().length() < 10 || acao.getNome().length() > 100) {
            return "Nome deve ter entre 10 e 100 caracteres.";
        }
        if (acao.getDataValidade().isBefore(LocalDate.now().plusDays(30))) {
            return "Data de validade deve ter pelo menos 30 dias na frente da data atual.";
        }
        if (acao.getValorUnitario() <= 0) {
            return "Valor unitário deve ser maior que zero.";
        }
        return null;
    }

    public String incluir(Acao acao) {
        String mensagemValidacao = validar(acao);
        if (mensagemValidacao != null) {
            return mensagemValidacao;
        }
        boolean incluido = repositorioAcao.incluir(acao);
        return incluido ? null : "Ação já existente";
    }

    public String alterar(Acao acao) {
        String mensagemValidacao = validar(acao);
        if (mensagemValidacao != null) {
            return mensagemValidacao;
        }
        boolean alterado = repositorioAcao.alterar(acao);
        return alterado ? null : "Ação inexistente";
    }

    public String excluir(int identificador) {
        if (identificador <= 0 || identificador >= 100000) {
            return "Identificador deve estar entre 1 e 99999.";
        }
        boolean excluido = repositorioAcao.excluir(identificador);
        return excluido ? null : "Ação inexistente";
    }

    public Acao buscar(int identificador) {
        if (identificador <= 0 || identificador >= 100000) {
            return null;
        }
        return repositorioAcao.buscar(identificador);
    }
}
