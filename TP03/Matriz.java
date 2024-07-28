import java.util.ArrayList;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Date;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.text.ParseException;
import java.io.IOException;

class Celula{
    public int elemento;
    public Celula dir;
    public Celula esq;
    public Celula sup;
    public Celula inf;

    
    public Celula(){
        this.elemento = 0;
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
    public Celula(int x){
        this.elemento = x;
        this.dir = null;
        this.esq = null;
        this.sup = null;
        this.inf = null;
    }
}

class Matriz{
    private Celula inicio;
    private int linha,coluna;
    public Matriz(){
        this(3,3);
    }
    public Matriz(int linhas, int colunas){
       inicio = new Celula(0);
       this.linha = linhas;
       this.coluna = colunas;
       Celula i = inicio;
       for(int j = 1; j< this.coluna; j++){
        Celula nova = new Celula(0);
        i.dir = nova;
        nova.esq = i;
        i = nova;
       }

       Celula linhaAnterior = inicio;
       for(int k = 1; k<this.linha; k++){
        Celula novaLinha = new Celula(0);
        linhaAnterior.inf = novaLinha;
        novaLinha.sup = linhaAnterior;

        Celula celulaAtualLinha = novaLinha;
        Celula celulaAcima = linhaAnterior;
        for(int j = 1; j<this.coluna; j++){
            Celula novaCelula = new Celula(0);
            celulaAtualLinha.dir = novaCelula;
            novaCelula.esq = celulaAtualLinha;

            celulaAcima = celulaAcima.dir;
            celulaAcima.inf = novaCelula;
            novaCelula.sup = celulaAcima;

            celulaAtualLinha=novaCelula;
        }
        linhaAnterior = novaLinha;
       }
    

    }

    public void printar(){
        Celula i = inicio;
        Celula sentinela = inicio;
        for(int j = 0; j<linha;j++){
            for(int k = 0;k<coluna;k++){
                System.out.print(i.elemento+ " ");
                i = i.dir;
            }
            sentinela = sentinela.inf;
            i = sentinela;
            System.out.println();
        }
    }

    public void diagPrincipal(){
        Celula j = inicio;
        while(j.dir!= null){
            System.out.print(j.elemento+" ");
            j = j.inf;
            j = j.dir;
        }
        System.out.print(j.elemento+" ");
    }

    public void insert(int x){
        Celula j = inicio;
        Celula acompanharInicio = inicio;
        while(j.elemento!= 0){
            j = j.dir;
            if(j==null){
                acompanharInicio = acompanharInicio.inf;
                j = acompanharInicio;
                if(j == null && acompanharInicio == null){
                    System.out.println("LISTA CHEIA");
                    break;
                }
            }
        }
        j.elemento = x;
    }
    public void diagSecundaria(){
        System.out.println();
        Celula j = inicio;
        while(j.dir!= null){
            j = j.dir;
        }
        while(j.esq!= null){
            System.out.print(j.elemento + " ");
            j = j.inf;
            j = j.esq;
        }
        System.out.println(j.elemento);


    }    
    public Matriz somaDuasMatriz(Matriz b){
        Matriz resp = new Matriz(this.linha, this.coluna);
        Celula nova = resp.inicio;
        Celula matrizA= this.inicio;
        Celula matrizB = b.inicio;
        for(int i = 0; i< this.linha; i++){
            for(int j = 0; j<this.coluna;j++){
                nova.elemento = matrizA.elemento+matrizB.elemento;
                nova = nova.dir;
                matrizB = matrizB.dir;
                matrizA = matrizA.dir;
            }
            nova= nova.inf;
            matrizB = matrizB.inf;
            matrizA = matrizA.inf;
        }
        return resp;
    }
    public Matriz multiplicaDuasMatriz(Matriz b) {
        if (this.coluna != b.linha) {
            throw new IllegalArgumentException("As matrizes não podem ser multiplicadas");
        }
    
        Matriz resp = new Matriz(this.linha, b.coluna);
    
        Celula nova = resp.inicio;
        Celula matrizA= this.inicio;
        Celula matrizB = b.inicio;
    
        for (int i = 0; i < this.linha; i++) {
            for (int j = 0; j < b.coluna; j++) {
                int soma = 0;
                Celula auxA = matrizA;
                Celula auxB = matrizB;
    
                for (int k = 0; k < this.coluna; k++) {
                    soma += auxA.elemento * auxB.elemento;
                    auxA = auxA.dir;
                    auxB = auxB.inf;
                }
    
                nova.elemento = soma;
                nova = nova.dir;
                matrizB = matrizB.dir; 
            }
    
            matrizA = matrizA.inf; 
            matrizB = b.inicio; 
            nova = nova.inf;
        }
    
        return resp;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for(int i = 0; i<input; i++){
            int linhaMatriz1 = sc.nextInt();
            int colunaMatriz1 = sc.nextInt();
            sc.nextLine();
            Matriz Matriz1= new Matriz(linhaMatriz1,colunaMatriz1);
            for(int j = 0; j<linhaMatriz1; j++){
                String elementosPorLinha = sc.nextLine();
                String[] elementos = elementosPorLinha.split(" ");
                for(String elemento : elementos){
                    Matriz1.insert(Integer.parseInt(elemento));
                }
            }
            int linhaMatriz2 = sc.nextInt();
            int colunaMatriz2 = sc.nextInt();
            sc.nextLine();
            Matriz Matriz2= new Matriz(linhaMatriz2,colunaMatriz2);
            for(int j = 0;j<linhaMatriz2; j++){
                String elementosPorLinha = sc.nextLine();
                String[] elementos = elementosPorLinha.split(" ");
                for(String elemento : elementos){
                    Matriz2.insert(Integer.parseInt(elemento));
                }
            }
            Matriz1.diagPrincipal();
            Matriz1.diagSecundaria();
            Matriz somaDasMatrizes = Matriz1.somaDuasMatriz(Matriz2);
            somaDasMatrizes.printar();
            Matriz multiplicarMatrizes = Matriz1.multiplicaDuasMatriz(Matriz2);
            multiplicarMatrizes.printar();

        }

        sc.close();

    }

    
}
