package atividades2.atividade01;

public class Aluno {
    //atributos
    private String nome;
    private int matricula;
    private String curso;

    //construtor
    public Aluno(String nome, int matricula, String curso){
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    //Getters
    public String getNome(){return nome;}
    public int getMatricula(){return matricula;}
    public String getCurso(){return curso;}


    //Setters
    public void setNome(String nome){this.nome = nome;}
    public void setMatricula(int matricula){this.matricula = matricula;}
    public void setCurso(String curso){this.curso = curso;}

    @Override
    public String toString() {
        return nome + " (" + matricula + ") - " + curso;
    }
}
