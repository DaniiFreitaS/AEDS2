/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
char* swapChar(char* s, char x, char y, int i){
        if(i < strlen(s)){
            if(s[i] == x){ // verifica se a letra e' a letra a ser trocada
                s[i] = y;
            }
            i++;
            s = swapChar(s, x, y, i);//faz a recursividade enquanto i < strlen(s)
        }
        return s;
    }
int main(int argc, char const *argv[]){
        setlocale(LC_ALL, "pt_BR.UTF-8");
        int fim = 0;
        char x,y;
        char palavra[1000];
        int seed = 4;
        srand(seed);
        while(fim == 0){
            x = (char)('a' + (abs(rand()) % 26));
            y = (char)('a' + (abs(rand()) % 26));
            //printf("%c %c \n", x, y);
            scanf(" %[^\r\n]", palavra);//pega a linha inteira incluindo os espaços
            if(strcmp(palavra, "FIM") == 0)//se a palavra for fim, sai do loop e termina o programa
            fim = 1;
            else
            printf("%s\n",swapChar(palavra, x , y, 0));
    }
    return 0;
}
