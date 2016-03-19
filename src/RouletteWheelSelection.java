import java.util.Iterator;
import java.util.Random;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class RouletteWheelSelection {
    private Random random = new Random();

    public Chromosome select(Population population) throws Exception {
        double ran = random.nextDouble()*population.getFitness();
        double sum = 0;
        for (Iterator<Chromosome> iter = population.iterator(); iter.hasNext(); ) {
            Chromosome chromosome = iter.next();
            sum += chromosome.getFitness();
            if (sum > ran) {
                return chromosome;
            }
        }
        throw new Exception("A chromosome should always be selected");
    }
}
