import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class RandomElementFactory {
    private CharacterGenerator characterGenerator = new CharacterGenerator();
    private FitnessCalculator fitnessCalculator;
    private int stringLength;
    private int populationSize;

    public RandomElementFactory(CharacterGenerator characterGenerator, FitnessCalculator fitnessCalculator, int stringLength, int populationSize) {
        this.characterGenerator = characterGenerator;
        this.fitnessCalculator = fitnessCalculator;
        this.stringLength = stringLength;
        this.populationSize = populationSize;
    }

    public Chromosome randomChromosome() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stringLength; ++i)
            sb.append(characterGenerator.generateCharacter());
        return new Chromosome(sb.toString(),fitnessCalculator);
    }
    public Population randomPopulation() {
        ArrayList<Chromosome> chromosomes = new ArrayList<Chromosome>();
        for (int i = 0; i < populationSize; ++i)
            chromosomes.add(randomChromosome());
        return new Population(chromosomes);
    }

}
