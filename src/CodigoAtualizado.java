import java.util.ArrayList;
import java.util.Scanner;

public class CodigoAtualizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<CadastroUsuario> todosUsuariosList = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\n");
            System.out.println("Sistema de Cadastro e Monitoramento");
            System.out.println("1 - Visualizar usuários cadastrados.");
            System.out.println("2 - Cadastrar Usuário.");
            System.out.println("3 - Buscar Usuário por nome ou número de matrícula.");
            System.out.println("4 - Sair");
            System.out.print("Selecione uma opção: ");

            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    visualizarUsuarios(todosUsuariosList);
                    break;
                case 2:
                    cadastrarUsuario(todosUsuariosList);
                    break;
                case 3:
                    buscarUsuario(todosUsuariosList);
                    break;
                case 4:
                    System.out.println("Fim do Programa!");
                    break;
                default:
                    System.out.println("Opção Inválida, Tente Novamente!");
            }
        } while (opcao != 4);
        scanner.close();
    }

    private static void visualizarUsuarios(ArrayList<CadastroUsuario> todosUsuariosList) {
        if (todosUsuariosList.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            System.out.println("Usuários cadastrados:");
            for (CadastroUsuario usuario : todosUsuariosList) {
                usuario.exibirCadastro();
            }
        }
    }

    private static void cadastrarUsuario(ArrayList<CadastroUsuario> todosUsuariosList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o seu cargo: ");
        String cargo = scanner.nextLine();

        System.out.print("Digite o número da sua matrícula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        CadastroUsuario novoUsuario = new CadastroUsuario(nome, cargo, matricula);
        todosUsuariosList.add(novoUsuario);
        System.out.println("\n" +"Usuário cadastrado com sucesso!");
    }

    private static void buscarUsuario(ArrayList<CadastroUsuario> todosUsuariosList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha a opção de consulta:");
        System.out.println("1 - Consultar pelo nome");
        System.out.println("2 - Consultar pela matrícula");
        System.out.print("Selecione uma opção: ");

        int opcaoConsulta = scanner.nextInt();
        scanner.nextLine();
        boolean encontrado = false;

        if (opcaoConsulta == 1) {
            System.out.print("Digite o nome do usuário para buscar: ");
            String nomeBusca = scanner.nextLine();

            for (CadastroUsuario usuario : todosUsuariosList) {
                if (usuario.getNome().equalsIgnoreCase(nomeBusca)) {
                    usuario.exibirCadastro();
                    encontrado = true;
                    break;
                }
            }
        } else if (opcaoConsulta == 2) {
            System.out.print("Digite o número da matrícula do usuário para buscar: ");
            int matriculaBusca = scanner.nextInt();

            for (CadastroUsuario usuario : todosUsuariosList) {
                if (usuario.getMatricula() == matriculaBusca) {
                    usuario.exibirCadastro();
                    encontrado = true;
                    break;
                }
            }
        } else {
            System.out.println("Opção inválida para busca.");
        }

        if (!encontrado) {
            System.out.println("Usuário não encontrado.");
        }
    }
}


