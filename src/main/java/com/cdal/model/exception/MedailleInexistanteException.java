package main.java.com.cdal.model.exception;

public class MedailleInexistanteException extends ElementInexistantException {
    
    public MedailleInexistanteException() {
        super();
        System.err.println("La médaille n'existe pas.");
    }
    
}
