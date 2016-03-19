import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class Population implements Iterable<Chromosome>{
    private Double fitness;
    public SortedChromosomeCollection chromosomes;

    public Population(ArrayList<Chromosome> chs) {
        chromosomes = new SortedChromosomeCollection(chs);
        fitness = 0.0;
        for (int i = 0; i < chs.size(); ++i)
            fitness += chs.get(i).getFitness();
    }

    @Override
    public Iterator<Chromosome> iterator() {
        return chromosomes.iterator();
    }

    public boolean containsOptimalSolution() {
        return fitness.isInfinite();
    }

    public double getFitness() {
        return fitness;
    }

}
