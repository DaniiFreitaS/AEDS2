/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
class Palindromo {
    static boolean isPalindromo (String s){
        int tam = s.length();     
        for(int i = 0; i < (tam)/2;i++){
            if(s.charAt(i) != s.charAt(tam-i-1)){//testa se o caractere e' igual o outro
                return false;
                }
            }
        return true;
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
                if(isPalindromo(palavra))
                MyIO.println("SIM");
                else
                MyIO.println("NAO");
                }
    }
    }
}