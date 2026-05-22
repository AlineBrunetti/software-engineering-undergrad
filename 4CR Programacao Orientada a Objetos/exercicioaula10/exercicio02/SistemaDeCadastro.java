package exercicioaula10.exercicio02;

// Arquivo: SistemaDeCadastro.java

public class SistemaDeCadastro {

    public static void main(String[] args) {
        // --- Tentativa de Cadastro 1: Usuário com idade inválida ---
        System.out.println("Tentando cadastrar o primeiro usuário (idade 16)...");
        try {
            // Tentamos criar um usuário que violará nossa regra de negócio.
            Usuario usuarioMenor = new Usuario("Carlos", 16);
            System.out.println("Usuário cadastrado com sucesso: " + usuarioMenor); // Esta linha não será executada.

        } catch (IdadeInvalida e) {
            // O bloco 'catch' é executado porque a exceção foi lançada.
            System.err.println("!!! ERRO AO CADASTRAR: " + e.getMessage());
        }
        // so pra separar
        System.out.println("\n-------------------------------------------------\n");

        // --- Tentativa de Cadastro 2: Usuário com idade válida ---
        System.out.println("Tentando cadastrar o segundo usuário (idade 25)...");
        try {
            // Tentamos criar um usuário que atende à nossa regra de negócio.
            Usuario usuarioMaior = new Usuario("Ana", 25);
            System.out.println("Usuário cadastrado com sucesso: " + usuarioMaior);

        } catch (IdadeInvalida e) {
            // Este bloco 'catch' não será executado nesta tentativa.
            System.err.println("!!! ERRO AO CADASTRAR: " + e.getMessage());
        }

        System.out.println("\nO programa continua sua execução.");
    }
}
