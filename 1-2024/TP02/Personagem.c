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
    char hogwartsStaff[10];
    char hogwartsStudent[80];
    char actorName[80];
    char alive[10];
    char dateOfBirth[80];
    int yearOfBirth;
    char eyeColour[80];
    char gender[80];
    char hairColour[80];
    char wizard[10];
} Personagem; // Define o nome do novo tipo criado


int boolParaInt(char *b){
    return (strcmp(b, "VERDADEIRO") == 0);
}
int toInt(char *s){
        int resp = malloc(sizeof (int) * 16);
        resp = 0;
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
    char* token = malloc(sizeof (char)* (strlen(str)*2));
    for(int i = 0, j = 0; i < strlen(str); i++, j++){
        if(i != strlen(str)-1 && str[i] == ';' && str[i+1] == ';'){
            //printf("%s\n", token);
            token[j] = str[i];
            j++;
            token[j] = 'D';
            //printf("unheeeeeeeeeeeeeeee\n");
        }else{
            token[j] = str[i];
        }
    }
    //printf("%s\n", token);
    // Divide a string usando a vírgula como delimitador
    token = strtok(token, ";");
    //printf("%s\n", token);
    strcpy(P.id, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.nome, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.alternateNames, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.house, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);      
    strcpy(P.ancestry, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.species, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    token[0] == 'D' ? strcpy(P.patronus, ""): strcpy(P.patronus, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    //P.hogwartsStaff = boolParaInt(token) ? "true" : "false";  
    boolParaInt(token) ? strcpy(P.hogwartsStaff, "true") : strcpy(P.hogwartsStaff, "false");
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.hogwartsStudent, token);
    boolParaInt(token) ? strcpy(P.hogwartsStudent, "true") : strcpy(P.hogwartsStudent, "false");
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.actorName, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    //P.alive = boolParaInt(token);
    boolParaInt(token) ? strcpy(P.alive, "true") : strcpy(P.alive, "false");
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    //nao faz nada
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.dateOfBirth, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    P.yearOfBirth = toInt(token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.eyeColour, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.gender, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.hairColour, token);
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    //P.wizard = boolParaInt(token);
    boolParaInt(token) ? strcpy(P.wizard, "true") : strcpy(P.wizard, "false");
    //free(token);
    return P;
}

void ImprimePersonagem(Personagem P) // declara o parâmetro como uma struct
{
  printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n", P.id, P.nome, P.alternateNames, P.house, P.ancestry, P.species, P.patronus, P.hogwartsStaff,
   P.hogwartsStudent, P.actorName, P.alive, P.dateOfBirth, P.yearOfBirth, P.eyeColour, P.gender, P.hairColour, P.wizard);
}

int main(int argc, char const *argv[])
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
            //printf("oii\n");
            ImprimePersonagem(P);
        }
    }
   return 0;
}
//[9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8 ## Harry Potter    ## [The Boy Who Lived, The Chosen One, Undesirable No. 1, Potty] ## Gryffindor ## half-blood ## human ## stag ## false ## VERDADEIRO ## Daniel Radcliffe ## false ## 31-07-1980 ## 1980 ## green ## male ## black ## false]
//[1413e1b3-2903-4a47-a2d5-e8abc5ce8014 ## Seamus Finnigan ## [O Flaherty, Seamus Finnegan]                                 ## Gryffindor ## half-blood ## human ##      ## false ## VERDADEIRO ## Devon Murray     ## false ## 31-12-1926 ## 1960 ## amber ## male ## sandy ## false]
// 1413e1b3-2903-4a47-a2d5-e8abc5ce8014  ;Seamus Finnigan   ; ['O Flaherty', 'Seamus Finnegan']                              ; Gryffindor ;  half-blood  ; human;;FALSO; VERDADEIRO  ; Devon Murray      ;VERDADEIRO;[];31-12-1926;1960;amber;male;sandy;VERDADEIRO
