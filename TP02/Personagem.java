import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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

    public Personagem(){
        ler();
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
            resp += ((int)(s.charAt(i) - 48))*((int)Math.pow(10, (double)s.length()));
        }
        return resp;
    }
    public void ler(){
        Arq.openRead("characters.csv");
        String raw = Arq.readLine();
        raw = Arq.readLine();
        String entrada[] = raw.split(";");
        entrada[2] = entrada[2].replace("[", "");
        entrada[2] = entrada[2].replace("]", "");
        entrada[2] = entrada[2].replaceAll("'", "");
        entrada[2] = entrada[2].replaceAll(", ", ",");

    
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
        setDateOfBirth(LocalDate.parse(entrada[12], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        setYearOfBirth(toInt(entrada[13]));
        setEyeColour(entrada[14]);
        setGender(entrada[15]);
        setHairColour(entrada[16]);
        setWizard(toBoolean(entrada[17]));
        Arq.close();
    }
    public void imprimir(){
        System.out.println("[" + id +" ## " + name +" ## " + alternateNames +" ## " + house +" ## " + ancestry +" ## " + species +" ## " 
        + patronus +" ## " + hogwartsStaff +" ## " + hogwartsStudent +" ## " + actorName +" ## " + alive +" ## " + dateOfBirth +" ## " 
        + yearOfBirth +" ## " + eyeColour +" ## " + gender +" ## " + hairColour +" ## " + wizard + "]");
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


    public static void main(String[] args) {
        Personagem teste = new Personagem();
        teste.imprimir();
    }
}