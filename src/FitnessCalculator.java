/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class FitnessCalculator {
    public String target;

    public FitnessCalculator(String target) {
        this.target = target;
    }

    public Double calculateFitness(Chromosome ch) {
        if (ch.getValue().length() != target.length()) {
            return 1.0/Double.POSITIVE_INFINITY;
        }

        int difference = 0;
        String chValue = ch.getValue();
        for (int i = 0; i < target.length(); ++i)
            if (chValue.charAt(i) != target.charAt(i))
                difference++;
        return 1.0/difference;
    }
}
