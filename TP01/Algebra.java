/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
public class Algebra {
    static String expressao(String s){
        s = s.replace(" ", "");
        int numVariaveis = (int)(s.charAt(0) - 48);
        String a = "",b = "",c = "";
        if(numVariaveis == 2){
            a += s.charAt(1);
            b += s.charAt(2);
            s = s.replace(a, "");
            s = s.replace(b, "");
            s = s.replace("2", "");
        }else{
            a += s.charAt(1);
            b += s.charAt(2);
            c += s.charAt(3);
            s = s.replace(a, "");
            s = s.replace(b, "");
            s = s.replace(c, "");
            s = s.replace("3", "");
        }
        while (s.length() > 1) {
            s = s.replace("A", a);
            s = s.replace("B", b);
            s = s.replace("C", c);
            s = s.replace("and(0,0)", "0");
            s = s.replace("and(0,1)", "0");
            s = s.replace("and(1,0)", "0");
            s = s.replace("and(1,1)", "1");
            s = s.replace("and(0,0,0)", "0");
            s = s.replace("and(0,0,1)", "0");
            s = s.replace("and(0,1,0)", "0");
            s = s.replace("and(0,1,1)", "0");
            s = s.replace("and(1,0,0)", "0");
            s = s.replace("and(1,0,1)", "0");
            s = s.replace("and(1,1,0)", "0");
            s = s.replace("and(1,1,1)", "1");
            s = s.replace("or(0,0)", "0");
            s = s.replace("or(0,1)", "1");
            s = s.replace("or(1,0)", "1");
            s = s.replace("or(1,1)", "1");
            s = s.replace("or(0,0,0)", "0");
            s = s.replace("or(0,0,1)", "1");
            s = s.replace("or(0,1,0)", "1");
            s = s.replace("or(0,1,1)", "1");
            s = s.replace("or(1,0,0)", "1");
            s = s.replace("or(1,0,1)", "1");
            s = s.replace("or(1,1,0)", "1");
            s = s.replace("or(1,1,1)", "1");
            s = s.replace("or(0,0,0,0)", "0");
            s = s.replace("or(0,0,0,1)", "1");
            s = s.replace("or(0,0,1,0)", "1");
            s = s.replace("or(0,0,1,1)", "1");
            s = s.replace("or(0,1,0,0)", "1");
            s = s.replace("or(0,1,0,1)", "1");
            s = s.replace("or(0,1,1,0)", "1");
            s = s.replace("or(0,1,1,1)", "1");
            s = s.replace("or(1,0,0,0)", "1");
            s = s.replace("or(1,0,0,1)", "1");
            s = s.replace("or(1,0,1,0)", "1");
            s = s.replace("or(1,0,1,1)", "1");
            s = s.replace("or(1,1,0,0)", "1");
            s = s.replace("or(1,1,0,1)", "1");
            s = s.replace("or(1,1,1,0)", "1");
            s = s.replace("or(1,1,1,1)", "1");
            s = s.replace("not(0)", "1");
            s = s.replace("not(1)", "0");       
        }
        return s;
    }
    public static void main(String[] args) {
        int numVariaveis;
        String entrada;
        entrada = MyIO.readLine();
        numVariaveis = entrada.charAt(0)-48;
        while (numVariaveis != 0) {
            MyIO.println(expressao(entrada));
            entrada = MyIO.readLine();
            numVariaveis = entrada.charAt(0)-48;
        }
    }
}
