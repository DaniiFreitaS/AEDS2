import java.util.Scanner;

public class expressao {
    static boolean isFIM(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    static boolean contaParenteses(String s){
        boolean resp = true;
        int dir = 0;
        int esq = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ')'){
                dir++;
            }else if(s.charAt(i) == '('){
                esq++;
            }
            if(dir>esq){
                resp = false;
                i = s.length();
            }
        }
        if(esq!=dir){
            resp = false;
        }
        return resp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String entrada = sc.nextLine();
        while (!isFIM(entrada)) {
            if(contaParenteses(entrada)){
                System.out.println("correto");
            }else{
                System.out.println("incorreto");
            }
            entrada = sc.nextLine();
        }
        sc.close();
        
    }
}
