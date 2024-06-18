package main.java.com.cdal;

import main.java.com.cdal.exception.*;

/**
 * Interface représentant la capacité de participer à une épreuve.
 * Les classes implémentant cette interface doivent fournir une implémentation
 * de la méthode participer,
 * qui définit comment un participant interagit avec une épreuve donnée.
 * 
 * @see Epreuve La classe Epreuve à laquelle le participant prend part.
 */
public interface Participer {
    /**
     * Méthode pour participer à une épreuve spécifique.
     * Cette méthode doit être implémentée par toute classe concrète désirant
     * participer à une épreuve.
     * Le résultat de la participation est exprimé sous forme d'un double, pouvant
     * représenter un score, un temps, etc.
     * 
     * @param epreuve L'épreuve à laquelle le participant prend part.
     * @return Un double représentant le résultat de la participation à l'épreuve.
     */
    public double participer(Epreuve epreuve) throws ParticipationImpossibleException;

    public Pays getPays();
}