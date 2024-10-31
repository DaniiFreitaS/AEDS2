//Daniel Felipe Coelho de Freitas - 859230
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <string.h>
/**
 * Lista estatica usando struct
 * adaptada da Lista estatica do Max
 */

#define bool short
#define true 1
#define false 0

// struct Lista
typedef struct
{
    char **array; // Elementos da lista (strings)
    int n;        // Quantidade de elementos na lista
    int tamanho;  // Capacidade atual da lista
} Lista;

/**
 * Inicializa a lista com capacidade inicial
 * @param l Lista* ponteiro para a lista.
 * @param capacidade Capacidade inicial da lista.
 */
void start(Lista *l, int capacidade)
{
    l->n = 0;
    l->tamanho = capacidade;
    l->array = (char **)malloc(l->tamanho * sizeof(char *)); // Aloca dinamicamente o array
}

/**
 * Insere uma string na primeira posição da lista
 * @param l Lista* ponteiro para a lista.
 * @param x char* string a ser inserida.
 */
void inserirInicio(Lista *l, char *x)
{
    int i;

    // Validar inserção
    if (l->n >= l->tamanho)
    {
        printf("Erro ao inserir! Lista cheia.\n");
        exit(1);
    }

    // Levar elementos para o fim do array
    for (i = l->n; i > 0; i--)
    {
        l->array[i] = l->array[i - 1];
    }

    l->array[0] = strdup(x); // Copiar a string
    l->n++;
}

/**
 * Insere uma string na última posição da lista
 * @param l Lista* ponteiro para a lista.
 * @param x char* string a ser inserida.
 */
void inserirFim(Lista *l, char *x)
{
    // Validar inserção
    if (l->n >= l->tamanho)
    {
        printf("Erro ao inserir! Lista cheia.\n");
        exit(1);
    }

    l->array[l->n] = strdup(x); // Copiar a string
    l->n++;
}

/**
 * Insere uma string em uma posição específica da lista
 * @param l Lista* ponteiro para a lista.
 * @param x char* string a ser inserida.
 * @param pos Posicao de inserção.
 */
void inserir(Lista *l, char *x, int pos)
{
    int i;

    // Validar inserção
    if (l->n >= l->tamanho || pos < 0 || pos > l->n)
    {
        printf("Erro ao inserir! Posição inválida ou lista cheia.\n");
        exit(1);
    }

    // Levar elementos para o fim do array
    for (i = l->n; i > pos; i--)
    {
        l->array[i] = l->array[i - 1];
    }

    l->array[pos] = strdup(x); // Copiar a string
    l->n++;
}

/**
 * Remove uma string da primeira posição da lista
 * @param l Lista* ponteiro para a lista.
 * @return resp char* string a ser removida.
 */
char *removerInicio(Lista *l)
{
    int i;
    char *resp;

    // Validar remoção
    if (l->n == 0)
    {
        printf("Erro ao remover! Lista vazia.\n");
        exit(1);
    }

    resp = l->array[0];
    l->n--;

    for (i = 0; i < l->n; i++)
    {
        l->array[i] = l->array[i + 1];
    }

    return resp;
}

/**
 * Remove uma string da última posição da lista
 * @param l Lista* ponteiro para a lista.
 * @return resp char* string a ser removida.
 */
char *removerFim(Lista *l)
{
    // Validar remoção
    if (l->n == 0)
    {
        printf("Erro ao remover! Lista vazia.\n");
        exit(1);
    }

    return l->array[--l->n];
}

/**
 * Remove uma string de uma posição específica da lista
 * @param l Lista* ponteiro para a lista.
 * @param pos Posicao de remoção.
 * @return resp char* string a ser removida.
 */
char *remover(Lista *l, int pos)
{
    int i;
    char *resp;

    // Validar remoção
    if (l->n == 0 || pos < 0 || pos >= l->n)
    {
        printf("Erro ao remover! Posição inválida ou lista vazia.\n");
        exit(1);
    }

    resp = l->array[pos];
    l->n--;

    for (i = pos; i < l->n; i++)
    {
        l->array[i] = l->array[i + 1];
    }

    return resp;
}

/**
 * Mostra os elementos da lista separados por espaços
 * @param l Lista* ponteiro para a lista.
 */
