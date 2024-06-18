package main.java.com.cdal;

import java.util.Comparator;

public class ComparateurResultats implements Comparator<JeuxOlympiques>{

    //Fonction de comparaison qui compare entres elles les valeurs de chaque entrée
    @Override
    public int compare(JeuxOlympiques entree1, JeuxOlympiques entree2 ){
    //Le tri se fait dans l'ordre ascendant. 
    //si vous souhaitez changer l'ordre de tri
    return 0;
    }



    // Map resultat = new LinkedHashMap<>();
    // for (Map.Entry entree : liste)
    // {
        // resultat.put(entree.getKey(), entree.getValue());
    // }
    // return resultat;

}