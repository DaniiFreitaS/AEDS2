#include <stdio.h>
#include <stdlib.h>
#include <err.h>
#include <string.h>
#include <time.h>
#define bool   short
#define true   1
#define false  0

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
    int resp = 0;
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
//Variavel para COMPARACOES
int comparacoes = 0;
// TIPO CELULA ===================================================================
typedef struct Celula {
    Pokemon* elemento;   // Elemento do tipo Pokemon inserido na célula.
    struct Celula* prox; // Aponta para a próxima célula.
} Celula;

Celula* novaCelula(Pokemon *elemento) {
    Celula* nova = (Celula*) malloc(sizeof(Celula));
    nova->elemento = elemento;
    nova->prox = NULL;
    return nova;
}

// LISTA PROPRIAMENTE DITA =======================================================
typedef struct {
    Celula* primeiro; // Ponteiro para a célula sentinela (início).
    Celula* ultimo;   // Ponteiro para a última célula (fim).
} ListaPokemon;

// Inicializa uma lista vazia
void startL(ListaPokemon* lista) {
    lista->primeiro = novaCelula(NULL);
    lista->ultimo = lista->primeiro;
}

// Insere no início da lista
void inserirInicioL(ListaPokemon* lista, Pokemon *x) {
    Celula* tmp = novaCelula(x);
    tmp->prox = lista->primeiro->prox;
    lista->primeiro->prox = tmp;
    if (lista->primeiro == lista->ultimo) {
        lista->ultimo = tmp;
    }
}

// Insere no fim da lista
void inserirFimL(ListaPokemon* lista, Pokemon *x) {
    lista->ultimo->prox = novaCelula(x);
    lista->ultimo = lista->ultimo->prox;
}

// Remove do início da lista
Pokemon* removerInicioL(ListaPokemon* lista) {
    if (lista->primeiro == lista->ultimo) {
        errx(1, "Erro ao remover!");
    }

    Celula* tmp = lista->primeiro;
    lista->primeiro = lista->primeiro->prox;
    Pokemon *resp = lista->primeiro->elemento;
    tmp->prox = NULL;
    free(tmp);
    return resp;
}

// Remove do fim da lista
Pokemon* removerFimL(ListaPokemon* lista) {
    if (lista->primeiro == lista->ultimo) {
        errx(1, "Erro ao remover!");
    }

    Celula* i;
    for (i = lista->primeiro; i->prox != lista->ultimo; i = i->prox);

    Pokemon* resp = lista->ultimo->elemento;
    free(lista->ultimo);
    lista->ultimo = i;
    lista->ultimo->prox = NULL;
    return resp;
}

// Mostra os elementos da lista
void mostrarL(ListaPokemon* lista) {
    int j = 0;
    for (Celula* i = lista->primeiro->prox; i != NULL; i = i->prox) {
        printf("[%d] ", j++);
        imprimir(*i->elemento);
    }
}

// Pesquisa um elemento na lista
bool pesquisarL(ListaPokemon* lista, char *x) {
    bool resp = false;
    int j = 0;
    for (Celula* i = lista->primeiro->prox; i != NULL; i = i->prox, j++) {
        comparacoes++;
        if (strcmp(i->elemento->name, x) == 0) {
            printf("(Posicao: %d) ", j);
            i = lista->ultimo;
            resp = true;
        }
    }
    return resp;
}

// Função de tamanho da lista
int tamanhoL(ListaPokemon* lista) {
    int tamanho = 0;
    for (Celula* i = lista->primeiro; i != lista->ultimo; i = i->prox, tamanho++);
    return tamanho;
}

// Insere em uma posição específica da lista
void inserirL(ListaPokemon* lista, Pokemon* x, int pos) {
    int tam = tamanhoL(lista);

    if (pos < 0 || pos > tam) {
        errx(1, "Erro ao inserir posicao (%d/ tamanho = %d) invalida!", pos, tam);
    } else if (pos == 0) {
        inserirInicioL(lista, x);
    } else if (pos == tam) {
        inserirFimL(lista, x);
    } else {
        Celula* i = lista->primeiro;
        for (int j = 0; j < pos; j++, i = i->prox);

        Celula* tmp = novaCelula(x);
        tmp->prox = i->prox;
        i->prox = tmp;
    }
}

// Remove de uma posição específica da lista
Pokemon* removerL(ListaPokemon* lista, int pos) {
    int tam = tamanhoL(lista);

    if (lista->primeiro == lista->ultimo) {
        errx(1, "Erro ao remover (vazia)!");
    } else if (pos < 0 || pos >= tam) {
        errx(1, "Erro ao remover posicao (%d/ tamanho = %d) invalida!", pos, tam);
    } else if (pos == 0) {
        return removerInicioL(lista);
    } else if (pos == tam - 1) {
        return removerFimL(lista);
    } else {
        Celula* i = lista->primeiro;
        for (int j = 0; j < pos; j++, i = i->prox);

        Celula* tmp = i->prox;
        Pokemon* resp = tmp->elemento;
        i->prox = tmp->prox;
        free(tmp);
        return resp;
    }
}

typedef struct Hash{
    ListaPokemon* elemento[21];
    int tam;
}Hash;

Hash tabela;

void startHash(){
    tabela.tam = 21;//tamanho do hash
    for (int i = 0; i < tabela.tam; i++){
    tabela.elemento[i] = (ListaPokemon*)malloc(sizeof( ListaPokemon));
    startL(tabela.elemento[i]);//inicializar as listas
    }
}

int ASCII(char *s){
    int resp = 0;
    for(int i = 0; i < strlen(s); i++){
        resp+=s[i];
    }
    return resp;
    }
void inserirH(Pokemon* p){
    int pos = ASCII(p->name);
    int mod = tabela.tam;
    pos = pos%tabela.tam;
    inserirFimL(tabela.elemento[pos], p);        
}

void pesquisarH(char *s){
    bool resp = false;
    int pos =ASCII(s) % tabela.tam;
    printf("=> %s: ", s);
    resp = pesquisarL(tabela.elemento[pos], s);
    if(resp){
        printf("SIM\n");
    }else{
        printf("NAO\n");
    }
    
}



int main(int argc, char** argv) {
    FILE *matricula = fopen("859230_hashIndireta.txt", "w");
    FILE *raw = fopen("/tmp/pokemon.csv", "r");
    char str[802][500];
    Pokemon pokemon[801];
    Pokemon *p[801];
    fscanf(raw, " %[^\r\n]", str[0]);
    for (int i = 0; i < 801; i++) {
        fscanf(raw, " %[^\r\n]", str[i]);
        pokemon[i] = ler(str[i]);
        p[i] = &pokemon[i];
    }
    fclose(raw);
    startHash();
    char entrada[10];
    int fim = 0;
    while (fim == 0) {
        scanf(" %[^\r\n]", entrada);
        if (strcmp(entrada, "FIM") == 0) {
            fim = 1;
        } else {
            inserirH(p[toInt(entrada) - 1]);
        }
    }

    fim = 0;
    clock_t ini, final;
    double tempo = 0;
    ini = clock();
    while (fim == 0) {
        scanf(" %[^\r\n]", entrada);
        if (strcmp(entrada, "FIM") == 0) {
            fim = 1;
        } else {
            pesquisarH(entrada);
        }
    }
    final = clock();
    tempo = ((final-ini)/ (double)CLOCKS_PER_SEC);
    fprintf(matricula, "859230\t%fs\t%d", tempo, comparacoes);
    fclose(matricula);

    return 0;
}




