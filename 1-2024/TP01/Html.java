/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
import java.io.*;
import java.net.*;

class Html {
   public static String getHtml(String endereco){
      URL url;
      InputStream is = null;
      BufferedReader br;
      String resp = "", line;

      try {
         url = new URL(endereco);
         is = url.openStream();  // throws an IOException
         br = new BufferedReader(new InputStreamReader(is));

         while ((line = br.readLine()) != null) {
            resp += line + "\n";
         }
      } catch (MalformedURLException mue) {
         mue.printStackTrace();
      } catch (IOException ioe) {
         ioe.printStackTrace();
      } 

      try {
         is.close();
      } catch (IOException ioe) {
         // nothing to see here

      }

      return resp;
   }
   static boolean isFIM(String s){
      return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
  }
  static boolean isA(char c){
   return c == 'a';
  }
  static boolean isE(char c){
   return c == 'e';
  }
  static boolean isI(char c){
   return c == 'i';
  }
  static boolean isO(char c){
   return c == 'o';
  }
  static boolean isU(char c){
   return c == 'u';
  }
  static boolean isAAgudo(char c){
   return c == '\u00E1';
  }
  static boolean isEAgudo(char c){
   return c == '\u00E9';
  }
  static boolean isIAgudo(char c){
   return c == '\u00ED';
  }
  static boolean isOAgudo(char c){
   return c == '\u00F3';
  }
  static boolean isUAgudo(char c){
   return c == '\u00FA';
  }
  static boolean isACrase(char c){
   return c == '\u00E0';
  }
  static boolean isECrase(char c){
   return c == '\u00E8';
  }
  static boolean isICrase(char c){
   return c == '\u00EC';
  }
  static boolean isOCrase(char c){
   return c == '\u00F2';
  }
  static boolean isUCrase(char c){
   return c == '\u00F9';
  }
  static boolean isACircunflexo(char c){
   return c == '\u00E2';
  }
  static boolean isECircunflexo(char c){
   return c == '\u00EA';
  }
  static boolean isICircunflexo(char c){
   return c == '\u00EE';
  }
  static boolean isOCircunflexo(char c){
   return c == '\u00F4';
  }
  static boolean isUCircunflexo(char c){
   return c == '\u00FB';
  }
  static boolean isATil(char c){
   return c == '\u00E3';
  }
  static boolean isOTil(char c){
   return c == '\u00F5';
  }
  static boolean isVogal(char s){
   return (s == 'a' || s == 'A' || s == 'e' || s == 'E' || s == 'i' || s == 'I' || s == 'o' || s == 'O' || s == 'u' || s == 'U');
   }
   static boolean isConsoante(char s){
   return (!isVogal(s) && s >= 'a' && s <= 'z');//|| s >= 'A' && s <= 'Z'
   }
   static boolean isBr(String s){
      return (s.charAt(0) == '<' && s.charAt(1) == 'b' && s.charAt(2) == 'r' && s.charAt(3) == '>');
   }
   static boolean isTable(String s){
      return (s.charAt(0) == '<' && s.charAt(1) == 't' && s.charAt(2) == 'a' && s.charAt(3) == 'b' && s.charAt(4) == 'l' && s.charAt(5) == 'e' && s.charAt(6) == '>');
   }
  static int[] contador(String s){
   int[] x = new int[26];
   String temp = "";
   for(int i = 0; i < s.length(); i++){
      if(isA(s.charAt(i))){
         x[0] +=1;
      }else if(isE(s.charAt(i))){
         x[1] +=1;
      }else if(isI(s.charAt(i))){
         x[2] +=1;
      }else if(isO(s.charAt(i))){
         x[3] +=1;
      }else if(isU(s.charAt(i))){
         x[4] +=1;
      }else if(isAAgudo(s.charAt(i))){
         x[5] +=1;
      }else if(isEAgudo(s.charAt(i))){
         x[6] +=1;
      }else if(isIAgudo(s.charAt(i))){
         x[7] +=1;
      }else if(isOAgudo(s.charAt(i))){
         x[8] +=1;
      }else if(isUAgudo(s.charAt(i))){
         x[9] +=1;
      }else if(isACrase(s.charAt(i))){
         x[10] +=1;
      }else if(isECrase(s.charAt(i))){
         x[11] +=1;
      }else if(isICrase(s.charAt(i))){
         x[12] +=1;
      }else if(isOCrase(s.charAt(i))){
         x[13] +=1;
      }else if(isUCrase(s.charAt(i))){
         x[14] +=1;
      }else if(isATil(s.charAt(i))){
         x[15] +=1;
      }else if(isOTil(s.charAt(i))){
         x[16] +=1;
      }else if(isACircunflexo(s.charAt(i))){
         x[17] +=1;
      }else if(isECircunflexo(s.charAt(i))){
         x[18] +=1;
      }else if(isICircunflexo(s.charAt(i))){
         x[19] +=1;
      }else if(isOCircunflexo(s.charAt(i))){
         x[20] +=1;
      }else if(isUCircunflexo(s.charAt(i))){
         x[21] +=1;
      }else if(isConsoante(s.charAt(i))){
         x[22] +=1;
      }else{
         temp = "";
         for(int j = i; j < s.length() && (j-i < 4); j++){
            temp += s.charAt(j);
         }
         if(isBr(temp)){
            x[23] +=1;
            temp = "";
            i+=3;
         }else{
            temp = "";
            for(int k = i; k < s.length() && (k-i < 7); k++){
               temp += s.charAt(k);
            }
            if(isTable(temp)){
               x[24] +=1;
               i+=6;
            }
            
         }
         
      }  
   }
   return x;
  }

