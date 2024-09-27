/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include <stdint.h>

#define JAVA_RANDOM_SEED 4
#define JAVA_RANDOM_MASK 0xFFFFFFFFFFFFULL
#define JAVA_RANDOM_MULTIPLIER 0x5DEECE66DLL
#define JAVA_RANDOM_INCREMENT 0xBLL
#define JAVA_RANDOM_BITS 48

static uint64_t seed;

void init_java_random(uint64_t s) {
    seed = (s ^ JAVA_RANDOM_MULTIPLIER) & JAVA_RANDOM_MASK;
}

uint32_t next_int() {
    seed = (seed * JAVA_RANDOM_MULTIPLIER + JAVA_RANDOM_INCREMENT) & JAVA_RANDOM_MASK;
    return (uint32_t)(seed >> (JAVA_RANDOM_BITS - 32));
}

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
        init_java_random(JAVA_RANDOM_SEED);
        int fim = 0;
        char x,y;
        char palavra[1000];
        //int seed = 4;
        //srand(seed);
        while(fim == 0){
            //int randomInt = next_int();
            //char randomChar = 'a' + abs(randomInt) % 26;
            //x = (char)('a' + (abs(rand()) % 26));
            //y = (char)('a' + (abs(rand()) % 26));
            x = 'a' + abs(next_int()) % 26;
            y = 'a' + abs(next_int()) % 26;
            //printf("%c %c \n", x, y);
            scanf(" %[^\r\n]", palavra);//pega a linha inteira incluindo os espaços
            if(strcmp(palavra, "FIM") == 0)//se a palavra for fim, sai do loop e termina o programa
            fim = 1;
            else
            printf("%s\n",swapChar(palavra, x , y, 0));
    }
    return 0;
}
