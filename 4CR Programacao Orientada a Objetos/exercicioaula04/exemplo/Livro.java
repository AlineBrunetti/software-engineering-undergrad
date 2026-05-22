package exercicioaula04.exemplo;

class Livro {
    private String nome;
    private String autor;
    private int paginas;    

    public String getNome(){ return nome; }
    public String getAutor(){ return autor; }
    public int getpaginas(){ return paginas; }

    public void setNome(String nome){
        this.nome = nome;       
    }
    
    public void setAutor(String novoAutor){
        autor = novoAutor;       
    }

    public void setPaginas(int numPaginas){
        paginas = numPaginas;
    }
    
}
