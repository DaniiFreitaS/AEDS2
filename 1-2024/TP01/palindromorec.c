/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

int stringlen(char *s){
    int i = 0;
    while(s[i] != '\0'){
        i++;
    }
    return i;
}
int isPalindromo (unsigned char *s, int i){
    int tam = stringlen(s);
    int resp = 1;
    if(i < (tam)/2){
        if(s[i] == 195){//testa se o caractere e' especial que usa 2 bytes pegando 2 posicoes, sempre sendo a primeira 195
            i++;//passa para o proximo byte do caractere especial
            if(s[i] != s[tam-i]){//tam-i para continuar no caractere a ser testado, tam-i-1 iria para o caractere 195
                return 0;
             }
        }else if (s[i] == 239){//testa se o caractere e' a interrocacao do pub.in que usa 3 bytes
            i+=2;
            if(s[tam-i-1] != 239){
                return 0;
             }
        }else if(s[i] != s[tam-i-1]){//testa se o caractere e' igual o outro
            return 0;
            }
        i++;
        resp = isPalindromo(s, i);//chama a funcao recursivamente ate i < tam/2 ou ate retornar 0
        }
    return resp;
}
int isFim(char *s){//funcao nao funciona no verde
    return (stringlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}

int main(int argc, char *argv[]){
    setlocale(LC_ALL, "pt_BR.UTF-8");
    int fim = 0;
    unsigned char palavra[1000];//unsigned char para no caso do caractere especial nao ir para um valor negativo
    while(fim == 0){
        scanf(" %[^\r\n]", palavra);//pega a linha inteira incluindo os espaços
        if(strcmp(palavra, "FIM") == 0)
          fim = 1;
        else{
            if(isPalindromo(palavra, 0) == 1)
            printf("SIM\n");
            else
            printf("NAO\n");
            }
    }
    return 0;
}
