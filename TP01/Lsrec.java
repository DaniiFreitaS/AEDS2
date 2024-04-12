/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
public class Lsrec {
    static boolean isVogal(char s){
        return (s == 'a' || s == 'A' || s == 'e' || s == 'E' || s == 'i' || s == 'I' || s == 'o' || s == 'O' || s == 'u' || s == 'U');
    }
    static boolean isConsoante(char s){
        return (!isVogal(s) && s >= 'a' && s <= 'z' || s >= 'A' && s <= 'Z');
    }
    static boolean isNumero(char s){
        return (s >= '0' && s <= '9');
    }
    static boolean isVogais(String s, int i){
        boolean resp = true;
        if(i < s.length()){
            if(!isVogal(s.charAt(i))){//se for vogal nao faz nada
                return false;
            }
            i++;
            resp = isVogais(s, i);//chama a funcao recursivamente enquanto i < s.length() ou ate retornar false
        }
        return resp;
    }
    static boolean isConsoantes(String s, int i){
        boolean resp = true;
        if(i < s.length()){
            if(!isConsoante(s.charAt(i))){//se for consoante nao faz nada
                return false;
            }
            i++;
            resp = isConsoantes(s, i);//chama a funcao recursivamente enquanto i < s.length() ou ate retornar false
        }
        return resp;
    }
    static boolean isInteiro(String s, int i){
        boolean resp = true;
        if(i < s.length()){
            if(!isNumero(s.charAt(i))){//se for numero nao faz nada
                return false;
            }
            i++;
            resp = isInteiro(s, i);//chama a funcao recursivamente enquanto i < s.length() ou ate retornar false
        }
        return resp;
    }
    static boolean isReal(String s, int i, int contador){
        boolean resp = true;
        if(i < s.length()){
            if((s.charAt(i) == '.' || s.charAt(i) == ',') && contador == 0 && s.length() > 1){//se for um numero com . ou , ele verifica e adiciona no contador. Testa se a String tem tamanho 1 para evitar falso positivo no caso da string ser apenas . ou , 
                contador++;//Um numero real pode ter no maximo 1 . ou ,
            }else if(!isNumero(s.charAt(i))){//se for numero nao faz nada
                return false;
            }
            i++;
            resp = isReal(s, i, contador);//chama a funcao recursivamente enquanto i < s.length() ou ate retornar false
        }
        return resp;
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
            else{
                if(isVogais(palavra, 0))//0 necessario para inicar i = 0 na funcao
                MyIO.print("SIM ");
                else
                MyIO.print("NAO ");
                if(isConsoantes(palavra, 0))//0 necessario para inicar i = 0 na funcao
                MyIO.print("SIM ");
                else
                MyIO.print("NAO ");
                if(isInteiro(palavra, 0))//0 necessario para inicar i = 0 na funcao
                MyIO.print("SIM ");
                else
                MyIO.print("NAO ");
                if(isReal(palavra, 0, 0))//0 necessario para inicar i e contador = 0 na funcao
                MyIO.println("SIM");
                else
                MyIO.println("NAO");
            }
    }
    }
}
