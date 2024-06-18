package main.java.com.cdal.model.exception;

public class EpreuveInexistanteException extends ElementInexistantException {

    public EpreuveInexistanteException() {
        super();
        System.err.println("L'épreuve n'existe pas.");
    }
}
