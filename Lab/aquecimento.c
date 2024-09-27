/*
AEDS 2 lab 01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
#include <stdio.h>
#include <string.h>

int contaMaiuscula(char *s){
        int contador = 0;
        for(int i = 0; i < strlen(s); i++){
            if(s[i] >= 65 && s[i] <= 90){
                contador++;
            }
        }
        return contador;
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