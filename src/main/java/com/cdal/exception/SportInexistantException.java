package main.java.com.cdal.exception;

public class SportInexistantException extends ElementInexistantException {

    public SportInexistantException() {
        super();
        System.err.println("Le sport n'existe pas.");
    }
}
