import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class Chromosome implements Comparable<Chromosome>{
    private Double fitness;
    private String value;

    public Chromosome(String value, FitnessCalculator fitnessCalculator) {
        this.value = value;
        fitness = fitnessCalculator.calculateFitness(this);
    }

    public Double getFitness() {
        return fitness;
    }

    public void setFitness(Double fitness) {
        this.fitness = fitness;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public int compareTo(Chromosome o) {
        Double difference = fitness - o.getFitness();
        return difference > 0 ? -1 : difference < 0 ? 1 : 0;
    }
}
