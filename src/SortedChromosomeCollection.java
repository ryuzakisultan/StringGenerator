import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class SortedChromosomeCollection implements Iterable<Chromosome>{
    public ArrayList<Chromosome> chromosomes;

    public SortedChromosomeCollection(ArrayList<Chromosome> chs) {
        PriorityQueue<Chromosome> q = new PriorityQueue<Chromosome>();
        for (int i = 0; i < chs.size(); ++i)
            q.add(chs.get(i));

        int totalChromosomes = q.size();
        chromosomes = new ArrayList<Chromosome>();
        for (int i = 0; i < totalChromosomes; ++i)
            chromosomes.add(q.remove());

    }

    @Override
    public Iterator<Chromosome> iterator() {
        return chromosomes.iterator();
    }
}
