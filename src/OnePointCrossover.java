import kotlin.Pair;

import java.util.Random;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class OnePointCrossover {
    private Random random = new Random();
    FitnessCalculator fitnessCalculator;

    public OnePointCrossover(FitnessCalculator fitnessCalculator) {
        this.fitnessCalculator = fitnessCalculator;
    }

    public Pair<Chromosome, Chromosome> crossover(Chromosome p1, Chromosome p2) {
        int locus = random.nextInt(p1.getValue().length());
        String c1 = p1.getValue().substring(0,locus) + p2.getValue().substring(locus);
        String c2 = p2.getValue().substring(0,locus) + p1.getValue().substring(locus);
        return new Pair<Chromosome, Chromosome>(
                new Chromosome(c1, fitnessCalculator),
                new Chromosome(c2, fitnessCalculator)
        );
    }
}
