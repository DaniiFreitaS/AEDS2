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

void ImprimePersonagem(Personagem P) // declara o parâmetro como uma struct
{
  printf("%s %s %s %s %s %s %s %d %s %s %d %s %d %s %s %s %d\n", P.id, P.nome, P.alternateNames, P.house, P.ancestry, P.species, P.patronus, P.hogwartsStaff,
   P.hogwartsStudent, P.actorName, P.alive, P.dateOfBirth, P.yearOfBirth, P.eyeColour, P.gender, P.hairColour, P.wizard);
}

char* lerArquivo(char *s){
        FILE *raw = fopen("characters.csv", "r");
        char *resp = malloc(sizeof (char) * 1000);
        char str[405][500];
        for(int i = 0; i < 405; i++){
            fscanf(raw, " %[^\r\n]", str[i]);
            //printf(" %s\n", str[i]);
        }
        fclose(raw);
        
        for(int i = 1; i < 40; i++){
            
            
            if(strstr(str[i], s) != NULL){
                resp = strstr(str[i],s);
                if (strcmp(resp, str[i]) == 0){
                    printf("%s\n %s\n", s, str[i]);
                    strcpy(resp, str[i]);
                    //printf("%s\n", resp);
                    i+=500;
                }
            }else{
                printf("oiiii");
            }
            
            
        }
        return resp;
    }

Personagem leEntrada(char *str, Personagem P){
    char* token;
    //char str[500];
    //fscanf(raw, " %[^\r\n]", str);

    //printf("%s\n", str);
    //fscanf(raw, " %[^\r\n]", str);
    //printf("%s\n", str);
    // Divide a string usando a vírgula como delimitador
    token = strtok(str, ";");//erro aqui
   // printf("%s\n", token);
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
    P.hogwartsStaff = 0;
    token = strtok(NULL, ";");
    strcpy(P.hogwartsStudent, token);
    token = strtok(NULL, ";");
    strcpy(P.actorName, token);
    token = strtok(NULL, ";");
    P.alive = 1;
    token = strtok(NULL, ";");
    //nao faz nada
    token = strtok(NULL, ";");
    strcpy(P.dateOfBirth, token);
    token = strtok(NULL, ";");
    P.yearOfBirth = 1980;
    token = strtok(NULL, ";");
    strcpy(P.eyeColour, token);
    token = strtok(NULL, ";");
    strcpy(P.gender, token);
    token = strtok(NULL, ";");
    strcpy(P.hairColour, token);
    token = strtok(NULL, ";");
    P.wizard = 1;
    return P;
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
    //scanf(" %[^\r\n]", &entrada);
    //strcpy(arquivo,lerArquivo("9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8"));
    //Personagem P;
    //P = leEntrada(arquivo, P);
    //fclose(arquivo);
    /*
    strcpy(P.id, "9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8");
    strcpy(P.nome, "Harry Potter");
    strcpy(P.alternateNames, "'The Boy Who Lived', 'The Chosen One', 'Undesirable No. 1', 'Potty'");
    strcpy(P.house, "Gryffindor");
    strcpy(P.ancestry, "half-blood");
    strcpy(P.species, "human");
    strcpy(P.patronus, "stag");
    P.hogwartsStaff = 0;
    strcpy(P.hogwartsStudent, "VERDADEIRO");
    strcpy(P.actorName, "Daniel Radcliffe");
    P.alive = 1;
    strcpy(P.dateOfBirth, "31-07-1980");
    P.yearOfBirth = 1980;
    strcpy(P.eyeColour, "green");
    strcpy(P.gender, "male");
    strcpy(P.hairColour, "black");
    P.wizard = 1;
    */
    // chama a função que recebe a struct como parâmetro
    //ImprimePersonagem(P);
   return 0;
}