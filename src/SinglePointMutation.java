import java.util.Random;

/**
 * Created by Ryuzaki Sultan on 04-Mar-16.
 */
public class SinglePointMutation {
    private Random random = new Random();
    private CharacterGenerator generator = new CharacterGenerator();
    FitnessCalculator fitnessCalculator;

    public SinglePointMutation(FitnessCalculator fitnessCalculator) {
        this.fitnessCalculator = fitnessCalculator;
    }

    public Chromosome mutate(Chromosome ch) {
        StringBuilder sb = new StringBuilder(ch.getValue());
        int randomPositon = random.nextInt(ch.getValue().length());
        sb.setCharAt(randomPositon, generator.generateCharacter());
        return new Chromosome(sb.toString(), fitnessCalculator);
    }

}