void mostrar(Lista *l)
{
    int i;

    printf("[");
    for (i = 0; i < l->n; i++)
    {
        printf("'%s'", l->array[i]);
        if (l->n > 1 && i < l->n - 1)
        {
            printf(", ");
        }
    }
    printf("]");
}

/**
 * Libera a memória alocada pela lista
 * @param l Lista* ponteiro para a lista.
 */
void liberar(Lista *l)
{
    for (int i = 0; i < l->n; i++)
    {
        free(l->array[i]); // Libera cada string alocada
    }
    free(l->array); // Libera o array dinâmico
}

typedef struct Pokemon
{
    int id;
    int generation;
    char name[80];
    char description[200];
    Lista type;
    Lista abilities;
    double weight;
    double height;
    int capture_rate;
    bool is_legendary;
    struct tm captureDate;
} Pokemon;
int toInt(char *s)
{
    int resp = malloc(sizeof(int) * 16);
    resp = 0;
    for (int i = 0; i < strlen(s); i++)
    {
        resp = resp * 10 + ((int)(s[i] - 48));
    }
    return resp;
}
char *booleanToString(bool b)
{
    return b ? "true" : "false";
}
void imprimir(Pokemon p)
{
    printf("[#%d -> %s: %s - ", p.id, p.name, p.description);
    mostrar(&p.type);
    printf(" - ");
    mostrar(&p.abilities);
    printf(" - %0.1fkg - %0.1fm - %d%% - %s - %d gen] - ", p.weight, p.height, p.capture_rate, booleanToString(p.is_legendary), p.generation);
    printf("%02d/%02d/%d\n", p.captureDate.tm_mday, p.captureDate.tm_mon + 1, p.captureDate.tm_year + 1900);
}
Pokemon ler(char *s)
{
    char saida[12][200];
    Pokemon p;
    int sinal = 0;
    int sentinelaLista = 0;
    int i = 0;
    for (int k = 0; k < 12; k++)
    {
        strcpy(saida[k], ""); // Inicializa cada string como vazia
    }
    while (i < strlen(s))
    {
        if (s[i] == '[')
        {
            sentinelaLista++;
            i++;
        }
        else if (s[i] == ']')
        {
            sentinelaLista++;
            i++;
        }
        if (s[i] == ',')
        {
            if (sentinelaLista == 1)//verifica se esta dentro da lista
            {
                strncat(saida[sinal], &s[i], 1);//concatena a string
                i++;
            }
            else
            {
                sinal++;//passa para o proximo item
                i++;
            }
        }
        else if (s[i] == 39)//
        {
            i++;
        }
        else if (s[i] == '"')
        {
            i++;
        }
        else
        {
            strncat(saida[sinal], &s[i], 1);//concatena a string
            i++;
        }
    }
    start(&p.type, 2);
    // id,generation,name,description,type1,type2,abilities,weight_kg,height_m,capture_rate,is_legendary,capture_date
    p.id = toInt(saida[0]);
    p.generation = toInt(saida[1]);
    strcpy(p.name, saida[2]);
    strcpy(p.description, saida[3]);
    inserirFim(&p.type, saida[4]);
    if (strlen(saida[5]) > 2)
    {
        inserirFim(&p.type, saida[5]);
    }
    start(&p.abilities, 20);//inicia a lista abilities
    char *token = strtok(saida[6], ",");
    while (token != NULL)
    {
        //printf("%s\n", token);
        while (*token == ' ') token++;//remover o espaço depois da virgula
        inserirFim(&p.abilities, token);//insere na lista
        token = strtok(NULL, ",");
        
    }
    if (strlen(saida[7]) > 0)
    {
        p.weight = atof(saida[7]);
    }
    else
    {
        p.weight = 0;
    }
    if (strlen(saida[8]) > 0)
    {
        p.height = atof(saida[8]);
    }
    else
    {
        p.height = 0;
    }
    p.capture_rate = toInt(saida[9]);
    p.is_legendary = (toInt(saida[10]) == 1);
    strptime(saida[11], "%d/%m/%Y", &p.captureDate);//data
    //imprimir(p);
    return p;
}

