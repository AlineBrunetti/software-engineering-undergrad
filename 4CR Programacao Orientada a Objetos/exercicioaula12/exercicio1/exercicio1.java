package exercicioaula12.exercicio1;


interface GeradorRelatorio {
    void gerar(exercicio1 relatorio);
}


class GeradorPDF implements GeradorRelatorio {
    public void gerar(exercicio1 relatorio) {
       
        System.out.println("Gerando relatório em PDF...");
    }
}


class GeradorExcel implements GeradorRelatorio {
    public void gerar(exercicio1 relatorio) {
   
        System.out.println("Gerando relatório em Excel...");
    }
}


public class exercicio1 {


}


class EnviadorEmail {
    public void enviar(exercicio1 relatorio) {
        System.out.println("Enviando relatório por e-mail...");
    }
}
