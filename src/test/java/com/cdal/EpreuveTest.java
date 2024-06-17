package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.*;

public class EpreuveTest {
    private Epreuve epreuve;

    @BeforeEach
    public void setUp() {
        Sport sport = new Sport("Natation", 1.0, 2.0, 3.0, Unite.TEMPS);
        epreuve = new Epreuve("50m",'M', sport);
    }

    @Test
    public void testGetNomEp() {
        assertEquals("50m", epreuve.getNomEpreuve());
    }

    @Test
    public void testGetSexe() {
        assertEquals('M', epreuve.getSexe());
    }

    @Test
    public void testSetNomEpreuve() {
        assertEquals("50m", epreuve.getNomEpreuve());
    }

    @Test
    public void testSetSexe() {
        epreuve.setSexe('F');
        assertEquals('F', epreuve.getSexe());
    }
    @Test 
    public void testEquals(){
        Sport sport = new Sport("Natation", 1.0, 2.0, 3.0, Unite.TEMPS);
        Epreuve epreuve2 = new Epreuve("50m",'M', sport);
        assertEquals(true,epreuve.equals(epreuve2));
    
    }

    @Test
    public void testHashCode(){
        Sport sport = new Sport("Natation", 1.0, 2.0, 3.0, Unite.TEMPS);
        Epreuve epreuve2 = new Epreuve("50m",'M', sport);
        assertEquals(epreuve2.hashCode(),epreuve.hashCode());


    }

    @Test
    public void testToString(){
        assertEquals("Epreuve [nomEpreuve=50m, sexe=M, sport=Natation]",epreuve.toString());

    }
    @Test 
    public void testSetNomEpreuve(String nomEpreuve){
        epreuve.setNomEpreuve("100m");
        assertEquals("100m",epreuve.getNomEpreuve());
        



    }



}