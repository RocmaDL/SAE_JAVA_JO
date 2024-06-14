package test.java.com.cdal;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.java.com.cdal.*;

public class JeuxOlympiquesTest {
    private JeuOlympiques JeuxOlympiques;

    @BeforeEach
    public void setUp(){
        List<Pays> lesPays = new ArrayList<>();
        List<Sport> lesSports = new ArrayList<>();
        List<Athlete> lesAthletes = new ArrayList<>();
        List<Athlete> lesAthletes1 = new ArrayList<>();
        List<Athlete> lesAthletes2 = new ArrayList<>();
        List<Athlete> lesAthletes3 = new ArrayList<>();
        List<Athlete> lesAthletes4 = new ArrayList<>();
        List<Athlete> lesAthletes5 = new ArrayList<>();
     
     
        Pays pays = new Pays("France");
        Pays pays1 = new Pays("Allemagne");
        Pays pays2 = new Pays("Italie");

        Equipe e1 = new Equipe("e1", pays, lesAthletes);
        Equipe e2 = new Equipe("e2", pays, lesAthletes1);
        Equipe e3 = new Equipe("e3",pays1, lesAthletes2);
        Equipe e4 = new Equipe("e4",pays1, lesAthletes3);
        Equipe e5 = new Equipe("e5",pays2, lesAthletes4);
        Equipe e6 = new Equipe("e6",pays2, lesAthletes5);

        
        Athlete a1 = new Athlete("Alan","Berg" , 'M', 2.0, 3.0, 2.0);
        Athlete a2 = new Athlete("Saphira","Jane" , 'F', 2.0, 3.0, 2.0);
        Athlete a3 = new Athlete("John","Doe" , 'M', 2.0, 3.0, 2.0);
        Athlete a4 = new Athlete("Jane","Doe" , 'F', 2.0, 3.0, 2.0);

        e1.ajouterMembre(a1);
        e1.ajouterMembre(a2);
        e1.ajouterMembre(a3);
        e1.ajouterMembre(a4);
        

        Athlete a5 = new Athlete("Alycia","Bgot" , 'F', 1.0, 3.0, 3.0);
        Athlete a6 = new Athlete("Saphira","Bark" , 'F', 4.0, 3.0, 1.0);
        Athlete a7 = new Athlete("Franck","Illyat" , 'F', 2.0, 1.0, 2.0);
        Athlete a8 = new Athlete("Bilel","Janz" , 'F', 2.0, 2.0, 3.0);

        e2.ajouterMembre(a5);
        e2.ajouterMembre(a6);
        e2.ajouterMembre(a7);
        e2.ajouterMembre(a8);

        Athlete a9 = new Athlete("Bertrand","ALibaba" , 'F', 1.0, 2.0, 1.0);
        Athlete a10 = new Athlete("Babou","Loris" , 'M', 4.0, 2.0, 1.0);
        Athlete a11 = new Athlete("Francis","Ngannou" , 'M', 2.0, 1.0, 4.0);
        Athlete a12 = new Athlete("Hassani","Bilal" , 'F', 2.0, 1.0, 2.0);

        e3.ajouterMembre(a9);
        e3.ajouterMembre(a10);
        e3.ajouterMembre(a11);
        e3.ajouterMembre(a12);

        Athlete a13 = new Athlete("Jojo","Ba" , 'F', 1.0, 1.0, 2.0);
        Athlete a14 = new Athlete("Alie","Express" , 'F', 1.0, 2.0, 1.0);
        Athlete a15 = new Athlete("Patrick","Sebastien" , 'F', 2.0, 3.0, 4.0);
        Athlete a16 = new Athlete("George","Lardon" , 'M', 2.0, 4.0, 1.0);

        e4.ajouterMembre(a13);
        e4.ajouterMembre(a14);
        e4.ajouterMembre(a15);
        e4.ajouterMembre(a16);

        Athlete a17 = new Athlete("Mohammed","Amin" , 'F', 1.0, 3.0, 2.0);
        Athlete a18 = new Athlete("Boris","Lebreton" , 'M', 2.0, 2.0, 1.0);
        Athlete a19 = new Athlete("Ahmed","Elalaoui" , 'M', 2.0, 3.0, 4.0);
        Athlete a20 = new Athlete("Louis","Bridgeton" , 'M', 1.0, 2.0, 1.0);


        e5.ajouterMembre(a17);
        e5.ajouterMembre(a18);
        e5.ajouterMembre(a19);
        e5.ajouterMembre(a20);

        Athlete a21 = new Athlete("Mohammed","Aziz" , 'F', 1.0, 3.0, 2.0);
        Athlete a22 = new Athlete("Britney","Lebreton" , 'F', 2.0, 2.0, 1.0);
        Athlete a23 = new Athlete("Ahmed","Babou" , 'M', 2.0, 3.0, 4.0);
        Athlete a24 = new Athlete("Franck","Boucher" , 'M', 1.0, 2.0, 1.0);

        e6.ajouterMembre(a21);
        e6.ajouterMembre(a22);
        e6.ajouterMembre(a23);
        e6.ajouterMembre(a24);

        pays.enregistrerEquipe(e1);
        pays.enregistrerEquipe(e2);
        pays1.enregistrerEquipe(e3);
        pays1.enregistrerEquipe(e4);
        pays2.enregistrerEquipe(e5);
        pays2.enregistrerEquipe(e6);

        pays.enregistrerAthlete(a1);
        pays.enregistrerAthlete(a1);
        pays.enregistrerAthlete(a2);
        pays1.enregistrerAthlete(a13);
        pays1.enregistrerAthlete(a14);
        pays1.enregistrerAthlete(a5);
        pays2.enregistrerAthlete(a6);
        pays2.enregistrerAthlete(a17);
        pays2.enregistrerAthlete(a21);

        lesPays.add(pays);
        lesPays.add(pays1);
        lesPays.add(pays2);

        Sport sport = new Sport("Natation", 1.0, 1.0, 1.0, Unite.TEMPS);
        Sport sport1 = new Sport("Tennis", 2.0, 2.0, 2.0, Unite.POINT);
        Sport sport2 = new Sport("Football", 3.0, 3.0, 3.0, Unite.BUT);
        Sport sport3 = new Sport("Basketball", 2.0, 4.0, 1.0, Unite.POINT);
        Sport sport4 = new Sport("Volleyball", 3.0, 1.0, 1.0, Unite.POINT);
        Sport sport5 = new Sport("Handball", 2.0, 1.0, 3.0,Unite.POINT);
        Sport sport6 = new Sport("Athletisme", 1.0, 3.0, 1.0, Unite.TEMPS);
        Sport sport7 = new Sport("Escrime", 1.0, 1.0, 3.0, Unite.TOUCHE);
    

        lesSports.add(sport);
        lesSports.add(sport1);
        lesSports.add(sport2);
        lesSports.add(sport3);
        lesSports.add(sport4);
        lesSports.add(sport5);
        lesSports.add(sport6);
        lesSports.add(sport7);

        Map<Epreuve, Set<Participer>> lesParticipations;

        Set<Participer> ensParticipants= new HashSet<>();
        Set<Participer> ensParticipants1= new HashSet<>();
        Set<Participer> ensParticipants2= new HashSet<>();
        Set<Participer> ensParticipants3= new HashSet<>();

        lesParticipations = new HashMap<>();
        //Epreuve epreuve = new Epreuve(sport, pays);
        //Epreuve epreuve1 = new Epreuve(sport1, pays);
        //Epreuve epreuve2 = new Epreuve(sport2, pays1);
        //Epreuve epreuve3 = new Epreuve(sport3, pays1);
        //Epreuve epreuve4 = new Epreuve(sport4, pays2);
        //Epreuve epreuve5 = new Epreuve(sport5, pays2);
        //Epreuve epreuve6 = new Epreuve(sport6, pays);
        
        
       

        // Map<Epreuve, Set<Participer>> lesParticipations = new Map<>();
        JeuOlympiques = new JeuOlympiques(lesPays, lesSports, lesParticipations);
    }


    @Test
    public void testAjouterPays() {
        JeuxOlympiques.ajouterPays("France");
        assertEquals(3, JeuxOlympiques.getLesPays().size());
    }
    @Test 
    public void testAjouterSport() {
        Sport sport = new Sport("Natation", 1.0, 1.0, 1.0, Unite.TEMPS);
        JeuxOlympiques.ajouterSport(sport);
        assertEquals(9, JeuxOlympiques.getLesSports().size());
    }
     
    

    
}

