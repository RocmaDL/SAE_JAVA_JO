import java.util.ArrayList;
import java.util.List;
import test.java.Athlete;

public class EquipeTest implements Participer{
    private String nomEq;
    private PaysTest lePays;
    private List<Athlete> lesAthletes;

    /** Constructeur qui met à jour les attributs de la classe Equipe
     * @param nomEq
     * @param lePays
     * @param lesAthletes
     */
    public EquipeTest(String nomEq, PaysTest lePays , List<Athlete> lesAthletes) {
        this.nomEq = nomEq;
        this.lePays = lePays;
        this.lesAthletes = lesAthletes;
    }


    /** Constructeur qui met à jour les attributs de la classe Equipe
     * @param nomEq
     * @param lePays
     */
    public EquipeTest(String nomEq, PaysTest lePays) {
        this.nomEq = nomEq;
        this.lePays = lePays;
        this.lesAthletes = new ArrayList<>();

    }


    /** Récupère la liste des Athlètes
     * @return la liste des athlètes
     */
    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }


    /** Fixe la liste des Athlètes
     * @param lesAthletes
     */
    public void setLesAthletes(List<Athlete> lesAthletes) {
        this.lesAthletes = lesAthletes;
    }

    
    /** Récupère la nationalité de l'équipe
     * @return la nationalité de l'équipe
     */
    public PaysTest getLePays() {
        return lePays;
    }


    /** Fixe le pays de l'équipe
     * @param lePays
     */
    public void setLePays(PaysTest lePays) {
        this.lePays = lePays;
    }


    /** Récupère le nom de l'équipe
     * @return le nom de l'équipe
     */
    public String getNomEq() {
        return nomEq;
    }


    /** Fixe le nom de l'équipe
     * @param nomEq
     */
    public void setNomEq(String nomEq) {
        this.nomEq = nomEq;
    }

    
    /** Ajoute un athlète dans la liste de l'équipe
     * @param nvAthlete
     */
    public void ajouterMembre(Athlete nvAthlete){
        this.lesAthletes.add(nvAthlete);
    }

    
    /** Retire un athlète de l'équipe
     * @param athlete
     */
    public void retirerMembre(Athlete athlete){
        this.lesAthletes.remove(this.lesAthletes.indexOf(athlete));
    }

    
    @Override

    public double participer(EpreuveTest epreuve) {
        int cpt = 0;
        Double res = 0.0;
        for (Athlete athlete : this.lesAthletes) {
            Double perf =  athlete.participer(epreuve);
            res += perf;
            cpt += 1;
        }
        return res/cpt;
    }
    
}
