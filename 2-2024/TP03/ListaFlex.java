//Daniel Felipe Coelho de Freitas - 859230
import java.io.File;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Lista {
    private String[] array;
    private int n;
 
 
    /**
     * Construtor da classe.
     */
    public Lista () {
       this(6);
    }
 
 
    /**
     * Construtor da classe.
     * @param tamanho Tamanho da lista.
     */
    public Lista (int tamanho){
       array = new String[tamanho];
       n = 0;
    }
 
 
    /**
     * Insere um elemento na primeira posicao da lista e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirInicio(String x) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       } 
 
       //levar elementos para o fim do array
       for(int i = n; i > 0; i--){
          array[i] = array[i-1];
       }
 
       array[0] = x;
       n++;
    }
 
 
    /**
     * Insere um elemento na ultima posicao da lista.
     * @param x int elemento a ser inserido.
     * @throws Exception Se a lista estiver cheia.
     */
    public void inserirFim(String x) throws Exception {
 
       //validar insercao
       if(n >= array.length){
          throw new Exception("Erro ao inserir!");
       }
 
       array[n] = x;
       n++;
    }
 
 
    /**
     * Insere um elemento em uma posicao especifica e move os demais
     * elementos para o fim da lista.
     * @param x int elemento a ser inserido.
     * @param pos Posicao de insercao.
     * @throws Exception Se a lista estiver cheia ou a posicao invalida.
     */
    public void inserir(String x, int pos) throws Exception {
 
       //validar insercao
       if(n >= array.length || pos < 0 || pos > n){
          throw new Exception("Erro ao inserir!");
       }
 
       //levar elementos para o fim do array
       for(int i = n; i > pos; i--){
          array[i] = array[i-1];
       }
 
       array[pos] = x;
       n++;
    }
 
 
    /**
     * Remove um elemento da primeira posicao da lista e movimenta 
     * os demais elementos para o inicio da mesma.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public String removerInicio() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       String resp = array[0];
       n--;
 
       for(int i = 0; i < n; i++){
          array[i] = array[i+1];
       }
 
       return resp;
    }
 
 
    /**
     * Remove um elemento da ultima posicao da lista.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia.
     */
    public String removerFim() throws Exception {
 
       //validar remocao
       if (n == 0) {
          throw new Exception("Erro ao remover!");
       }
 
       return array[--n];
    }
 
 
    /**
     * Remove um elemento de uma posicao especifica da lista e 
     * movimenta os demais elementos para o inicio da mesma.
     * @param pos Posicao de remocao.
     * @return resp int elemento a ser removido.
     * @throws Exception Se a lista estiver vazia ou a posicao for invalida.
     */
    public String remover(int pos) throws Exception {
 
       //validar remocao
       if (n == 0 || pos < 0 || pos >= n) {
          throw new Exception("Erro ao remover!");
       }
 
       String resp = array[pos];
       n--;
 
       for(int i = pos; i < n; i++){
          array[i] = array[i+1];
       }
 
       return resp;
    }
 
 
    /**
     * Mostra os elementos da lista separados por espacos.
     */
    public void mostrar (){
       System.out.print("[");
       for(int i = 0; i < n; i++){
            System.out.print("'");
            System.out.print(array[i]);
            System.out.print("'");
          if(n > 1 && i < n-1){
            System.out.print(", ");
          }
       }
       System.out.print("]");
    }
 
 
    /**
     * Procura um elemento e retorna se ele existe.
     * @param x int elemento a ser pesquisado.
     * @return <code>true</code> se o array existir,
     * <code>false</code> em caso contrario.
     */
    public boolean pesquisar(String x) {
       boolean retorno = false;
       for (int i = 0; i < n && retorno == false; i++) {
          retorno = (array[i] == x);
       }
       return retorno;
    }
 }
 class Pokemon {
    //id,generation,name,description,type1,type2,abilities,weight_kg,height_m,capture_rate,is_legendary,capture_date
    private int id;
    private int generation;
    private String name;
    private String description;
    private Lista type;
    private Lista abilities;
    private double weight;
    private double height;
    private int capture_rate;
    private boolean is_legendary;
    private LocalDate captureDate;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getGeneration() {
        return generation;
    }
    public void setGeneration(int generation) {
        this.generation = generation;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Lista getType() {
        return type;
    }
    public void setType(Lista type) {
        this.type = type;
    }
    public Lista getAbilities() {
        return abilities;
    }
    public void setAbilities(Lista abilities) {
        this.abilities = abilities;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public int getCapture_rate() {
        return capture_rate;
    }
    public void setCapture_rate(int capture_rate) {
        this.capture_rate = capture_rate;
    }
    public boolean getIs_legendary() {
        return is_legendary;
    }
    public void setIs_legendary(boolean is_legendary) {
        this.is_legendary = is_legendary;
    }
    public LocalDate getCaptureDate() {
        return captureDate;
    }
    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }
    public Pokemon(int id, int generation, String name, String description, Lista type, Lista abilities,
            double weight, double height, int capture_rate, boolean is_legendary, LocalDate captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.type = type;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.capture_rate = capture_rate;
        this.is_legendary = is_legendary;
        this.captureDate = captureDate;
    }
    public Pokemon(){
        //inicia vazio, sera usado o metodo ler
    }
    public static Pokemon ler(String s){
        String[] saida = new String[12];
        Pokemon p = new Pokemon();
        int sinal = 0;
        int sentinelaLista = 0;
        int i = 0;
        for(int k = 0; k < 12; k++){
            saida[k] = "";
        }
        while(i < s.length()){
            if(s.charAt(i) == '['){
                sentinelaLista++;
                i++;
            }else if(s.charAt(i) == ']'){
                sentinelaLista++;
                i++;
            }
            if(s.charAt(i)== ','){
                if(sentinelaLista == 1){
                    saida[sinal] += s.charAt(i);
                    i++;
                }else{
                    sinal++;
                    i++;
                }
            }else if(s.charAt(i) == 39){
                i++;
            }else if(s.charAt(i) == '"'){
                i++;
            }else{
                saida[sinal] += s.charAt(i);
                i++;
            }
        }
        //id,generation,name,description,type1,type2,abilities,weight_kg,height_m,capture_rate,is_legendary,capture_date
        Lista abilities;
        Lista type; 
        try {
            
            p.setId(toInt(saida[0]));
            p.setGeneration(toInt(saida[1]));
            p.setName(saida[2]);
            p.setDescription(saida[3]);
            type = new Lista(2);
            type.inserirFim(saida[4]);
            if(saida[5].length() > 2){
                type.inserirFim(saida[5]);
            }
            String[] ab;
            ab =saida[6].split(", ");
            abilities = new Lista(ab.length);
            for(int j = 0; j < ab.length; j++){
                abilities.inserirFim(ab[j]);
            }
            p.setType(type);
            p.setAbilities(abilities);
            Scanner db = new Scanner(saida[7]);
            if(saida[7].length() > 0) {
                p.setWeight(db.nextDouble());
            }else{
                p.setWeight(0);
            }
            db.close();
            db = new Scanner(saida[8]);
            if(saida[8].length() > 0) {
                p.setHeight(db.nextDouble());
            }else{
                p.setHeight(0);
            }
            db.close();
            p.setCapture_rate(toInt(saida[9]));
            p.setIs_legendary(toInt(saida[10]) == 1);
            p.setCaptureDate(LocalDate.parse(saida[11], dataFormat));
        } catch (Exception e) {
            System.out.println("erro");
        }

        return p;
    }
    public Pokemon clone(Pokemon p){
        return new Pokemon(p.getId(), p.getGeneration(), p.getName(), p.getDescription(), p.getType(), p.getAbilities(), p.getWeight(), p.getHeight(), p.getCapture_rate(),
         p.getIs_legendary(), p.getCaptureDate());
    }
    static DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public void imprimir(){
        //id,name,description,type1,type2,abilities,weight_kg,height_m,capture_rate,is_legendary,capture_date
        System.out.print("[#" + id +" -> " + name + ": " + description + " - ");
        type.mostrar();
        System.out.print(" - ");
        abilities.mostrar();
        System.out.println(" - " + weight + "kg - " + height + "m - " + capture_rate + "% - " + booleanToString(is_legendary) + " - " + generation + " gen] - " + captureDate.format(dataFormat));
    }
    public static int toInt(String s){//transforma String para inteiro
        int resp = 0;
        for(int i = 0; i < s.length(); i++){
            resp = resp *10 + ((int)(s.charAt(i) - 48));
        }
        return resp;
    }
    public static String booleanToString(boolean b){
        return b ? "true" : "false";
    }
    static boolean isFIM(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }
    
}

class Celula {
	public Pokemon elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.
    public Celula ant; // Aponta a celula anterior.


	/**
	 * Construtor da classe.
	 */
	public Celula() {
		this(null);
	}

	/**
	 * Construtor da classe.
	 * @param elemento int inserido na celula.
	 */
	public Celula(Pokemon elemento) {
      this.elemento = elemento;
      this.prox = null;
      this.ant = null;
	}
}
public class ListaFlex {
    private Celula primeiro;
    private Celula ultimo;
    
    public ListaFlex(){
        primeiro = ultimo = null;
    }

    public void inserirInicio(Pokemon x){
        if(primeiro == null){
            primeiro = ultimo = new Celula(x);
        }else{
            Celula tmp = new Celula(x);
            tmp.prox = primeiro;
            tmp.prox.ant = tmp;
            primeiro = tmp;
        }
    }
    public void inserirFim(Pokemon x){
        if(ultimo == null){
            primeiro = ultimo = new Celula(x);
        }else{
            Celula tmp = new Celula(x);
            ultimo.prox = tmp;
            ultimo.prox.ant = ultimo;
            ultimo = tmp;
        }
    }
    public Pokemon removerInicio() throws Exception{
        if(primeiro == null){
            throw new Exception("Lista vazia");
        }
        Pokemon resp = primeiro.elemento;
        if(ultimo == primeiro){
            primeiro = ultimo = null;
        }else{
            primeiro = primeiro.prox;
            primeiro.ant = null;

        }
        return resp;
    }
    public Pokemon removerFim() throws Exception{
        if(ultimo == null){
            throw new Exception("Lista vazia");
        }
        Pokemon resp = ultimo.elemento;
        if(ultimo == primeiro){
            primeiro = ultimo = null;
        }else{
            ultimo = ultimo.ant;
            ultimo.prox = null;

        }
        return resp;
    }

    public void mostrar(){
        for(Celula i = primeiro; i != null; i = i.prox){
            i.elemento.imprimir();
        }
    }

    public static int comparacoes = 0;
    public static int movimentacoes = 0;
    public void quicksort() {
        if (primeiro != null && primeiro != ultimo) {
            quicksortRec(primeiro, ultimo);
        }
    }

    private void quicksortRec(Celula esq, Celula dir) {
        if (esq != null && dir != null && esq != dir && esq != dir.prox) {
            Celula pivo = particionar(esq, dir);
            //chamada recursiva
            quicksortRec(esq, pivo.ant);
            quicksortRec(pivo.prox, dir);
        }
    }

    private Celula particionar(Celula esq, Celula dir) {
        Pokemon pivo = dir.elemento; //Escolha do pivô que tbm serve como limite
        Celula i = esq.ant;

        for (Celula j = esq; j != dir; j = j.prox) {
            // Compara o elemento atual com o pivô.
            comparacoes++;
            if (j.elemento.getGeneration() < pivo.getGeneration() ||
                (j.elemento.getGeneration() == pivo.getGeneration() && j.elemento.getName().compareTo(pivo.getName()) < 0)) {
                i = (i == null) ? esq : i.prox; // Avança i.
                //swap
                Pokemon temp = i.elemento;
                i.elemento = j.elemento;
                j.elemento = temp;
                movimentacoes+=3;
            }
        }

        // Troca o pivô
        i = (i == null) ? esq : i.prox;
        Pokemon temp = i.elemento;
        i.elemento = dir.elemento;
        dir.elemento = temp;
        movimentacoes+=3;

        return i; // Retorna a nova posição do pivô.
    }


    public static void main(String[] args) {
        try {
            long inicio = System.currentTimeMillis();
            PrintWriter log = new PrintWriter("858230_quicksort3.txt");
            File csv = new File("/tmp/pokemon.csv");
            Scanner sc = new Scanner(csv);
            Pokemon[] arquivo = new Pokemon[802];
            sc.nextLine();
            for(int i = 0; i < 801; i++){
                arquivo[i] = Pokemon.ler(sc.nextLine());//guarda os pokemons em um vetor para ser usado futuramente
                //arquivo[i].imprimir();
            }
            sc.close();
            sc = new Scanner(System.in);
            String entrada = null;
            int fim = 0;
            entrada = sc.nextLine();
            ListaFlex listaP = new ListaFlex();
            while(fim == 0){
                if(Pokemon.isFIM(entrada)){
                    fim = 1;
                    //sc.close();
                }else{
                     //System.out.println(entrada);
                     //arquivo[toInt(entrada)-1].imprimir();//o proprio indice do vetor é o id-1 do pokemon
                     listaP.inserirFim(arquivo[Pokemon.toInt(entrada)-1]);
                     entrada = sc.nextLine();
                }
            }
            sc.close();
            listaP.quicksort();
            long fimTempo = System.currentTimeMillis();
            log.println("859230\t" + comparacoes + "\t" + movimentacoes + "\t" + (fimTempo - inicio));
            log.close();
            listaP.mostrar();
        } catch (Exception e) {
            System.out.println("erro aqui");
        }
    }
}
