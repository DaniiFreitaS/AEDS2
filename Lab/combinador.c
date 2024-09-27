#include <stdio.h>
#include <string.h>

void combinaString(char *s1, char *s2){
    int s1tam = strlen(s1);
    int s2tam = strlen(s2);
    int i = 0;
    if(s1tam < s2tam){
        for(i = 0; i < s1tam; i++){
            printf("%c%c", s1[i], s2[i]);
        }
        while (i < s2tam)
        {
            printf("%c", s2[i]);
            i++;
        }
        
    }else{
        for(i = 0; i < s2tam; i++){
            printf("%c%c", s1[i], s2[i]);
        }
        while (i < s1tam)
        {
            printf("%c", s1[i]);
            i++;
        }
    }
    printf("\n");
}

int main(){
    char entrada[500];
    char entrada2[500];
    while (scanf(" %s", entrada) == 1){
        scanf(" %s", entrada2);
        combinaString(entrada, entrada2);
    }
    
    return 0;
}