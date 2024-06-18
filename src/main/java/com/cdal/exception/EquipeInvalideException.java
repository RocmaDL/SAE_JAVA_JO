package main.java.com.cdal.exception;

public class EquipeInvalideException extends ParticipationImpossibleException {

    public EquipeInvalideException() {
        super();
        System.err.println(
                "Le nombre de participants, le sexe d'un participant ou les caractéristiques d'un participant ne correspondent pas à l'épreuve.");
    }

}
