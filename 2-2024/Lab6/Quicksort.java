/**
 * Algoritmo de ordenacao Quicksort
 * @author Max do Val Machado
 * @version 3 08/2020
 */
import java.util.*;
class Quicksort extends Geracao {

	/**
	 * Construtor.
	 */
   public Quicksort(){
      super();
   }


	/**
	 * Construtor.
	 * @param int tamanho do array de numeros inteiros.
	 */
   public Quicksort(int tamanho){
      super(tamanho);
   }


	/**
	 * Algoritmo de ordenacao Quicksort.
	 */
   @Override
   public void sort() {
      //quicksort(0, n-1);
       quicksortFirstPivot(0, n-1);
       quicksortLastPivot(0, n-1);
       quicksortRandomPivot(0, n-1);
       quicksortMedianOfThree(0, n-1);
   }

	/**
	 * Algoritmo de ordenacao Quicksort.
    * @param int esq inicio do array a ser ordenado
    * @param int dir fim do array a ser ordenado
	 */
    private void quicksort(int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[(dir+esq)/2];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }
    private void quicksortFirstPivot(int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[0];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }
    private void quicksortLastPivot(int esq, int dir) {
        int i = esq, j = dir;
        int pivo = array[n-1];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }
    private void quicksortRandomPivot(int esq, int dir) {
        int i = esq, j = dir;
        Random rand = new Random();
        int pivo = array[Math.abs(rand.nextInt()) % n];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }
    private void quicksortMedianOfThree(int esq, int dir) {
        int i = esq, j = dir;
        int meio = (dir+esq)/2;
        if(esq < meio){
            swap(esq, meio);
        }
        if(esq < dir){
            swap(esq, dir);
        }
        if(meio < dir){
            swap(meio, dir);
        }
        int pivo = array[meio];
        while (i <= j) {
            while (array[i] < pivo) i++;
            while (array[j] > pivo) j--;
            if (i <= j) {
                swap(i, j);
                i++;
                j--;
            }
        }
        if (esq < j)  quicksort(esq, j);
        if (i < dir)  quicksort(i, dir);
    }
    
}