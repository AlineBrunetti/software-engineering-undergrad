package exercicioaula07.exercicio01;

public class Retangulo extends Forma {
    private final double largura;
    private final double altura;

    public Retangulo(String nome, double largura, double altura) {
        super(nome, "base * altura"); // subclasse passa a fórmula
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public double area() {
        return largura * altura;
    }

    @Override
    public String toString() {
        return "Retângulo: " + getNome() + " | Fórmula: " + getFormula() + " | Área = " + area();
    }
}