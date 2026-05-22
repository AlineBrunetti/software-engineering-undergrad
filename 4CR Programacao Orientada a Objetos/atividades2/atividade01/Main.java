package atividades2.atividade01;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Aluno> alunos = new ArrayList<>();

        alunos.add(new Aluno("Nicolas", 123, "Eng.Software"));
        alunos.add(new Aluno("Alisson", 456, "Matematica"));
        alunos.add(new Aluno("Vinicius", 789, "Filosofia"));
    
        for (Aluno aluno : alunos){
            System.out.println(aluno);
        }

    }
}
