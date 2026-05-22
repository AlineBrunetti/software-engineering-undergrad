package exercicioaula07.exercicio01;

public class Forma {
    protected String nome;
    protected String formula;

    public Forma(String nome, String formula) {
        this.nome = nome;
        this.formula = formula;
    }

    public double area() {
        System.out.println("Área genérica de forma");
        return 0;
    }

    @Override
    public String toString() {
        return "Nome da forma é: " + nome + " | Fórmula: " + formula;
    }

    public String getNome() {
        return this.nome;
    }

    public String getFormula() {
        return this.formula;
    }
}
