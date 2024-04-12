public class Booleano {
    static int not(int a){
        return a == 0 ? 1 : 0;
    }
    static int and(int a, int b){
        return a == 1 && b == 1 ? 1 : 0;
    }
    static int and(int a, int b, int c){
        return a == 1 && b == 1 && c == 1 ? 1 : 0;
    }
    static String trocaExpressao(String s){
        String nova = "";
        String and = "and(";
        String not = "not(";
        String or = "or(";
        int i = 0;
        do{
            if(s.charAt(i) == 'a' && s.charAt(i+1) == 'n' && s.charAt(i+2) == 'd' && s.charAt(i+3) == '('){
                if(s.charAt(i+4) == '1' && s.charAt(i+5) == '1'){
                    if(s.charAt(i+6) == ')'){
                        nova += '1';
                    }else if (s.charAt(i+6) == '1'){
                        if(s.charAt(i+7) == ')'){
                            nova += '1';
                        }
                    }
                }
                else if (s.charAt(i+4) == '0'){
                    nova += '0';
                }
            }else
            nova += s.charAt(i);
            i++;
        }while (nova.length() > 1);
        return nova;
    }
}
