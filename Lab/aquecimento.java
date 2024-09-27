/*
AEDS 2 lab 01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
import java.util.Scanner;
class aquecimento {
    static int contaMaiuscula(String s){
        int contador = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 65 && s.charAt(i) <= 90){
                contador++;
            }
        }
        return contador;
    }
    static boolean isFIM(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        while (!isFIM(entrada)) {
            System.out.println(contaMaiuscula(entrada));
            entrada = sc.nextLine();
        }
    }
}
