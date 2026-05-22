package exercicioaula10.exercicio01;

public class OutOfBounds {
    public static void main(String[] args) {
        // 1. Declara e inicializa um array de inteiros com 5 elementos.
        // Os índices válidos são 0, 1, 2, 3, 4.
        int[] meuArray = {10, 20, 30, 40, 50};

        System.out.println("Tentando acessar um elemento do array...");

        try {
            // 2. Tentativa de acessar um índice que está fora dos limites do array.
            // O índice 10 não existe, pois o array tem apenas 5 elementos (índices 0-4).
            // Esta linha irá lançar uma ArrayIndexOutOfBoundsException.
            int elemento = meuArray[10];
            System.out.println("O elemento no índice 10 é: " + elemento); // Esta linha nunca será executada.

        } catch (ArrayIndexOutOfBoundsException e) {
            // 3. Captura a exceção específica.
            // O bloco 'catch' é executado quando a exceção do tipo especificado ocorre no bloco 'try'.
            System.err.println("Erro: Tentativa de acessar um índice inválido do array.");
            System.err.println("Detalhes da exceção: " + e.getMessage());

        } finally {
            // 4. (Opcional) O bloco 'finally' sempre é executado,
            // quer uma exceção tenha ocorrido ou não.
            System.out.println("O bloco 'try-catch' foi finalizado.");
        }

        System.out.println("O programa continua a execução após a captura da exceção.");
    }
}
