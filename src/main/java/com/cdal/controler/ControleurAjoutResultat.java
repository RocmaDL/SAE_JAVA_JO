public class ControleurAjoutResultat {
    
    private VueAjoutResultat vue;
    
    public ControleurAjoutResultat(VueAjoutResultat vue) {
        this.vue = vue;
    }
    
    
    public void ajouterResultatManuel() {
        String pays = vue.getChampPays().getText();
        String nom = vue.getChampNom().getText();
        String prenom = vue.getChampPrenom().getText();
        String resultat = vue.getChampResultat().getText();
        if (pays.isEmpty() || nom.isEmpty() || prenom.isEmpty() || resultat.isEmpty()) {
            vue.getMessageAction().setText("Tous les champs doivent être remplis.");
            vue.getMessageAction().setTextFill(Color.RED);
            return;
        }
    
        Resultat nouveauResultat = new Resultat(pays, nom, prenom, resultat);
        vue.getTableResultats().getItems().add(nouveauResultat);
    
        vue.getMessageAction().setText("Résultat ajouté avec succès.");
        vue.getMessageAction().setTextFill(Color.GREEN);
    
        // Réinitialiser les champs de saisie
        vue.getChampPays().clear();
        vue.getChampNom().clear();
        vue.getChampPrenom().clear();
        vue.getChampResultat().clear();
    }
    
    public void chargerResultatsDepuisFichier(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Charger des résultats depuis un fichier");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Fichiers CSV", "*.csv"));
        File fichier = fileChooser.showOpenDialog(primaryStage);
    
        if (fichier != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(fichier))) {
                String ligne;
                while ((ligne = reader.readLine()) != null) {
                    String[] parties = ligne.split(",");
                    if (parties.length == 4) {
                        String pays = parties[0].trim();
                        String nom = parties[1].trim();
                        String prenom = parties[2].trim();
                        String resultat = parties[3].trim();
                        Resultat nouveauResultat = new Resultat(pays, nom, prenom, resultat);
                        vue.getTableResultats().getItems().add(nouveauResultat);
                    } else {
                        System.out.println("Format de ligne invalide: " + ligne);
                    }
                }
                vue.getMessageAction().setText("Résultats chargés depuis le fichier.");
                vue.getMessageAction().setTextFill(Color.GREEN);
            } catch (IOException e) {
                vue.getMessageAction().setText("Erreur lors de la lecture du fichier: " + e.getMessage());
                vue.getMessageAction().setTextFill(Color.RED);
            }
        }
    }
    
    }
    