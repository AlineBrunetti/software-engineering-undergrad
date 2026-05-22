package exercicioaula12.exercicio1;


class Retangulo {
    protected int largura;
    protected int altura;


    public void setLargura(int largura) {
        this.largura = largura;
    }


    public void setAltura(int altura) {
        this.altura = altura;
    }


    public int getArea() {
        return largura * altura;
    }
}


class Quadrado extends Retangulo {
    @Override
    public void setLargura(int largura) {
        this.largura = largura;
        this.altura = largura;
    }


    @Override
    public void setAltura(int altura) {
        this.altura = altura;
        this.largura = altura;
    }
}


public class exercicio2 {
    public static void main(String[] args) {
        Retangulo r = new Quadrado();
        r.setLargura(5);
        r.setAltura(10);
        System.out.println("Área esperada: 50");
        System.out.println("Área real: " + r.getArea());
    }
}
