package test;

import static org.junit.jupiter.api.Assertions.assertEquals; 

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import main.*;


public class JeuxOlympiquesTest {
    private JeuxOlympiques jeuxOlympiques;

    @BeforeEach
    public void setUp(){
        List<Pays> lesPays = new ArrayList<>();
        List<Sport> lesSports = new ArrayList<>();

        Athlete a1 = new Athlete("Alan","Berg" , 'M', 2.0, 3.0, 2.0);
        Athlete a2 = new Athlete("Saphira","Jane" , 'F', 2.0, 3.0, 2.0);
        Athlete a3 = new Athlete("John","Doe" , 'M', 2.0, 3.0, 2.0);
        Athlete a4 = new Athlete("Jane","Doe" , 'F', 2.0, 3.0, 2.0);
        Athlete a5 = new Athlete("Alycia","Bergot" , 'F', 2.0, 3.0, 2.0);
        Athlete a6 = new Athlete("Saphira","Jane" , 'F', 2.0, 3.0, 2.0);


        Pays pays = new Pays("France");
        //pays.enregistrerEquipe(e1);
        //pays.enregistrerEquipe(e2);
        pays.enregistrerAthlete(a1);
        pays.enregistrerAthlete(a2);
        pays.enregistrerAthlete(a3);
        pays.enregistrerAthlete(a4);



        //Equipe e1 = new Equipe(pays, "e1");
        //Equipe e2 = new Equipe("e2");

        //e1.ajouterMembre(a1);
        //e1.ajouterMembre(a2);
        //e1.ajouterMembre(a3);
//
        //e2.ajouterMembre(a4);
        //e2.ajouterMembre(a5);
        //e2.ajouterMembre(a6);

        

        Map<Epreuve, Set<Participer>> lesParticipations = new Map<>();
        //jeuxOlympiques = new JeuxOlympiques(lesPays, lesSports, lesParticipations);
    }

    
}
