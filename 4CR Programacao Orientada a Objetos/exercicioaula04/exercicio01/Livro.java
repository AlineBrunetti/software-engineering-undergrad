package exercicioaula04.exercicio01;

class Livro {
    private String titulo;
    private String autor;
    private int ano;    

    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getAno() {
        return ano;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setAno(int ano) {
        if (ano < 0) {
            throw new IllegalArgumentException("Ano não pode ser negativo.");
        }
        this.ano = ano;
    }
}
