package exercicioaula10.exercicio03;

public class Calculadora {
    /**
     * Realiza a divisão de dois números inteiros.
     *
     * @param a O dividendo (numerador).
     * @param b O divisor (denominador).
     * @return O resultado da divisão como um double.
     * @throws DivisaoPorZeroException se o divisor 'b' for igual a zero.
     */
    public double dividir(int a, int b) throws DivisaoPorZero {
        // 1. Verifica a condição de exceção.
        if (b == 0) {
            // 2. Lança a nossa exceção personalizada com uma mensagem clara.
            throw new DivisaoPorZero("Não é possível dividir um número por zero.");
        }

        // 3. Se não houver exceção, realiza a operação e retorna o resultado.
        // Fazemos um "cast" para double para garantir que o resultado seja decimal.
        return (double) a / b;
    }
}
