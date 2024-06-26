package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.*;
import main.java.com.cdal.model.Equipe;
import main.java.com.cdal.model.Pays;

public class PaysTest {
    private Pays pays = new Pays("France");

    @BeforeEach
    public void setUp() {

        Athlete a1 = new Athlete("Alan", "Berg", 'M', 2.0, 3.0, 2.0);
        Athlete a2 = new Athlete("Saphira", "Jane", 'F', 2.0, 3.0, 2.0);
        Athlete a3 = new Athlete("John", "Doe", 'M', 2.0, 3.0, 2.0);
        Athlete a4 = new Athlete("Jane", "Doe", 'F', 2.0, 3.0, 2.0);
        Athlete a5 = new Athlete("Alycia", "Bergot", 'F', 2.0, 3.0, 2.0);
        Athlete a6 = new Athlete("Saphira", "Jane", 'F', 2.0, 3.0, 2.0);

        Equipe e1 = new Equipe("e1", pays);
        e1.ajouterMembre(a1);
        e1.ajouterMembre(a2);
        e1.ajouterMembre(a3);
        Equipe e2 = new Equipe("e2", pays);
        e2.ajouterMembre(a4);
        e2.ajouterMembre(a5);
        e2.ajouterMembre(a6);

        pays.enregistrerEquipe(e1);
        pays.enregistrerEquipe(e2);
        pays.enregistrerAthlete(a1);
        pays.enregistrerAthlete(a2);
        pays.enregistrerAthlete(a3);
        pays.enregistrerAthlete(a4);

    }

    @Test
    public void testEnregistrerEquipe() {
        Equipe e3 = new Equipe("e3", pays);
        pays.enregistrerEquipe(e3);
        assertEquals(3, pays.getLesEquipes().size());
    }

    @Test
    public void testEnregistrerAthlete() {
        Athlete a7 = new Athlete("Aliba", "Berg", 'M', 2.0, 3.0, 2.0);
        pays.enregistrerAthlete(a7);
        assertEquals(5, pays.getLesAthletes().size());
    }

    @Test
    public void testSupprimerEquipe() {
        Equipe e3 = new Equipe("e3", pays);
        pays.supprimerEquipe(e3);
        assertEquals(2, pays.getLesEquipes().size());
    }

    @Test
    public void testSupprimerAthlete() {
        Athlete a1 = new Athlete("Alan", "Berg", 'M', 2.0, 3.0, 2.0);
        pays.supprimerAthlete(a1);
        assertEquals(3, pays.getLesAthletes().size());
    }


    @Test
    public void testGetNom() {
        assertEquals("France", pays.getNom());
    }

    @Test
    public void testSetNom() {
        pays.setNom("Allemagne");
        assertEquals("Allemagne", pays.getNom());
    }

    @Test
    public void testNombreAthletes() {
        assertEquals(4, pays.nombreAthletes());

    }
}
