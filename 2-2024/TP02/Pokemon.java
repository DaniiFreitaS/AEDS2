import java.io.File;
import java.util.*;
class Pokemon {
    //id,generation,name,description,type1,type2,abilities,weight_kg,height_m,capture_rate,is_legendary,capture_date
    private int id;
    private int generation;
    private String name;
    private String description;
    private List<String> type;
    private List<String> abilities;
    private double weight;
    private double height;
    private int capture_rate;
    private boolean is_legendary;
    private Date captureDate;

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
    public List<String> getType() {
        return type;
    }
    public void setType(List<String> type) {
        this.type = type;
    }
    public List<String> getAbilities() {
        return abilities;
    }
    public void setAbilities(List<String> abilities) {
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
    public boolean isIs_legendary() {
        return is_legendary;
    }
    public void setIs_legendary(boolean is_legendary) {
        this.is_legendary = is_legendary;
    }
    public Date getCaptureDate() {
        return captureDate;
    }
    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }
    public Pokemon(int id, int generation, String name, String description, List<String> type, List<String> abilities,
            double weight, double height, int capture_rate, boolean is_legendary, Date captureDate) {
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

    }
    public static String[] ler(String s){
        //id,generation,name,description,type1,type2,abilities,weight_kg,height_m,capture_rate,is_legendary,capture_date
        //1,1,Bulbasaur,Seed Pokémon,grass,poison,"['Overgrow', 'Chlorophyll']",6.9,0.7,45,0,05/01/1996
        String[] saida = new String[12];
        int sinal = 0;
        int sentinelaLista = 0;
        int tamanho = 0;
        int i = 0;
        String temp = "";
        for(int k = 0; k < 12; k++){
            saida[k] = "";
        }
        while(i < s.length()){
            temp += s.charAt(i);
            if(s.charAt(i) == '['){
                sentinelaLista++;
                i++;
            }else if(s.charAt(i) == ']'){
                sentinelaLista++;
                i++;
            }
            if(s.charAt(i)== ','){
                //System.out.println(temp);
                if(sentinelaLista == 1){
                    i++;
                }else{
                    sinal++;
                    i++;
                }
            }else{
                saida[sinal] += s.charAt(i);
                i++;
            }
        }
        return saida;
    }
    public static void main(String[] args) {
        try {
            File csv = new File("pokemonT.csv");
            Scanner sc = new Scanner(csv);
            String[] entrada;
            while(sc.hasNext()){
                entrada = ler(sc.nextLine());
                for(int i = 0; i < 12; i++){
                    System.out.println(entrada[i]);
                }
            }
            sc.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
/*
else if (s.charAt(i) == '"'){
                i++;
            }else if (s.charAt(i) == 39){//caractere '
                i++;
            }
 */