   public static void main(String[] args) {
      MyIO.setCharset("UTF-8");
      String endereco, html;
      int[] x = new int[25];
      //endereco = "http://maratona.crc.pucminas.br/series/Friends.html";
      //html = getHtml(endereco);
      //System.out.print(html);
      int fim = 0;
        String palavra = new String();
        while(fim == 0){
            palavra = MyIO.readLine();
            if(isFIM(palavra))//se a palavra for fim, sai do loop e termina o programa
            fim = 1;
            else{
               endereco = MyIO.readLine();
               html = getHtml(endereco);
               x = contador(html);
              MyIO.print("a("+x[0]+") ");
              MyIO.print("e("+x[1]+") ");
              MyIO.print("i("+x[2]+") ");
              MyIO.print("o("+x[3]+") ");
              MyIO.print("u("+x[4]+") ");
              MyIO.print("\u00E1("+x[5]+") ");
              MyIO.print("\u00E9("+x[6]+") ");
              MyIO.print("\u00ED("+x[7]+") ");
              MyIO.print("\u00F3("+x[8]+") ");
              MyIO.print("\u00FA("+x[9]+") ");
              MyIO.print("\u00E0("+x[10]+") ");
              MyIO.print("\u00E8("+x[11]+") ");
              MyIO.print("\u00EC("+x[12]+") ");
              MyIO.print("\u00F2("+x[13]+") ");
              MyIO.print("\u00F9("+x[14]+") ");
              MyIO.print("\u00E3("+x[15]+") ");
              MyIO.print("\u00F5("+x[16]+") ");
              MyIO.print("\u00E2("+x[17]+") ");
              MyIO.print("\u00EA("+x[18]+") ");
              MyIO.print("\u00EE("+x[19]+") ");
              MyIO.print("\u00F4("+x[20]+") ");
              MyIO.print("\u00FB("+x[21]+") ");
              MyIO.print("consoante("+x[22]+") ");
              MyIO.print("<br>("+x[23]+") ");
              MyIO.print("<table>("+x[24]+") ");
              MyIO.println(palavra);

            }
    }
   }
}
