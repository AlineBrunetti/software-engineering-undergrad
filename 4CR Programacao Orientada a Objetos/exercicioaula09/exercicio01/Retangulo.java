package exercicioaula09.exercicio01;

public class Retangulo implements FormaGeometrica{

    private double base;
    private double altura;

    public Retangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double CalcularArea() {
        return base * altura;
    }
}
