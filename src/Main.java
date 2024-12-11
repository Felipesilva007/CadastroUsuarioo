import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Criando os objetos CadastroUsuario

        ArrayList<CadastroUsuario> todosUsuariosList = new ArrayList<>();
        CadastroUsuario usuario1 = new CadastroUsuario("Tatiana", "AQV", 938431);
        CadastroUsuario usuario2 = new CadastroUsuario("Ricardo", "Coodernador", 128533);
        CadastroUsuario usuario3 = new CadastroUsuario("Paulo", "Coodernador", 567123);
        CadastroUsuario usuario4 = new CadastroUsuario("Guilherme", "Aluno", 555678);
        CadastroUsuario usuario5 = new CadastroUsuario("João", "Aluno", 987653);
        CadastroUsuario usuario6 = new CadastroUsuario("Felipe", "Aluno", 876944);

        todosUsuariosList.add(usuario1);
        todosUsuariosList.add(usuario2);
        todosUsuariosList.add(usuario3);
        todosUsuariosList.add(usuario4);
        todosUsuariosList.add(usuario5);
        todosUsuariosList.add(usuario6);

        int opcao;
        do {
            String menu = """
                    _________________________________________________________
                    |       --------Gerenciamento de Usuários--------       |
                    |       1- Exibir usuários cadastrados                  |
                    |       2- Inserir novo cadastro                        |
                    |       3- Buscar Usuário por nome ou n° matricula      |
                    |       4- Sair                                         |
                    _________________________________________________________
                    """;
            System.out.println(menu);
            System.out.print("Selecione uma opção:");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    for (int i = 0; i < todosUsuariosList.toArray().length; i++) {
                        System.out.println("\n");
                        todosUsuariosList.get(i).exibirCadastro();
                    }
                    break;
                case 2:
                    System.out.print("Digite o seu nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o seu cargo: ");
                    String cargo = scanner.nextLine();

                    System.out.print("Digite o número da sua matrícula: ");
                    int matricula = scanner.nextInt();
                    scanner.nextLine();

                    CadastroUsuario novoUsuario = new CadastroUsuario(nome, cargo, matricula);
                    todosUsuariosList.add(novoUsuario);

                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                case 3:
                    buscarUsuario(todosUsuariosList);
                    break;
                case 4:
                    System.out.println("Fim do Programa!");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opção Inválida, Tente Novamente!");
            }
        } while (opcao != 5);
        // Criando o objeto Scanner para capturar a entrada do usuário


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
