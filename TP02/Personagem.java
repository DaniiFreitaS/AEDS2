import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

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
    int contador = 0; 

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
        return s.equals("true");
    }
    public int toInt(String s){
        int resp = 0;
        //int decimal = (int)Math.pow(10, (double)s.length());
        for(int i = 0; i < s.length(); i++){
            resp = resp *10 + ((int)(s.charAt(i) - 48));
        }
        return resp;
    }
    public String lerArquivo(String s){
        Arq.openRead("characters.csv");
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
        setHogwartsStudent(entrada[8]);
        setActorName(entrada[9]);
        setAlive(toBoolean(entrada[10]));
        setDateOfBirth(LocalDate.parse(entrada[12], dataFormat));
        setYearOfBirth(toInt(entrada[13]));
        setEyeColour(entrada[14]);
        setGender(entrada[15]);
        setHairColour(entrada[16]);
        setWizard(toBoolean(entrada[17]));
        Arq.close();
    }
    public void imprimir(){
        System.out.println("[" + id +" ## " + name +" ## " + Arrays.toString(alternateNames) +" ## " + house +" ## " + ancestry +" ## " + species +" ## " 
        + patronus +" ## " + hogwartsStaff +" ## " + hogwartsStudent +" ## " + actorName +" ## " + alive +" ## " + dateOfBirth.format(dataFormat) +" ## " 
        + yearOfBirth +" ## " + eyeColour +" ## " + gender +" ## " + hairColour +" ## " + wizard + "]");
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

    public static void main(String[] args) {
        int fim = 0;
        String entrada = "";
        while (fim == 0) {
            entrada = MyIO.readLine();
            if(isFIM(entrada))//se a entrada for fim, sai do loop e termina o programa
            fim = 1;
            else
            Personagem p = new Personagem(entrada);
            p.imprimir();
        }
        
        
    }
}