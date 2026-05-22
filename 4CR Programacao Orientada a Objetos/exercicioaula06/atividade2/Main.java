package exercicioaula06.atividade2;

class Main {
    public static void main(String[] args) {
        Circulo circulo = new Circulo();
        circulo.setRaio(5.0);
        circulo.setCor("Azul");
        circulo.setPreenchida(true);
        System.out.println("Raio: " + circulo.getRaio());
        System.out.println("Cor: " + circulo.getCor());
        System.out.println("Preenchido: " + circulo.isPreenchida());
        System.out.println("Área do Círculo: " + circulo.calcularArea());

        Retangulo retangulo = new Retangulo();
        retangulo.setBase(4.0);
        retangulo.setAltura(3.0);
        retangulo.setCor("Vermelho");
        retangulo.setPreenchida(false);
        System.out.println("Base: " + retangulo.getBase());
        System.out.println("Altura: " + retangulo.getAltura());
        System.out.println("Cor: " + retangulo.getCor());
        System.out.println("Preenchido: " + retangulo.isPreenchida());
        System.out.println("Área do Retângulo: " + retangulo.calcularArea());
    }  
}
