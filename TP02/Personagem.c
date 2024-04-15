#include <stdio.h>
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
  printf("%s %s %s %s %s %s %s %d %s %s %d %s %d %s %s %s %d", P.id, P.nome, P.alternateNames, P.house, P.ancestry, P.species, P.patronus, P.hogwartsStaff,
   P.hogwartsStudent, P.actorName, P.alive, P.dateOfBirth, P.yearOfBirth, P.eyeColour, P.gender, P.hairColour, P.wizard);
}

void leEntrada(FILE *raw, Personagem P){
    char* token;
    char str[500];
    fscanf(raw, " %[^\r\n]", str);
    fscanf(raw, " %[^\r\n]", str);
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
}

int main()
{
    FILE *arquivo = fopen("characters.csv", "r");
    Personagem P;
    leEntrada(arquivo, P);
    fclose(arquivo);
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
    ImprimePersonagem(P);
   return 0;
}