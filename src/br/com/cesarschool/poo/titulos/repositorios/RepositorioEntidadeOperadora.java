package br.com.cesarschool.poo.titulos.repositorios;

import br.com.cesarschool.poo.titulos.entidades.EntidadeOperadora;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
 * Deve gravar em e ler de um arquivo texto chamado Acao.txt os dados dos objetos do tipo
 * Acao. Seguem abaixo exemplos de linhas.
 *
    1;PETROBRAS;2024-12-12;30.33
    2;BANCO DO BRASIL;2026-01-01;21.21
    3;CORREIOS;2027-11-11;6.12 
 * 
 * A inclusão deve adicionar uma nova linha ao arquivo. Não é permitido incluir 
 * identificador repetido. Neste caso, o método deve retornar false. Inclusão com 
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
public class RepositorioEntidadeOperadora {
   private static final String FILE_NAME = "EntidadeOperadora.txt";

   public boolean incluir(EntidadeOperadora entidade) {
       if (buscar(entidade.getIdentificador()) != null) {
           return false; 
       }
       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
           writer.write(entidade.getIdentificador() + ";" + entidade.getNome() + ";" + entidade.getAutorizadoAcao() + ";" + entidade.getSaldoAcao() + ";" + entidade.getTituloDivida());
           writer.newLine();
           return true; 
       } catch (IOException e) {
           e.printStackTrace();
           return false; 
       }
   }

   public boolean alterar(EntidadeOperadora entidade) {
       List<EntidadeOperadora> entidades = listarEntidades();
       boolean encontrado = false;

       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
           for (EntidadeOperadora e : entidades) {
               if (e.getIdentificador() == entidade.getIdentificador()) {
                   writer.write(entidade.getIdentificador() + ";" + entidade.getNome() + ";" + entidade.getAutorizadoAcao() + ";" + entidade.getSaldoAcao() + ";" + entidade.getTituloDivida());
                   writer.newLine();
                   encontrado = true;
               } else {
                   writer.write(e.getIdentificador() + ";" + e.getNome() + ";" + e.getAutorizadoAcao() + ";" + e.getSaldoAcao() + ";" + e.getTituloDivida());
                   writer.newLine();
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
           return false;
       }
       return encontrado; // Retorna true se alterado, false se não encontrado
   }

   public boolean excluir(long identificador) {
       List<EntidadeOperadora> entidades = listarEntidades();
       boolean encontrado = false;

       try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
           for (EntidadeOperadora e : entidades) {
               if (e.getIdentificador() == identificador) {
                   encontrado = true; //excluir
               } else {
                   writer.write(e.getIdentificador() + ";" + e.getNome() + ";" + e.getAutorizadoAcao() + ";" + e.getSaldoAcao() + ";" + e.getTituloDivida());
                   writer.newLine();
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
           return false; 
       }
       return encontrado;
   }

   public EntidadeOperadora buscar(long identificador) {
       List<EntidadeOperadora> entidades = listarEntidades();
       for (EntidadeOperadora e : entidades) {
           if (e.getIdentificador() == identificador) {
               return e; 
           }
       }
       return null;
   }

   private List<EntidadeOperadora> listarEntidades() {
       List<EntidadeOperadora> entidades = new ArrayList<>();
       try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
           String linha;
           while ((linha = reader.readLine()) != null) {
               String[] dados = linha.split(";");
               if (dados.length >= 5) {
                   long id = Long.parseLong(dados[0]);
                   String nome = dados[1];
                   double autorizadoAcao = Double.parseDouble(dados[2]);
                   double saldoAcao = Double.parseDouble(dados[3]);
                   double saldoTituloDivida = Double.parseDouble(dados[4]);
                   EntidadeOperadora entidade = new EntidadeOperadora(id, nome, autorizadoAcao);
                   entidade.creditarSaldoAcao(saldoAcao);
                   entidade.creditarSaldoTituloDivida(saldoTituloDivida);
                   entidades.add(entidade);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return entidades;
   }
}