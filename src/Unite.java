public enum Unite {

    TEMPS("temps") ,
    BUT("but") ,
    TOUCHE("touches"),
    POINT("point") ;

    private final String nom;


    private Unite(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return this.nom;
    }
}