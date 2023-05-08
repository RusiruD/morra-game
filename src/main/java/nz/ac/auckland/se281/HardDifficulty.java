package nz.ac.auckland.se281;

import java.util.ArrayList;

public class HardDifficulty implements DifficultyInterface {

  @Override
  public ArrayList<Integer> randomGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
    ArrayList<Integer> aiGuesses = new ArrayList<>();
    RandomStrategy randomMethod = new RandomStrategy();
    StrategySystem system = new StrategySystem(randomMethod);

    aiGuesses.addAll(system.guess(pastTurns));

    return aiGuesses;
  }

  @Override
  public ArrayList<Integer> averageGuessMethod(ArrayList<Integer> pastTurns, Integer round) {

    throw new UnsupportedOperationException("Unimplemented method 'averageMethod'");
  }

  @Override
  public ArrayList<Integer> hardGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
    RandomStrategy randomMethod = new RandomStrategy();
    StrategySystem system = new StrategySystem(randomMethod);

    if (round <= 3) {
      ArrayList<Integer> aiGuesses = new ArrayList<>();

      aiGuesses.addAll(system.guess(pastTurns));

      return aiGuesses;

      // if its the first 3 rounds, use the random method

    } else {
      // if its not the first 3 rounds, use the top method
      ArrayList<Integer> aiGuesses = new ArrayList<>();
      TopStrategy topMethod = new TopStrategy();

      system.setStrategy(topMethod);
      aiGuesses.addAll(system.guess(pastTurns));

      return aiGuesses;

    }
  }

  @Override
  public ArrayList<Integer> masterGuessMethod(ArrayList<Integer> pastTurns, Integer round) {

    throw new UnsupportedOperationException("Unimplemented method 'masterMethod'");
  }

}
