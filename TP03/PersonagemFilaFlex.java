import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

class Celula {
	public Personagem elemento; // Elemento inserido na celula.
	public Celula prox; // Aponta a celula prox.


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
	public Celula(Personagem elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}
class Personagem {

    private String id;
    private String name;
    private String[] alternateNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private String hogwartsStudent;
    private String actorName;
    private boolean alive;
    private LocalDate dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizard;

    DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter data(String s){
        DateTimeFormatter dataFormat;
        dataFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        
        if(s.charAt(1) == '-'){
            dataFormat = DateTimeFormatter.ofPattern("d-MM-yyyy");
        }else if(s.charAt(4) == '-'){
            dataFormat = DateTimeFormatter.ofPattern("dd-M-yyyy");
        }
        return dataFormat;
    }

    public Personagem(String id){
        ler(id);
    }
    
    public Personagem(String id, String name, String[] alternateNames, String house, String ancestry, String species,
            String patronus, boolean hogwartsStaff, String hogwartsStudent, String actorName, boolean alive,
            LocalDate dateOfBirth, int yearOfBirth, String eyeColour, String gender, String hairColour, boolean wizard) {
        this.id = id;
        this.name = name;
        this.alternateNames = alternateNames;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth; 
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }
    public boolean toBoolean(String s){
        return s.equals("VERDADEIRO");
    }
    public String booleanToString(boolean b){
        return b ? "true" : "false";
    }
    public int toInt(String s){
        int resp = 0;
        for(int i = 0; i < s.length(); i++){
            resp = resp *10 + ((int)(s.charAt(i) - 48));
        }
        return resp;
    }
    public static int toIntS(String s){
        int resp = 0;
        for(int i = 0; i < s.length(); i++){
            resp = resp *10 + ((int)(s.charAt(i) - 48));
        }
        return resp;
    }
    public String lerArquivo(String s){
        Arq.openRead("/tmp/characters.csv", "UTF-8");
        String resp = "";
        String raw[] = new String[405];
        for(int i = 0; i < 405; i++){
            raw[i] = Arq.readLine();
        }
        Arq.close();
        for(int i = 1; i < 405; i++){
            if (raw[i].contains(s)){
                resp = raw[i];
                i+=500;
            }
        }
        return resp;
    }
    public void ler(String id){
        String raw = lerArquivo(id);
        String entrada[] = raw.split(";");
        //formatacao de string
        entrada[2] = entrada[2].replace("[", "");
        entrada[2] = entrada[2].replace("]", "");
        entrada[2] = entrada[2].replaceAll("'", "");
        entrada[2] = entrada[2].replaceAll(", ", ",");

        entrada[13] = entrada[13].replaceAll(" ", "");

    
        setId(entrada[0]);
        setName(entrada[1]);
        setAlternateNames(entrada[2].split(","));

        setHouse(entrada[3]);
        setAncestry(entrada[4]);
        setSpecies(entrada[5]);
        setPatronus(entrada[6]);
        setHogwartsStaff(toBoolean(entrada[7]));
        setHogwartsStudent(booleanToString(toBoolean(entrada[8])));
        setActorName(entrada[9]);
        setAlive(toBoolean(entrada[10]));
        setDateOfBirth(LocalDate.parse(entrada[12], data(entrada[12])));
        setYearOfBirth(toInt(entrada[13]));
        setEyeColour(entrada[14]);
        setGender(entrada[15]);
        setHairColour(entrada[16]);
        setWizard(toBoolean(entrada[17]));
        //Arq.close();
        
    }
    public void imprimir(){
        System.out.println("[" + id +" ## " + name +" ## " + Arrays.toString(alternateNames).replace("[", "{").replace("]", "}") +" ## " + house +" ## " + ancestry +" ## " + species +" ## " 
        + patronus +" ## " + hogwartsStaff +" ## " + hogwartsStudent +" ## " + actorName +" ## " + alive +" ## " + dateOfBirth.format(dataFormat) +" ## " 
        + yearOfBirth +" ## " + eyeColour +" ## " + gender +" ## " + hairColour +" ## " + wizard + "]");
    }
    public void imprimirL(){
        System.out.print("## " + id +" ## " + name +" ## " + Arrays.toString(alternateNames).replace("[", "{").replace("]", "}") +" ## " + house +" ## " + ancestry +" ## " + species +" ## " 
        + patronus +" ## " + hogwartsStaff +" ## " + hogwartsStudent +" ## " + actorName +" ## " + alive +" ## " + dateOfBirth.format(dataFormat) +" ## " 
        + yearOfBirth +" ## " + eyeColour +" ## " + gender +" ## " + hairColour +" ## " + wizard);
    }
    public void imprimirR(){
        System.out.println("(R) "+name);
    }

