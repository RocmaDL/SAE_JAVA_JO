package main.java.com.cdal.exception;

public class ElementInexistantException extends Exception {
    
    public ElementInexistantException() {
        super("L'élément que vous cherchez n'existe pas.");
    }
}
