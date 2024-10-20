package br.com.cesarschool.telas;
/*import javax.swing.*;

public class TelaPrincipal {
    private static EntidadeMediator mediator = new EntidadeMediator();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Incluir", "Alterar", "Excluir", "Buscar", "Sair"};
            int choice = JOptionPane.showOptionDialog(null, 
                "Selecione uma operação:", 
                "Menu Principal", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                options, 
                options[0]);

            switch (choice) {
                case 0: 
                    incluir(); 
                    break;
                case 1: 
                    alterar(); 
                    break;
                case 2: 
                    excluir(); 
                    break;
                case 3: 
                    buscar(); 
                    break;
                case 4: 
                    System.exit(0);
                default: 
                    break;
            }
        }
    }

    private static void incluir() {
        String codigo = JOptionPane.showInputDialog("Digite o código:");
        String nome = JOptionPane.showInputDialog("Digite o nome:");
        double renda = Double.parseDouble(JOptionPane.showInputDialog("Digite a renda:"));
        Entidade entidade = new Entidade(codigo, nome, renda);
        String msg = mediator.incluir(entidade);
        JOptionPane.showMessageDialog(null, msg);
    }

    private static void alterar() {
        String codigo = JOptionPane.showInputDialog("Digite o código da entidade a ser alterada:");
        Entidade entidade = mediator.buscar(codigo);
        if (entidade != null) {
            String novoNome = JOptionPane.showInputDialog("Digite o novo nome:", entidade.getNome());
            double novaRenda = Double.parseDouble(JOptionPane.showInputDialog("Digite a nova renda:", entidade.getRenda()));
            entidade.setNome(novoNome);
            entidade.setRenda(novaRenda);
            String msg = mediator.alterar(entidade);
            JOptionPane.showMessageDialog(null, msg);
        } else {
            JOptionPane.showMessageDialog(null, "Entidade não encontrada.");
        }
    }

    private static void excluir() {
        String codigo = JOptionPane.showInputDialog("Digite o código da entidade a ser excluída:");
        String msg = mediator.excluir(codigo);
        JOptionPane.showMessageDialog(null, msg);
    }

    private static void buscar() {
        String codigo = JOptionPane.showInputDialog("Digite o código da entidade a ser buscada:");
        Entidade entidade = mediator.buscar(codigo);
        if (entidade != null) {
            JOptionPane.showMessageDialog(null, "Código: " + entidade.getCodigo() + "\nNome: " + entidade.getNome() + "\nRenda: " + entidade.getRenda());
        } else {
            JOptionPane.showMessageDialog(null, "Entidade não encontrada.");
        }
    }
}*/