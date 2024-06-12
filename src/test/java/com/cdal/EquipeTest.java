package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.*;



public class EquipeTest {
    private Equipe equipe;

    @BeforeEach
    public void setUp(){
        Pays lePays = new Pays("France");
        Athlete a1 = new Athlete("Alan","Berg" , 'M', 2.0, 3.0, 2.0);
        Athlete a2 = new Athlete("Saphira","Jane" , 'F', 2.0, 3.0, 2.0);
        Athlete a3 = new Athlete("John","Doe" , 'M', 2.0, 3.0, 2.0);
        Athlete a4 = new Athlete("Jane","Doe" , 'F', 2.0, 3.0, 2.0);
        Athlete a5 = new Athlete("Alycia","Bergot" , 'F', 2.0, 3.0, 2.0);
        Athlete a6 = new Athlete("Saphira","Jane" , 'F', 2.0, 3.0, 2.0);

        List<Athlete> lesAthletes = new ArrayList<>();
        lesAthletes.add(a1);
        lesAthletes.add(a2);
        lesAthletes.add(a3);
        lesAthletes.add(a4);
        lesAthletes.add(a5);
        lesAthletes.add(a6);

        equipe = new Equipe("e1", lePays, lesAthletes);

    }
    @Test
    public void testGetNomEquipe() {
        assertEquals("e1", equipe.getNomEq());
    }
    @Test
    public void testGetPays() {
        Pays lePays = new Pays("France");
        assertEquals(lePays, equipe.getLePays());
    }
    @Test
    public void testGetLesAthletes() {
        Athlete a1 = new Athlete("Alan","Berg" , 'M', 2.0, 3.0, 2.0);
        Athlete a2 = new Athlete("Saphira","Jane" , 'F', 2.0, 3.0, 2.0);
        Athlete a3 = new Athlete("John","Doe" , 'M', 2.0, 3.0, 2.0);
        Athlete a4 = new Athlete("Jane","Doe" , 'F', 2.0, 3.0, 2.0);
        Athlete a5 = new Athlete("Alycia","Bergot" , 'F', 2.0, 3.0, 2.0);
        Athlete a6 = new Athlete("Saphira","Jane" , 'F', 2.0, 3.0, 2.0);

        List<Athlete> lesAthletes = new ArrayList<>();
        lesAthletes.add(a1);
        lesAthletes.add(a2);
        lesAthletes.add(a3);
        lesAthletes.add(a4);
        lesAthletes.add(a5);
        lesAthletes.add(a6);

        assertEquals(lesAthletes, equipe.getLesAthletes());
    }
    @Test
    public void testSetNomEquipe() {
        equipe.setNomEq("e2");
        assertEquals("e2", equipe.getNomEq());
    }
    @Test
    public void testSetPays() {
        Pays lePays = new Pays("Allemagne");
        equipe.setLePays(lePays);
        assertEquals(lePays, equipe.getLePays());
    }
    @Test
    public void testSetLesAthletes() {
        Athlete a1 = new Athlete("Bob","John" , 'M', 2.0, 3.0, 2.0);
        Athlete a2 = new Athlete("Albert","Jane" , 'F', 2.0, 1.0, 3.0);
        Athlete a3 = new Athlete("John","Pivot" , 'M', 1.0, 3.0, 2.0);
        Athlete a4 = new Athlete("Alfreda","Doe" , 'F', 2.0, 4.0, 3.0);
        Athlete a5 = new Athlete("Saphira","Bel" , 'F', 2.0, 1.0, 2.0);

        List<Athlete> lesAthletes = new ArrayList<>();
        lesAthletes.add(a1);
        lesAthletes.add(a2);
        lesAthletes.add(a3);
        lesAthletes.add(a4);
        lesAthletes.add(a5);
    

        equipe.setLesAthletes(lesAthletes);
        assertEquals(lesAthletes, equipe.getLesAthletes());
    }
    @Test 
    public void testAjouterMembre() {
        Athlete a7 = new Athlete("Bobby","Johnatan" , 'M', 4.0, 3.0, 1.0);
        equipe.ajouterMembre(a7);
        List<Athlete> lesAthletes = equipe.getLesAthletes();
        assertEquals(7, lesAthletes.size());
        assertEquals(a7, lesAthletes.get(6));
    }
    @Test
    public void testSupprimerMembre() {
        Athlete a1 = new Athlete("Alan","Berg" , 'M', 2.0, 3.0, 2.0);
        equipe.supprimerMembre(a1);
        List<Athlete> lesAthletes = equipe.getLesAthletes();
        assertEquals(5, lesAthletes.size());
        assertEquals(false, lesAthletes.contains(a1));
    }
    @Test 
    public double participer() {
        Sport sport = new Sport("Natation", 1.0, 2.0, 3.0, "s");
        Epreuve epreuve = new Epreuve("50m",9,'M', sport);
        double score = equipe.participer(epreuve);
        assertEquals(null, score);     // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    } 



    
}
