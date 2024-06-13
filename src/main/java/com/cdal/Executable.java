package main.java.com.cdal;

public class Executable {
    public static void main(String[] args) {
        JeuOlympiques jo = new JeuOlympiques();
        try {
            jo.chargerDonneeCSV("donnees.csv");
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des données");
        }
    }
}
