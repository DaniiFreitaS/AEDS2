/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
class Palindromorec {
    static boolean isPalindromo (String s, int i){
        int tam = s.length(); 
        boolean resp = true;    
        if(i < (tam)/2){
            if(s.charAt(i) != s.charAt(tam-i-1)){//testa se o caractere e' igual o outro
                return false;
                }
            i++;
            resp = isPalindromo(s, i);//chama a funcao recursivamente ate i < tam/2 ou retornar falso
            }
        return resp;
    }
    static boolean isFIM(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args) {
        MyIO.setCharset("UTF-8");//coloca no formato de texto para pegar cedilha e acentos, muito mais simples de funcionar em relacao ao mesmo codigo em c
        int fim = 0;
        String palavra = new String();
        while(fim == 0){
            palavra = MyIO.readLine();
            if(isFIM(palavra))
            fim = 1;
            else{
                if(isPalindromo(palavra, 0))
                MyIO.println("SIM");
                else
                MyIO.println("NAO");
                }
    }
    }
}