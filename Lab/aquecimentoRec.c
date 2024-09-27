/*
AEDS 2 lab 01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
#include <stdio.h>
#include <string.h>


int contaMaiusculaRec(char *s, int contador, int i){
        if(i == strlen(s)){

        }else{
            if(s[i] >= 65 && s[i] <= 90){
                contador++;
            }
            i++;
            contador = contaMaiusculaRec(s, contador, i);
        }
        return contador;
    }
int contaMaiuscula(char *s){
        return contaMaiusculaRec(s, 0, 0);
    }
int isFim(char *s){
    return (strlen(s) == 3 && s[0] == 'F' && s[1] == 'I' && s[2] == 'M');
}
int main(){
    char entrada[500];
    scanf(" %[^\r\n]", entrada);
    while (!isFim(entrada))
    {
        printf("%d\n", contaMaiuscula(entrada));
        scanf(" %[^\r\n]", entrada);
    }
    return 0;
}