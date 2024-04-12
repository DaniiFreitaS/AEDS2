/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
public class Ciframento {
    static String ciframento(String s){
        String cifrada = ""; // necessario criar uma nova string para adicionar as letras alteradas
        for(int i = 0; i < s.length(); i++){
            cifrada += (char)(s.charAt(i)+3); //pega o valor do char, adiciona 3 e converte para char para fazer o ciframento
        }
        return cifrada;
    }

    static boolean isFIM(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args) {
        int fim = 0;
        String palavra = new String();
        while(fim == 0){
            palavra = MyIO.readLine();
            if(isFIM(palavra))//se a palavra for fim, sai do loop e termina o programa
            fim = 1;
            else
            MyIO.println(ciframento(palavra));
    }
    }
}
