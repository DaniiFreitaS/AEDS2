/*
AEDS 2 TP01
Daniel Felipe Coelho de Freitas
matricula 859230
*/
#include <stdio.h>
void escreveArquivo(int n, char *nomeArquivo){
        FILE *arquivo;
        double numero = 0;
        arquivo = fopen(nomeArquivo, "w");//cria o arquivo para escrita, se ja existir um arquivo com o nome ele limpa o arquivo
        for(int i = 0; i < n; i++){
            scanf("%lf", &numero);//le o numero para escrever no arquivo
            fprintf(arquivo, "%g\n",numero);//escreve o numero no arquivo
        }
        fclose(arquivo);//fecha o arquivo
       
    }
void leArquivo(FILE *arquivo){
        double valor;
        fscanf(arquivo, "%lf", &valor);//le o valor
        if(!feof(arquivo)){
            leArquivo(arquivo);//chama recursivamente a funcao ate chegar o fim do arquivo e fazer o print do ultimo ao primeiro
            printf("%g\n",valor);//%g faz o print do valor em inteiro ou decimal sem os zeros a mais
        }
        
    }
int main(int argc, char const *argv[]){
    int num;
    char saida[10] = "saida.txt";
    scanf("%d", &num);//le a quantidade de numeros a ser escritos no arquivo
    escreveArquivo(num, saida);
    FILE *arquivo;
    arquivo = fopen(saida, "r");//abre o arquivo para leitura
    leArquivo(arquivo);
    fclose(arquivo);//fecha o arquivo
    return 0;
}
