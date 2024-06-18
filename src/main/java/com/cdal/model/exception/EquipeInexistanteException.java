package main.java.com.cdal.model.exception;

public class EquipeInexistanteException extends ElementInexistantException {

    public EquipeInexistanteException() {
        super();
        System.err.println("L'équipe n'existe pas.");
    }
}
