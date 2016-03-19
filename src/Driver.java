import kotlin.Pair;

import java.util.ArrayList;
import java.util.Random;

public class Driver {
    private static double crossoverRate = 0.5, mutationRate = 0.5, elitismRate = 0.2;
    private static int populationSize = 2000;
    private static String target = "Names are Sultan Ahmed and Muhammad Usman and roll numbers are 13L5893 and 13L5931";

    private static Random random = new Random();

    public static void main(String[] args) {
        FitnessCalculator fitnessCalculator = new FitnessCalculator(target);
        OnePointCrossover crossover = new OnePointCrossover(fitnessCalculator);
        SinglePointMutation mutation = new SinglePointMutation(fitnessCalculator);
        RouletteWheelSelection selection = new RouletteWheelSelection();
        CharacterGenerator characterGenerator = new CharacterGenerator();

        RandomElementFactory elementFactory = new RandomElementFactory(characterGenerator,fitnessCalculator,target.length(),populationSize);
        Population population = elementFactory.randomPopulation();

        int totalGenerations = 0;
        while(true) {
            System.out.println("Generation#" + totalGenerations + ": " + population.chromosomes.chromosomes.get(0).getValue());
            if (population.containsOptimalSolution())
                break;
            population = advanceGeneration(population, selection, crossover, mutation);
            totalGenerations++;
        }

    }

    static Population advanceGeneration(Population population, RouletteWheelSelection selection, OnePointCrossover crossover, SinglePointMutation mutation) {
        ArrayList<Chromosome> chromosomes = new ArrayList<Chromosome>();
        int elitCount = (int)(elitismRate * populationSize);
        for (int i = 0; i < elitCount; ++i)
            chromosomes.add(population.chromosomes.chromosomes.get(i));
        do {
            try {
                Chromosome p1 = selection.select(population);
                Chromosome p2 = selection.select(population);

                if (random.nextDouble() < crossoverRate) {
                    Pair<Chromosome, Chromosome> children = crossover.crossover(p1,p2);
                    p1 = children.component1();
                    p2 = children.component2();
                }

                if (random.nextDouble() < mutationRate)
                    p1 = mutation.mutate(p1);
                if (random.nextDouble() < mutationRate)
                    p2 = mutation.mutate(p2);
                chromosomes.add(p1);
                chromosomes.add(p2);
            }
            catch (Exception ex) {}

        } while (chromosomes.size() < populationSize);

        return new Population(chromosomes);
    }
}
