/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
import java.io.RandomAccessFile;

public class Arquivo {
    static void escreveArquivo(int n, String nomeArquivo) throws Exception{
        RandomAccessFile arquivo = new RandomAccessFile("saida.txt", "rw");
        for(int i = 0; i < n; i++){
            arquivo.writeDouble(MyIO.readDouble());
        }
        arquivo.close();
       
    }
    static void leArquivo(int n, String nomeArquivo) throws Exception{
        RandomAccessFile arquivo = new RandomAccessFile("saida.txt", "r");
        double valor;
        for(int i = 8*(n-1); i >= 0; i-=8){
            arquivo.seek(i);
            valor = arquivo.readDouble();
            if(valor == (int)valor){
                MyIO.println((int)valor);
            }else{
                MyIO.println(valor);
            }
        }
        arquivo.close();
    }
    public static void main(String[] args) {
        String saida = "saida.txt";
        int numero = MyIO.readInt();
        try{
            escreveArquivo(numero, saida);
            leArquivo(numero, saida);
        }catch(Exception e){

        }
        
    }
}
