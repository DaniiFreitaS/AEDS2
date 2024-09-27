/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
import java.util.Random;

public class Aleatorio {
    
    static String swapChar(String s, char x, char y){
        String trocada = ""; // necessario criar uma nova string para adicionar as letras alteradas
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == x) // verifica se a letra e' a letra a ser trocada
            trocada += y;
            else
            trocada += (char)(s.charAt(i));
        }
        return trocada;
    }

    static boolean isFIM(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");//coloca no formato de texto para pegar cedilha e acentos
        int fim = 0;
        char x,y;
        String palavra = new String();
        Random gerador = new Random();
        gerador.setSeed(4);
        
        while(fim == 0){
            x = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            y = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
            //MyIO.println(x);
            //MyIO.println(y);
            palavra = MyIO.readLine();
            if(isFIM(palavra))//se a palavra for fim, sai do loop e termina o programa
            fim = 1;
            else
            MyIO.println(swapChar(palavra, x , y));
    }
    }
}
