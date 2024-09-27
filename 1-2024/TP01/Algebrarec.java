/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
public class Algebrarec {
    static String and(String s){
        String novaString = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a' && s.charAt(i+1) == 'n' && s.charAt(i+2) == 'd' && s.charAt(i+3) == '('){
                if(s.charAt(i+7) == ')' || s.charAt(i+9) == ')'){
                    i+=4;
                    if(s.charAt(i) == '0'){
                        novaString+= '0';
                        if(s.charAt(i+3) == ')'){
                            i+=3;
                        }else{
                            i+=5;
                        }
                    }else if(s.charAt(i) == '1' && s.charAt(i+1) == ',' && s.charAt(i+2) == '1'){
                        if(s.charAt(i+3) == ')'){
                            novaString+= '1';
                            i+=3;
                        }else if(s.charAt(i+3) == ','){
                            if(s.charAt(i+4) == '0'){
                                novaString+= '0';
                            }else{
                                novaString+= '1';
                            }
                            i+=5;
                        }
                    }else if(s.charAt(i) == '1' && s.charAt(i+1) == ',' && s.charAt(i+2) == '0'){
                        novaString+= '0';
                        if(s.charAt(i+3) == ')'){
                            i+=3;
                        }else{
                            i+=5;
                        }
                    }
                }else{
                    novaString+= s.charAt(i);
                }
            }else{
                novaString+= s.charAt(i);
            }
        }
        return novaString;
    }
    static String or(String s){
        String novaString = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'o' && s.charAt(i+1) == 'r' && s.charAt(i+2) == '('){
                if(s.charAt(i+6) == ')' || s.charAt(i+8) == ')' || s.charAt(i+10) == ')'){
                    i+=3;

                    if(s.charAt(i) == '1'){
                        novaString+= '1';
                        if(s.charAt(i+3) == ')'){
                            i+=3;
                        }else if(s.charAt(i+5) == ')'){
                            i+=5;
                        }else{
                            i+=7;
                        }
                    }else if(s.charAt(i) == '0' && s.charAt(i+1) == ',' && s.charAt(i+2) == '1'){
                        novaString+= '1';
                        if(s.charAt(i+3) == ')'){
                            i+=3;
                        }else if(s.charAt(i+5) == ')'){
                            i+=5;
                        }else{
                            i+=7;
                        }
                    }else if(s.charAt(i) == '0' && s.charAt(i+1) == ',' && s.charAt(i+2) == '0'){
                        if(s.charAt(i+3) == ')'){
                            novaString+= '0';
                            i+=3;
                        }else if(s.charAt(i+3) == ','){
                            if(s.charAt(i+4) == '0'){
                                if(s.charAt(i+5) == ')'){
                                    novaString+= '0';
                                    i+=5;
                                }else{
                                    if(s.charAt(i+6) == '1'){
                                        novaString+= '1';
                                    }else{
                                        novaString+= '0';
                                    }
                                    i+=7;
                                }
                            }else{
                                novaString+= '1';
                                if(s.charAt(i+5) == ')'){
                                    i+=5;
                                }else{
                                    i+=7;
                                }
                            }
                        }
                    }
                }else{
                    novaString+= s.charAt(i);
                }
            }else{
                novaString+= s.charAt(i);
            }
        }
        return novaString;
    }
    static String not(String s){
        String novaString = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'n' && s.charAt(i+1) == 'o' && s.charAt(i+2) == 't' && s.charAt(i+3) == '('){
                if(s.charAt(i+5) == ')'){
                    i+=4;
                    if(s.charAt(i) == '1'){
                        novaString+= '0';
                    }else{
                        novaString+= '1';
                    }
                    i+=1;
                }else{
                    novaString+= s.charAt(i);
                }
            }else{
                novaString+= s.charAt(i);
            }
        }
        return novaString;
    }
    static String removeEspaco(String s){
        String novaString = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
                //nao faz nada
            }else{
                novaString+= s.charAt(i);
            }
        }
        return novaString;
    }
    static String removeLetra(String L,String s){
        String novaString = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == L.charAt(0)){
                //nao faz nada
            }else{
                novaString+= s.charAt(i);
            }
        }
        return novaString;
    }
    static String trocaLetra(String L, String T,String s){
        String novaString = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == L.charAt(0)){
                novaString+= T.charAt(0);
            }else{
                novaString+= s.charAt(i);
            }
        }
        return novaString;
    }
    static String expressao(String s){
        //remove espacos
        s = removeEspaco(s);
        int numVariaveis = (int)(s.charAt(0) - 48);
        String a = "",b = "",c = "";
        if(numVariaveis == 2){
            a += s.charAt(1);
            b += s.charAt(2);
            //remove o inicio para ficar somente a expressao
            s = removeLetra(a, s);
            s = removeLetra(b, s);
            s = removeLetra("2", s);

        }else if(numVariaveis == 3){
            a += s.charAt(1);
            b += s.charAt(2);
            c += s.charAt(3);
            //remove o inicio para ficar somente a expressao
            s = removeLetra(a, s);
            s = removeLetra(b, s);
            s = removeLetra(c, s);
            s = removeLetra("3", s);
        }
        if(s.length() > 1) {
            s = trocaLetra("A", a, s);
            s = trocaLetra("B", b, s);
            s = trocaLetra("C", c, s);
            //OPERACAO NOT PRECISA SER FEITA ANTES DAS OUTRAS
            s = not(s);
            s = and(s);
            s = or(s);
            s = expressao(s);//chama a funcao recursivamente ate s > 1. A cada vez que a funcao e' chamada. a expressao diminui ate chegar no resultado final.
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
