import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by raffennn on 10/05/2016.
 * Fiche d'information concernant un train
 */
public class InfoTrafic implements Serializable {

    private static Random RANDOM = new Random();
    private static List<String> ETATS = new LinkedList<>();
    private static List<String> RAISONS = new LinkedList<>();

    static {
        ETATS.add("A L'HEURE");
        ETATS.add("RETARD");
        ETATS.add("PERDU");
        ETATS.add("ANNULE");

        RAISONS.add("N/A");
        RAISONS.add("ANIMAL SUR LA VOIE");
        RAISONS.add("ABSENCE DE SIGNALISATION");
        RAISONS.add("GREVE");
    }

    private int numeroTrain;
    private String etat;
    private String natureProbleme;

    InfoTrafic() {
        numeroTrain = 10000 + RANDOM.nextInt(89999);
        final int numEtat = RANDOM.nextInt(ETATS.size());
        etat = ETATS.get(numEtat);
        if (numEtat == 0) {
            natureProbleme = RAISONS.get(0);
        } else {
            natureProbleme = RAISONS.get(RANDOM.nextInt(RAISONS.size()));
        }
    }

    public int getNumeroTrain() {
        return numeroTrain;
    }

    public void setNumeroTrain(int numeroTrain) {
        this.numeroTrain = numeroTrain;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getNatureProbleme() {
        return natureProbleme;
    }

    public void setNatureProbleme(String natureProbleme) {
        this.natureProbleme = natureProbleme;
    }

    @Override
    public String toString() {
        return "InfoTrafic {" +
                "Numero du train=" + numeroTrain +
                "\nEtat ='" + etat + '\'' +
                "\nNature du problème ='" + natureProbleme + '\'' +
                '}';
    }
}
