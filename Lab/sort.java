import java.util.Scanner;

public class sort {

    static void modsort(int n, int mod, int[] vetor){
        System.out.println(n +" "+mod);
        for(int i = 0; i < n-1; i++){
            int menor = i;
            for(int j = i+1; j < n; j++){
                if(vetor[menor] % mod > vetor[j] % mod){
                    menor = j;
                }else if(vetor[menor] % mod == vetor[j] % mod){
                    if(vetor[menor]%2 == 0 && vetor[j] %2 == 0){
                        if(vetor[menor] > vetor[j]){
                            menor = j;
                        }
                    }else if(vetor[menor]%2 != 0 && vetor[j] %2 != 0){
                        if(vetor[menor] < vetor[j]){
                            menor = j;
                        }
                    }else if(vetor[menor]%2 != 0 && vetor[j] %2 == 0){
                        //menor = vetor[j];
                    }else if(vetor[menor]%2 == 0 && vetor[j] %2 != 0){
                        menor = j;
                    }
                }
            }
            int temp = vetor[menor];
            vetor[menor] = vetor[i];
            vetor[i] = temp;
        }
        for(int i = 0; i < n; i++){
            System.out.println(vetor[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int entrada1 = sc.nextInt();
        int entrada2 = sc.nextInt();
        while (entrada1 > 0 && entrada2 > 0) {
            int[] vetor = new int[entrada1];
            for(int i = 0; i < entrada1; i++){
                vetor[i] = sc.nextInt();
            }
            modsort(entrada1, entrada2, vetor);
            entrada1 = sc.nextInt();
            entrada2 = sc.nextInt();
        }
        System.out.println("0 0");
        sc.close();
    }
}