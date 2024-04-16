import java.util.List;
import java.util.ArrayList;
public class JeuOlympiques {
    private List<Pays> lesPays;
    private List<Sport> lesSports;

    public JeuOlympiques(List<Pays> lesPays, List<Sport> lesSports) {
        this.lesPays = new ArrayList<>(lesPays);
        this.lesSports = new ArrayList<>(lesSports);
    }

    public JeuOlympiques() {
        this.lesPays = new ArrayList<>();
        this.lesSports = new ArrayList<>();
    }

    public void enregistrerEpreuve() {
        // TODO
    }

    public void lancerEpreuve() {
        // TODO
    }

    public void inscrire(Participer participants) {
        // TODO
    }
}
