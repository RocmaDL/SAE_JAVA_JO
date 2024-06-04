package test.java;
public enum CaracteristiqueTest {
    FORCE("force") ,
    AGILITE("agilite") , 
    ENDURANCE("endurance");

    private final String nom;

    private CaracteristiqueTest(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return this.nom;
    }
}
