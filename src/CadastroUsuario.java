import java.util.Scanner;

public class CadastroUsuario {
    String nome;
    String cargo;
    int matricula;

    // Construtor da classe
    public CadastroUsuario(String nome, String cargo, int matricula) {
        this.nome = nome;
        this.cargo = cargo;
        this.matricula = matricula;
    }

    // Método para exibir os detalhes do cadastro do aluno
    public void exibirCadastro() {
        System.out.println("Nome do Aluno: " + nome + "\n" + "Número da matrícula: " + matricula + "\n" + "Cargo: " + cargo);
    }

    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
}

