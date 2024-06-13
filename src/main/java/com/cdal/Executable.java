package main.java.com.cdal;

public class Executable {
    public static void main(String[] args) {
        JeuOlympiques jo = new JeuOlympiques();
        try {
            jo.chargerDonneeCSV("donnees.csv");
            System.out.println("Données chargées avec succès" + "\n");
            System.out.println("Nombre de pays : " + jo.getLesPays().size() + "\n");
            System.out.println("Liste des pays : ");
            jo.getLesPays().forEach(p -> {
                System.out.println(p.getNom());
            });

            System.out.println("\n" + "Nombre de sports : " + jo.getLesSports().size() + "\n");
            System.out.println("Liste des sports : ");
            jo.getLesSports().forEach(s -> {
                System.out.println(s.getNom());
            });

            System.out.println("\n" + "Nombre d'épreuves : " + jo.getLesParticipations().size() + "\n");
            System.out.println("Liste des épreuves : ");
            jo.getLesParticipations().keySet().forEach(ep -> {
                System.out.println(ep);
            });

        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des données");
        }
        Pays france = jo.getPays("France");
        System.out.println("\n" + "Nombre d'athlètes : " + france.getLesAthletes().size() + "\n");
        System.out.println("\n" + "Liste des athlètes français : ");
        france.getLesAthletes().forEach(a -> {
            System.out.println(a.getNomAt() + " " + a.getPrenomAt());
        });

        System.out.println("\n" + "Nombre d'équipes : " + france.getLesEquipes().size() + "\n");
        System.out.println("\n" + "Liste des équipes" + "\n");
        france.getLesEquipes().forEach(e -> {
            System.out.println(e.getNomEq());
        });

        System.out.println("");
    }
}
