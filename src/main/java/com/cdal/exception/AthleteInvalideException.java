package main.java.com.cdal.exception;

public class AthleteInvalideException extends ParticipationImpossibleException {

    public AthleteInvalideException() {
        super();
        System.err.println("L'athlète ne peut pas participer à cette épreuve, le sexe ne correspond pas.");
    }
}
