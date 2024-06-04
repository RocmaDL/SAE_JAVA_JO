public enum UniteTest {

    TEMPS("temps") ,
    BUT("but") ,
    TOUCHE("touches"),
    POINT("point") ;

    private final String nom;


    private UniteTest(String nom){
        this.nom=nom;
    }

    public String getNom(){
        return this.nom;
    }
}