// struct FilaPokemon
typedef struct
{
    Pokemon *array; // Elementos da lista (Pokemon)
    int n;        // Quantidade de elementos na lista
    int tamanho;  // Capacidade atual da lista
    int primeiro;
    int ultimo;
} FilaPokemon;

/**
 * Inicializa a lista com capacidade inicial
 * @param l Lista* ponteiro para a lista.
 * @param capacidade Capacidade inicial da lista.
 */
void startF(FilaPokemon *l, int capacidade)
{
    l->n = 0;
    l->tamanho = capacidade;
    l->array = (Pokemon *)malloc(l->tamanho * sizeof(Pokemon)); // Aloca dinamicamente o array
    l->primeiro = l->ultimo = 0;

}

Pokemon removerF(FilaPokemon *l) {

   //validar remocao
   if (l->primeiro == l->ultimo) {
      printf("Erro ao remover!");
      exit(1);
   }

   Pokemon resp = l->array[l->primeiro];
   l->primeiro = (l->primeiro + 1) % l->tamanho;
   l->n= l->n-1;
   return resp;
}

void inserirF(FilaPokemon *l, Pokemon *x) {

   //validar insercao
   if (((l->ultimo + 1) % l->tamanho) == l->primeiro) {
      removerF(l);
   }
      l->array[l->ultimo] = *x;
      l->ultimo = (l->ultimo + 1) % l->tamanho;
      l->n= l->n+1;

}




/**
 * Mostra os elementos da lista separados por espaços
 * @param l Lista* ponteiro para a lista.
 */
void mostrarP(FilaPokemon *l)
{
    int i;
    int j = 0;

    for (i = l->primeiro; i != l->ultimo; i = ((i+1) % l->tamanho))
    {
        printf("[%d", j);
        printf("] ");
        imprimir(l->array[i]);
        j++;
    }
}

void mostrarMedia(FilaPokemon *l){
    int i;
    double media = 0;
    for (i = l->primeiro; i != l->ultimo; i = ((i+1) % l->tamanho))
    {
        media = media + l->array[i].capture_rate;
        //printf("%d %s\n",l->n, l->array[l->primeiro].name);
    }
    media = media/l->n;
    printf("Média: %.0f\n", media);
}

/**
 * Libera a memória alocada pela lista
 * @param l Lista* ponteiro para a lista.
 */
void liberarF(FilaPokemon *l)
{
    for (int i = 0; i < l->n; i++)
    {
        //free(l->array); // Libera cada string alocada
    }
    //free(l->array); // Libera o array dinâmico
}

int main()
{
    FILE *raw = fopen("/tmp/pokemon.csv", "r");//abre arquivo csv
    char str[802][500];//vetor de string com os valores do csv
    Pokemon pokemon[801];//cria vetor de pokemon para guardar todos
    Pokemon *p[801];//cria vetor de ponteiros para pokemon
    fscanf(raw, " %[^\r\n]", str[0]);//pula a linha 0 do csv
    for (int i = 0; i < 801; i++)
    {
        fscanf(raw, " %[^\r\n]", str[i]);
        // printf(" %s\n", str[i]);
        pokemon[i] = ler(str[i]);//transforma a string do csv em um tipo pokemon
        p[i] = &pokemon[i];
    }
    fclose(raw);
    //leitura do pub.in
    char entrada[10];
    int fim = 0;
    FilaPokemon listaP;
    startF(&listaP, 6);
    while (fim == 0)
    {
        scanf(" %[^\r\n]", entrada); // pega a linha inteira incluindo os espaços
        if (strcmp(entrada, "FIM") == 0)
            fim = 1;
        else
        {
            //imprimir(pokemon[toInt(entrada) - 1]);
            inserirF( &listaP, p[toInt(entrada)-1]);
            mostrarMedia(&listaP);
        }
    }
    scanf(" %d", &fim);
    Pokemon tmp;
    for(int i = 0; i < fim; i++){
        scanf(" %s", entrada);
        if(strcmp(entrada, "I") == 0){
            scanf(" %s", entrada);
            inserirF(&listaP, p[toInt(entrada)-1]);
            mostrarMedia(&listaP);
        }else if(strcmp(entrada, "R") == 0){
            tmp = removerF(&listaP);
            printf("(R) %s\n", tmp.name);
        }
    }
    mostrarP(&listaP);
}