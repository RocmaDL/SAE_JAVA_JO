public enum Caracteristique {
    FORCE("force") ,
    AGILITE("agilite") , 
    ENDURANCE("endurance");

    private final String nom;

    private Caracteristique(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return this.nom;
    }
}
