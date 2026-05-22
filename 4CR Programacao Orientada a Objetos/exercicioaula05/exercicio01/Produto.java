package exercicioaula05.exercicio01;

class Produto {
    
    private String nome;
    private double preco;

    public String getNome() {
        return nome;
    }

    // Construtor vazio
    public Produto() {
        System.out.println("Produto criado");
    }

    public double getPreco() {
        return preco;
    }

    // Construtor com parâmetros
    public Produto(String nome, double preco) {
        this.nome = nome;
        if (preco < 0) {
            this.preco = 0.0;
            System.out.println("Preço inválido!");
        } else {
            this.preco = preco;
        }
    }

}
