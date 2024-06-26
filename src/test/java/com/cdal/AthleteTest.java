package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.*;
import main.java.com.cdal.model.Caracteristique;
import main.java.com.cdal.model.Epreuve;
import main.java.com.cdal.model.Sport;
import main.java.com.cdal.model.Unite;

public class AthleteTest {
    private Athlete athlete;

    @BeforeEach
    public void setUp() {
        athlete = new Athlete("Doe", "John", 'M', 1.0, 2.0, 3.0);
    }

    @Test
    public void testGetNomAt() {
        assertEquals("Doe", athlete.getNomAt());
    }

    @Test
    public void testGetPrenomAt() {
        assertEquals("John", athlete.getPrenomAt());
    }

    @Test
    public void testGetSexe() {
        assertEquals('M', athlete.getSexe());
    }

    @Test
    public void testGetForce() {
        assertEquals(1.0, athlete.getForce());
    }

    @Test
    public void testGetAgilite() {
        assertEquals(2.0, athlete.getAgilite());
    }

    @Test
    public void testGetEndurance() {
        assertEquals(3.0, athlete.getEndurance());
    }

    @Test
    public void testSetNomAt() {
        athlete.setNomAt("Smith");
        assertEquals("Smith", athlete.getNomAt());
    }

    @Test
    public void testSetPrenomAt() {
        athlete.setPrenomAt("Jane");
        assertEquals("Jane", athlete.getPrenomAt());
    }

    @Test
    public void testSetSexe() {
        athlete.setSexe('F');
        assertEquals('F', athlete.getSexe());
    }

    @Test
    public void testSetForce() {
        athlete.setForce(4.0);
        assertEquals(4.0, athlete.getForce());
    }

    @Test
    public void testSetAgilite() {
        athlete.setAgilite(5.0);
        assertEquals(5.0, athlete.getAgilite());
    }

    @Test
    public void testSetEndurance() {
        athlete.setEndurance(6.0);
        assertEquals(6.0, athlete.getEndurance());
    }

    @Test
    public void testParticiper() {
        Sport sport = new Sport("Natation", 1.0, 2.0, 3.0, Unite.TEMPS);
        Epreuve epreuve = new Epreuve("50m", 9, 'M', sport);
        Map<Caracteristique, Double> lesCoeffs = epreuve.getSport().getCoefficient();
        double result = athlete.participer(epreuve);
        assertEquals((lesCoeffs.get(Caracteristique.FORCE) * athlete.getForce() +
        lesCoeffs.get(Caracteristique.AGILITE) * athlete.getAgilite()
        + lesCoeffs.get(Caracteristique.ENDURANCE) * athlete.getEndurance()) /
        (lesCoeffs.get(Caracteristique.FORCE) + lesCoeffs.get(Caracteristique.AGILITE)
                + lesCoeffs.get(Caracteristique.ENDURANCE)) *10 ,result);
    }

    

 

}
