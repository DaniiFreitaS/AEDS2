#include <stdio.h>
#include <stdlib.h>
#include <string.h>
typedef struct // Cria uma STRUCT para armazenar os dados de uma pessoa
{
    char id[80];
    char nome[80];
    char alternateNames[80];
    char house[80];
    char ancestry[80];
    char species[80];
    char patronus[80];
    int hogwartsStaff;
    char hogwartsStudent[80];
    char actorName[80];
    int alive;
    char dateOfBirth[80];
    int yearOfBirth;
    char eyeColour[80];
    char gender[80];
    char hairColour[80];
    int wizard;
} Personagem; // Define o nome do novo tipo criado


int boolParaInt(char *b){
    return (strcmp(b, "VERDADEIRO") == 0);
}
int toInt(char *s){
        int resp = malloc(sizeof (int) * 16);
        for(int i = 0; i < strlen(s); i++){
            resp = resp *10 + ((int)(s[i] - 48));
        }
        return resp;
}
char* lerArquivo(char *s){
        FILE *raw = fopen("/tmp/characters.csv", "r");
        char *resp = malloc(sizeof (char) * 1000);
        char str[405][500];
        for(int i = 0; i < 405; i++){
            fscanf(raw, " %[^\r\n]", str[i]);
            //printf(" %s\n", str[i]);
        }
        fclose(raw);
        
        for(int i = 1; i < 405; i++){           
            if(strstr(str[i], s) != NULL){
                resp = strstr(str[i],s);
                if (strcmp(resp, str[i]) == 0){
                   // printf("%s\n %s\n", s, str[i]);
                    strcpy(resp, str[i]);
                    //printf("%s\n", resp);
                    i+=500;
                }
            }else{
                //printf("%d ", i);
            }
            
            
        }
        return resp;
    }

Personagem leEntrada(char *str, Personagem P){
    char* token;
    // Divide a string usando a vírgula como delimitador
    token = strtok(str, ";");
    strcpy(P.id, token);
    token = strtok(NULL, ";");
    strcpy(P.nome, token);
    token = strtok(NULL, ";");
    strcpy(P.alternateNames, token);
    token = strtok(NULL, ";");
    strcpy(P.house, token);
    token = strtok(NULL, ";");      
    strcpy(P.ancestry, token);
    token = strtok(NULL, ";");
    strcpy(P.species, token);
    token = strtok(NULL, ";");
    strcpy(P.patronus, token);
    token = strtok(NULL, ";");
    P.hogwartsStaff = boolParaInt(token);  
    token = strtok(NULL, ";");
    strcpy(P.hogwartsStudent, token);
    token = strtok(NULL, ";");
    strcpy(P.actorName, token);
    token = strtok(NULL, ";");
    P.alive = boolParaInt(token);
    token = strtok(NULL, ";");
    printf("%s\n", token);
    //nao faz nada
    token = strtok(NULL, ";");
    strcpy(P.dateOfBirth, token);
    token = strtok(NULL, ";");
    P.yearOfBirth = toInt(token);
    token = strtok(NULL, ";");
    strcpy(P.eyeColour, token);
    token = strtok(NULL, ";");
    strcpy(P.gender, token);
    token = strtok(NULL, ";");
    strcpy(P.hairColour, token);
    token = strtok(NULL, ";");
    P.wizard = boolParaInt(token);

    return P;
}

void ImprimePersonagem(Personagem P) // declara o parâmetro como uma struct
{
  printf("%s %s %s %s %s %s %s %d %s %s %d %s %d %s %s %s %d\n", P.id, P.nome, P.alternateNames, P.house, P.ancestry, P.species, P.patronus, P.hogwartsStaff,
   P.hogwartsStudent, P.actorName, P.alive, P.dateOfBirth, P.yearOfBirth, P.eyeColour, P.gender, P.hairColour, P.wizard);
}

int main()
{
    char arquivo[500];
    char entrada[500];
    int fim = 0;
    Personagem P;
    while(fim == 0){
        scanf(" %[^\r\n]", entrada);//pega a linha inteira incluindo os espaços
        if(strcmp(entrada, "FIM") == 0)
          fim = 1;
        else{
            strcpy(arquivo,lerArquivo(entrada));
            P = leEntrada(arquivo, P);
            ImprimePersonagem(P);
        }
    }
   return 0;
}