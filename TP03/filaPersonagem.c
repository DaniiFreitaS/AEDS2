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
    if (strstr(b, "VERDADEIRO")){
        return 0;
    }
    return 1;
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
        }else if(str[i] == '['){
            token[j] = '{';
        }else if(str[i] == ']'){
            token[j] = '}';
        }else if(str[i] == 39){
            j--;
        }
        else{
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
    //printf("\nAAAAAAAAAAAAAAAAAAAAAAAAA %s\n", token);
    if(strlen(token) == 1 && token[0] == 68){
        strcpy(P.patronus, "");
    }else{
        strcpy(P.patronus, token);
    }
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    //P.hogwartsStaff = boolParaInt(token) ? "true" : "false";  
    if(boolParaInt(token) == 0){
        strcpy(P.hogwartsStaff, "true");
    }
    else{
        strcpy(P.hogwartsStaff, "false");
    }
    token = strtok(NULL, ";");
    //printf("%s\n", token);
    strcpy(P.hogwartsStudent, token);
    if(boolParaInt(token) == 0){
        strcpy(P.hogwartsStudent, "true");
    }else{
        strcpy(P.hogwartsStudent, "false");
    }
    token = strtok(NULL, ";");
    //printf("UEEEEEEEEEEEEEE    %s\n", token);
    if(strlen(token) == 1 && token[0] == 68){
        strcpy(P.actorName, "");
    }else{
        strcpy(P.actorName, token);
    }

    token = strtok(NULL, ";");
    //printf("%s\n", token);
    //P.alive = boolParaInt(token);
    if(boolParaInt(token) == 0){
        strcpy(P.alive, "true");
    }
    else{
        strcpy(P.alive, "false");
    }
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
    if(boolParaInt(token) == 0){
        strcpy(P.wizard, "true");
    }else{
        strcpy(P.wizard, "false");
    }
    //free(token);
    return P;
}

void ImprimePersonagem(Personagem P) // declara o parâmetro como uma struct
{
  printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n", P.id, P.nome, P.alternateNames, P.house, P.ancestry, P.species, P.patronus, P.hogwartsStaff,
   P.hogwartsStudent, P.actorName, P.alive, P.dateOfBirth, P.yearOfBirth, P.eyeColour, P.gender, P.hairColour, P.wizard);
}
void ImprimePersonagemL(Personagem P) // declara o parâmetro como uma struct
{
  printf("## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s", P.id, P.nome, P.alternateNames, P.house, P.ancestry, P.species, P.patronus, P.hogwartsStaff,
   P.hogwartsStudent, P.actorName, P.alive, P.dateOfBirth, P.yearOfBirth, P.eyeColour, P.gender, P.hairColour, P.wizard);
}
void ImprimeR(Personagem P) // declara o parâmetro como uma struct
{
  printf("(R) %s\n", P.nome);
}


#define MAXTAM    5
#define bool      short
#define true      1
#define false     0

Personagem array[MAXTAM+1];   // Elementos da pilha 
int primeiro;          // Remove do indice "primeiro".
int ultimo;           // Insere no indice "ultimo".
int quantidade;


/**
 * Inicializacoes
 */
void start(){
   primeiro = ultimo = 0;
}

void ImprimeMedia(){
    int media, contador = 1;
    for(int i = 0; i < quantidade;i++){
        media += array[i + primeiro % MAXTAM].yearOfBirth;
        contador++;
    }
    media = media/quantidade;
    printf(">> Year Birthday Average: %d %d \n", media, quantidade);
}

/**
 * Remove um elemento da primeira posicao da fila e movimenta 
 * os demais elementos para o primeiro da mesma.
 * @return resp int elemento a ser removido.
 * @Se a fila estiver vazia.
 */
Personagem remover() {

   //validar remocao
   if (primeiro == ultimo) {
      printf("Erro ao remover!");
      exit(1);
   }
   quantidade--;
   Personagem resp = array[primeiro];
   primeiro = (primeiro + 1) % MAXTAM;
   return resp;
}

/**
 * Insere um elemento na ultima posicao da 
 * @param x int elemento a ser inserido.
 * @Se a fila estiver cheia.
 */
void inserir(Personagem x) {

   //validar insercao
   if (((ultimo + 1) % MAXTAM) == primeiro) {
      remover();
       
   }
   quantidade++;
   array[ultimo] = x;
   ultimo = (ultimo + 1) % MAXTAM;
   ImprimeMedia(ultimo);
}




/**
 * Mostra os array separados por espacos.
 */
void mostrar (){
   int i;
   printf("\n[");

   for(i = primeiro; i != ultimo; i = ((i + 1) % MAXTAM)) {
      printf(" %d", array[i]);
   }

   printf(" ]");
}


/**
 * Retorna um bool indicando se a fila esta vazia
 * @return bool indicando se a fila esta vazia
 */
bool isVazia() {
   return (primeiro == ultimo); 
}

int main(int argc, char const *argv[])
{
    char arquivo[500];
    char entrada[500];
    int fim = 0, op = 0, aux = 0;
    Personagem P;
    while(fim == 0){
        scanf(" %[^\r\n]", entrada);//pega a linha inteira incluindo os espaços
        if(strcmp(entrada, "FIM") == 0)
          fim = 1;
        else{
            strcpy(arquivo,lerArquivo(entrada));
            P = leEntrada(arquivo, P);
            //printf("oii\n");
            //ImprimePersonagem(P);
            inserir(P);
        }
    }
    scanf("%d", &op);
    for(int i = 0; i < op; i++){
            scanf(" %s", entrada);//pega a linha inteira incluindo os espaços
            if(strcmp(entrada, "I") == 0){
                scanf("%s", entrada);
                strcpy(arquivo,lerArquivo(entrada));
                P = leEntrada(arquivo, P);
                inserir(P);
            }else if(strcmp(entrada, "R") == 0){
                P = remover();
                ImprimeR(P);
            }
        }
    //mostrar();
    
   return 0;
}