package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.Acao;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*
 * Deve gravar(ok) em e ler(ok) de um arquivo texto chamado Acao.txt os dados dos objetos do tipo
 * Acao. Seguem abaixo exemplos de linhas (identificador, nome, dataValidade, valorUnitario)
 * 
    1;PETROBRAS;2024-12-12;30.33
    2;BANCO DO BRASIL;2026-01-01;21.21
    3;CORREIOS;2027-11-11;6.12 
 * 
 * A inclusão deve adicionar uma nova linha ao arquivo.(ok) 
 * Não é permitido incluir 
 * identificador repetido. 
 * Neste caso, o método deve retornar false. Inclusão com 
 * sucesso, retorno true.
 * 
 * A alteração deve substituir a linha atual por uma nova linha. A linha deve ser 
 * localizada por identificador que, quando não encontrado, enseja retorno false. 
 * Alteração com sucesso, retorno true.  
 *   
 * A exclusão deve apagar a linha atual do arquivo. A linha deve ser 
 * localizada por identificador que, quando não encontrado, enseja retorno false. 
 * Exclusão com sucesso, retorno true.
 * 
 * A busca deve localizar uma linha por identificador, materializar e retornar um 
 * objeto. Caso o identificador não seja encontrado no arquivo, retornar null.   
 */
public class RepositorioAcao {

    private static final String FILE_NAME = "Acao.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public boolean incluir(Acao acao) {
        if (buscar(acao.getIdentificador()) != null) {
            return false; // se já tem
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(acao.getIdentificador() + ";" 
            + acao.getNome() + ";" 
            + acao.getDataValidade().format(DATE_TIME_FORMATTER) + ";" + acao.getValorUnitario());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // aterar
    public boolean alterar(Acao acao) {
        List<Acao> acoes = lerTodas();
        boolean encontrado = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Acao a : acoes) {
                if (a.getIdentificador() == acao.getIdentificador()) {
                    writer.write(acao.getIdentificador() + ";" + acao.getNome() + ";" + acao.getDataValidade() + ";" + acao.getValorUnitario());
                    encontrado = true;
                } else {
                    writer.write(a.getIdentificador() + ";" + a.getNome() + ";" + a.getDataValidade() + ";" + a.getValorUnitario());
                }
                writer.newLine();
            }
            return encontrado;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para excluir uma Ação pelo identificador
    public boolean excluir(int identificador) {
        List<Acao> acoes = lerTodas();
        boolean encontrado = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Acao a : acoes) {
                if (a.getIdentificador() != identificador) {
                    writer.write(a.getIdentificador() + ";" + a.getNome() + ";" + a.getDataValidade() + ";" + a.getValorUnitario());
                    writer.newLine();
                } else {
                    encontrado = true;
                }
            }
            return encontrado;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para buscar uma Ação pelo identificador
    public Acao buscar(int identificador) {
        List<Acao> acoes = lerTodas();
        for (Acao a : acoes) {
            if (a.getIdentificador() == identificador) {
                return a;
            }
        }
        return null;
    }

    private List<Acao> lerTodas() {
        List<Acao> acoes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int identificador = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String dataValidade = partes[2];
                double valorUnitario = Double.parseDouble(partes[3]);
                Acao acao = new Acao(identificador, nome, dataValidade, valorUnitario);
                acoes.add(acao);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return acoes;
    }
}
