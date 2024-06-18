package main.java.com.cdal.model.exception;

public class PaysInexistantException extends ElementInexistantException {

    public PaysInexistantException() {
        super();
        System.err.println("Le pays n'existe pas.");
    }
}
