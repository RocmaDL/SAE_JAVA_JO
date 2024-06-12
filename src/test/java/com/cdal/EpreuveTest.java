package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


import main.java.com.cdal.*;

public class EpreuveTest{
    private Epreuve epreuve;

    @BeforeEach
    public void setUp() {
        Sport sport = new Sport("Natation", 1.0, 2.0, 3.0, "s");
        epreuve = new Epreuve("50m",9,'M', sport);
    }

    @Test
    public void testGetNomEp() {
        assertEquals("Course", epreuve.getNomEpreuve());
    }

    @Test
    public void testGetSexe() {
        assertEquals('M', epreuve.getSexe());
    }

   
    @Test
    public void testSetNomEpreuve(){
        assertEquals("50m", epreuve.getNomEpreuve());
    }
    @Test 
    public void testsetScoreMax(){
        assertEquals(9, epreuve.getScoreMax());
    }
    @Test
    public void testSetSexe(){
        epreuve.setSexe('F');
        assertEquals('F', epreuve.getSexe());
    }
    @Test
    public void testGetScoreMax() {
        assertEquals(9, epreuve.getScoreMax());
    }

    @Test
    public void testSetScoreMax() {
        epreuve.setScoreMax(10);
        assertEquals(10, epreuve.getScoreMax());
    }
 

}