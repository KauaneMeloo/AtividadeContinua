
package br.com.cesarschool.poo.titulos.mediators;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import br.com.cesarschool.poo.titulos.repositorios.RepositorioEntidadeOperadora;

public class MediatorEntidadeOperadora {
    private static final MediatorEntidadeOperadora INSTANCE = new MediatorEntidadeOperadora();
    private final RepositorioEntidadeOperadora repositorioEntidadeOperadora = new RepositorioEntidadeOperadora();

    private MediatorEntidadeOperadora() {
    }

    public static MediatorEntidadeOperadora getInstance() {
        return INSTANCE;
    }

    private String validar(EntidadeOperadora entidade) {
        if (entidade.getIdentificador() <= 0 || entidade.getIdentificador() >= 1000000) {
            return "Identificador deve estar entre 1 e 999999.";
        }
        if (entidade.getNome() == null || entidade.getNome().isBlank()) {
            return "Nome deve ser preenchido.";
        }
        if (entidade.getNome().length() < 5 || entidade.getNome().length() > 60) {
            return "Nome deve ter entre 5 e 60 caracteres.";
        }
        // Remover o acesso a dataValidade e valorUnitario, pois não existem na classe
        // if (entidade.getDataValidade().isBefore(LocalDate.now().plusDays(180))) {
        //     return "Data de validade deve ser maior do que a data atual mais 180 dias.";
        // }
        // if (entidade.getValorUnitario() <= 0) {
        //     return "Valor unitário deve ser maior que zero.";
        // }
        return null;
    }

    public String incluir(EntidadeOperadora entidade) {
        String mensagemValidacao = validar(entidade);
        if (mensagemValidacao != null) {
            return mensagemValidacao;
        }
        boolean incluido = repositorioEntidadeOperadora.incluir(entidade);
        return incluido ? null : "Entidade já existente";
    }

    public String alterar(EntidadeOperadora entidade) {
        String mensagemValidacao = validar(entidade);
        if (mensagemValidacao != null) {
            return mensagemValidacao;
        }
        boolean alterado = repositorioEntidadeOperadora.alterar(entidade);
        return alterado ? null : "Entidade inexistente";
    }

    public String excluir(long identificador) {
        if (identificador <= 0 || identificador >= 1000000) {
            return "Identificador deve estar entre 1 e 999999.";
        }
        boolean excluido = repositorioEntidadeOperadora.excluir(identificador);
        return excluido ? null : "Entidade inexistente";
    }

    public EntidadeOperadora buscar(long identificador) {
        if (identificador <= 0 || identificador >= 1000000) {
            return null;
        }
        return repositorioEntidadeOperadora.buscar(identificador);
    } 
}