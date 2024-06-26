package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.*;
import main.java.com.cdal.model.Epreuve;
import main.java.com.cdal.model.Sport;
import main.java.com.cdal.model.Unite;

public class SportTest {
    private Sport sport;

    @BeforeEach
    public void setUp() {
        sport = new Sport("Natation", 1.0, 2.0, 3.0, Unite.TEMPS);
    }

    @Test
    public void testGetNom() {
        assertEquals("Natation", sport.getNom());
    }

    //@Test
    //public void testGetCoefficient() {
    //    Map<Caracteristique,Double> map = sport.getCoefficient();
    //    assertEquals(1.0, map.get(Caracteristique.FORCE));
    //    assertEquals(2.0, map.get(Caracteristique.AGILITE));
    //    assertEquals(3.0, map.get(Caracteristique.ENDURANCE));
    //}

    @Test
    public void testSetNom() {
        sport.setNom("Handball");
        assertEquals("Handball", sport.getNom());
    }

    // @Test
    // public void testSetCoefficient() {
    // sport.setCoefficient(null); // !!!!!!!A changer
    // assertEquals(4.0, sport.getCoefficient());
    // assertEquals(5.0, sport.getCoefficient());
    // assertEquals(6.0, sport.getCoefficient());
    // }
    @Test
    public void testEnregistrerEpreuve() {
        List<Epreuve> listeEpreuves = new ArrayList<>();
        Epreuve epreuve = new Epreuve("50m", 9, 'M', sport);
        Epreuve epreuve1 = new Epreuve("100m", 9, 'F', sport);
        // listeEpreuves.enregistrerEpreuve();
        // epreuve1.enregistrerEpreuve();
        // assertEquals(listeEpreuves.get(0),epreuve);
        // assertEquals(listeEpreuves.get(1),epreuve1);

    }

    @Test
    public void testSupprimerEpreuve() {
        List<Epreuve> listeEpreuves = new ArrayList<>();
        Epreuve epreuve = new Epreuve("50m", 9, 'M', sport);
        // epreuve.enregistrerEpreuve();
        // epreuve.supprimerEpreuve();
        // assertEquals(0,listeEpreuves.size());

    }

    @Test
    public void testGetlesEpreuves() {
        List<Epreuve> listeEpreuves = new ArrayList<>();
        Epreuve epreuve = new Epreuve("50m", 9, 'M', sport);
        Epreuve epreuve1 = new Epreuve("100m", 9, 'F', sport);
        // assertEquals((epreuve,epreuve1), listeEpreuves.getlesEpreuves());

    }

}
