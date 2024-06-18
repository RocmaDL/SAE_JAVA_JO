package main.java.com.cdal.model.exception;

public class AthleteInexistantException extends ElementInexistantException {

    public AthleteInexistantException() {
        super();
        System.err.println("L'athlète n'existe pas.");
    }

}
