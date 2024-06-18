package main.java.com.cdal.model.exception;

public class EquipeVideException extends ParticipationImpossibleException{
    
    public EquipeVideException() {
        super();
        System.err.println("L'équipe est vide.");
    }
}
