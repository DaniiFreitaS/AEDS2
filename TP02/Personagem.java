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
        setDateOfBirth(LocalDate.parse(entrada[12], data(entrada[12])));
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
        String entrada = MyIO.readLine();
        Personagem p = new Personagem(entrada);
        while(fim == 0) {
            if(isFIM(entrada))//se a entrada for fim, sai do loop e termina o programa
                fim = 1;
            else{
                p = new Personagem(entrada);
                p.imprimir();
                entrada = MyIO.readLine();
            }
        }
        
        
    }
}
/*
 * 9e3f7ce4-b9a7-4244-b709-dae5c1f1d4a8
1413e1b3-2903-4a47-a2d5-e8abc5ce8014
ca3827f0-375a-4891-aaa5-f5e8a5bad225
36bfefd0-e0bb-4d11-be98-d1ef6117a77a
20354d7a-e4fe-47af-8ff6-187bca92f3f9
57fe29d4-312a-4711-bd9a-c320253d9176
b415c867-1cff-455e-b194-748662ac2cca
5a4c95db-947d-4914-a631-41e8d466328e
861c4cde-2f0f-4796-8d8f-9492e74b2573
2cfd2d4b-5d1e-4dc5-8837-37a97c7e2f2f
41cd0bbe-a943-431b-9bde-bb2cad3491a1
2a0615de-8aa4-41e7-9504-dd875f5f3f01
11b5ca88-64ad-41a4-9f36-317b66c290af
eaea5eb3-48a3-41c6-9ea5-c695299bab16
0d8ea37f-35c4-4c7d-9dd2-8ccd96b0a2b3
b0620914-858d-46fc-8e6d-033c565e138b
6b59be3f-e527-422d-959d-79fcdb3b24eb
fed624df-56d9-495e-9ad4-ea77000957e8
d58e7249-19d1-40bd-a43f-1da0497fe8aa
3a0fe4df-2e40-4541-8d7f-13586f0b9294
6afb1960-febd-418d-b604-e50c1b59459b
efa802c8-ae18-4ae1-a524-49df21d05939
933787c2-51e3-4eac-8a85-ab332cac0456
94c993f6-a443-4408-b908-6e78e223e8ac
00434cd3-fcc7-44c7-8f98-7368415b4206
7614cf6e-689e-47ac-a976-b1e9997637e9
d59691a4-f830-4eb0-a819-a0fb00b7e80f
FIM
 */