    public Personagem clone(Personagem p){
        return new Personagem(p.getId(), p.getName(), p.getAlternateNames(), p.getHouse(), p.getAncestry(), p.getSpecies(), p.getPatronus(), p.getHogwartsStaff(),
         p.getHogwartsStudent(), p.getActorName(),p.getAlive(), p.getDateOfBirth(), p.getYearOfBirth(), p.getEyeColour(), p.getGender(), p.getHairColour(), p.getWizard());
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getAlternateNames() {
        return alternateNames;
    }
    public void setAlternateNames(String[] alternateNames) {
        this.alternateNames = alternateNames;
    }
    public String getHouse() {
        return house;
    }
    public void setHouse(String house) {
        this.house = house;
    }
    public String getAncestry() {
        return ancestry;
    }
    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getPatronus() {
        return patronus;
    }
    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }
    public Boolean getHogwartsStaff() {
        return hogwartsStaff;
    }
    public void setHogwartsStaff(boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }
    public String getHogwartsStudent() {
        return hogwartsStudent;
    }
    public void setHogwartsStudent(String hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }
    public String getActorName() {
        return actorName;
    }
    public void setActorName(String actorName) {
        this.actorName = actorName;
    }
    public Boolean getAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public int getYearOfBirth() {
        return yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
    public String getEyeColour() {
        return eyeColour;
    }
    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getHairColour() {
        return hairColour;
    }
    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }
    public Boolean getWizard() {
        return wizard;
    }
    public void setWizard(boolean wizard) {
        this.wizard = wizard;
    }
    static boolean isFIM(String s){
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
    }

   
}
class Lista {
	private Celula primeiro;
	private Celula ultimo;


	/**
	 * Construtor da classe que cria uma lista sem elementos (somente no cabeca).
	 */
	public Lista() {
		primeiro = new Celula();
		ultimo = primeiro;
	}


	/**
	 * Insere um elemento na primeira posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirInicio(Personagem x) {
		Celula tmp = new Celula(x);
      tmp.prox = primeiro.prox;
		primeiro.prox = tmp;
		if (primeiro == ultimo) {                 
			ultimo = tmp;
		}
      tmp = null;
	}


	/**
	 * Insere um elemento na ultima posicao da lista.
    * @param x int elemento a ser inserido.
	 */
	public void inserirFim(Personagem x) {
		ultimo.prox = new Celula(x);
		ultimo = ultimo.prox;
	}


	/**
	 * Remove um elemento da primeira posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Personagem removerInicio() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		}

      Celula tmp = primeiro;
		primeiro = primeiro.prox;
		Personagem resp = primeiro.elemento;
      tmp.prox = null;
      tmp = null;
		return resp;
	}


	/**
	 * Remove um elemento da ultima posicao da lista.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se a lista nao contiver elementos.
	 */
	public Personagem removerFim() throws Exception {
		if (primeiro == ultimo) {
			throw new Exception("Erro ao remover (vazia)!");
		} 

		// Caminhar ate a penultima celula:
      Celula i;
      for(i = primeiro; i.prox != ultimo; i = i.prox);

      Personagem resp = ultimo.elemento; 
      ultimo = i; 
      i = ultimo.prox = null;
      
		return resp;
	}


