package main.java.com.cdal.exception;

public class EpreuveInexistanteException extends ElementInexistantException {

    public EpreuveInexistanteException() {
        super();
        System.err.println("L'épreuve n'existe pas.");
    }
}
