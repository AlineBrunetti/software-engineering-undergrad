package exercicios_abstracao.ex2aluno;

public class Aluno {
    String nome;
    String matricula;
    float[] notas = new float[5];
    int contadorNotas = 0;

    void adicionarNota(float nota) {
        if (contadorNotas < notas.length) {
            notas[contadorNotas] = nota;
            contadorNotas++;
        } else {
            System.out.println("Não é possível adicionar mais notas.");
        }
    }

    float calcularMedia() {
        float soma = 0;
        for (int i = 0; i < contadorNotas; i++) {
            soma += notas[i];
        }
        return contadorNotas > 0 ? soma / contadorNotas : 0;
    }

    void exibirBoletim() {
        System.out.println("Boletim do Aluno: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.print("Notas: ");
        for (int i = 0; i < contadorNotas; i++) {
            System.out.print(notas[i] + " ");
        }
        System.out.println("\nMédia: " + calcularMedia());
    }
}