	/**
    * Insere um elemento em uma posicao especifica considerando que o 
    * primeiro elemento valido esta na posicao 0.
    * @param x int elemento a ser inserido.
	 * @param pos int posicao da insercao.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
   public void inserir(Personagem x, int pos) throws Exception {

      int tamanho = tamanho();

      if(pos < 0 || pos > tamanho){
			throw new Exception("Erro ao inserir posicao (" + pos + " / tamanho = " + tamanho + ") invalida!");
      } else if (pos == 0){
         inserirInicio(x);
      } else if (pos == tamanho){
         inserirFim(x);
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = new Celula(x);
         tmp.prox = i.prox;
         i.prox = tmp;
         tmp = i = null;
      }
   }


	/**
    * Remove um elemento de uma posicao especifica da lista
    * considerando que o primeiro elemento valido esta na posicao 0.
	 * @param posicao Meio da remocao.
    * @return resp int elemento a ser removido.
	 * @throws Exception Se <code>posicao</code> invalida.
	 */
	public Personagem remover(int pos) throws Exception {
      Personagem resp;
      int tamanho = tamanho();

		if (primeiro == ultimo){
			throw new Exception("Erro ao remover (vazia)!");

      } else if(pos < 0 || pos >= tamanho){
			throw new Exception("Erro ao remover (posicao " + pos + " / " + tamanho + " invalida!");
      } else if (pos == 0){
         resp = removerInicio();
      } else if (pos == tamanho - 1){
         resp = removerFim();
      } else {
		   // Caminhar ate a posicao anterior a insercao
         Celula i = primeiro;
         for(int j = 0; j < pos; j++, i = i.prox);
		
         Celula tmp = i.prox;
         resp = tmp.elemento;
         i.prox = tmp.prox;
         tmp.prox = null;
         i = tmp = null;
      }

		return resp;
	}

	/**
	 * Mostra os elementos da lista separados por espacos.
	 */
	public void mostrar() {
        int j = 0;
		System.out.print("[ ");
		for (Celula i = primeiro.prox; i != null; i = i.prox, j++) {
			System.out.print(j +""+ i.elemento + " ");
		}
		System.out.println("] ");
	}

	/**
	 * Procura um elemento e retorna se ele existe.
	 * @param x Elemento a pesquisar.
	 * @return <code>true</code> se o elemento existir,
	 * <code>false</code> em caso contrario.
	 */
	public boolean pesquisar(Personagem x) {
		boolean resp = false;
		for (Celula i = primeiro.prox; i != null; i = i.prox) {
         if(i.elemento == x){
            resp = true;
            i = ultimo;
         }
		}
		return resp;
	}

	/**
	 * Calcula e retorna o tamanho, em numero de elementos, da lista.
	 * @return resp int tamanho
	 */
   public int tamanho() {
      int tamanho = 0; 
      for(Celula i = primeiro; i != ultimo; i = i.prox, tamanho++);
      return tamanho;
   }
}

public class PersonagemFilaFlex {
    public static void main(String[] args)  throws Exception{
        int fim = 0, op = 0;
        Scanner sc = new Scanner(System.in);
        String entrada = null;
        String tmp = null;
        Personagem p = null;
        Lista persona = new Lista();
        String raw[] = null;
        while(fim == 0) {
            entrada = sc.nextLine();
            if(Personagem.isFIM(entrada)){//se a entrada for fim, sai do loop e termina o programa
                fim = 1;
                //sc.close();
            }else{
                p = new Personagem(entrada);
                //p.imprimir();
                persona.inserirFim(p);
            }
        }
        op = sc.nextInt();
        for(int i = 0; i <= op; i++){
            entrada = sc.nextLine();
            raw = entrada.split(" ");
            if(raw[0].equals("II")){
                p = new Personagem(raw[1]);
                persona.inserirInicio(p);
            }else if(raw[0].equals("IF")){
                p = new Personagem(raw[1]);
                persona.inserirFim(p);
            }else if(raw[0].equals("I*")){
                p = new Personagem(raw[2]);
                persona.inserir(p, Personagem.toIntS(raw[1]));
            }else if(raw[0].equals("R*")){
                p = persona.remover(Personagem.toIntS(raw[1]));
                p.imprimirR();
            }else if(raw[0].equals("RI")){
                p = persona.removerInicio();
                p.imprimirR();
            }else if(raw[0].equals("RF")){
                p = persona.removerFim();
                p.imprimirR();
            }
        }
        persona.mostrar();
        sc.close();
    }
}
