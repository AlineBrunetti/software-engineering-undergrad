package exercicioaula10.exercicio03;

public class TesteCalculadora {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        // --- Cenário 1: Divisão por zero (deve lançar exceção) ---
        System.out.println("--- Testando divisão por zero (10 / 0) ---");
        try {
            double resultado = calc.dividir(10, 0);
            System.out.println("Resultado: " + resultado); // Esta linha não será executada.
        } catch (DivisaoPorZero e) {
            // Capturamos a exceção e exibimos a mensagem de erro.
            System.err.println("Erro capturado: " + e.getMessage());
        } finally {
            System.out.println("Final do primeiro bloco de teste.");
        }

        System.out.println("\n============================================\n");

        // --- Cenário 2: Divisão normal (deve funcionar) ---
        System.out.println("--- Testando divisão válida (10 / 4) ---");
        try {
            double resultado = calc.dividir(10, 4);
            System.out.println("Resultado (10 / 4): " + resultado);
        } catch (DivisaoPorZero e) {
            // Este bloco não será executado, pois a operação é válida.
            System.err.println("Erro capturado: " + e.getMessage());
        } finally {
            System.out.println("Final do segundo bloco de teste.");
        }
    }
}