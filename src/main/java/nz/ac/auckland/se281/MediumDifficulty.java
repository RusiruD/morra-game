package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MediumDifficulty implements DifficultyInterface {

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

    // if its the first 3 rounds, use the random method
    if (round <= 3) {

      ArrayList<Integer> aiGuesses = randomGuessMethod(pastTurns, round);
      return aiGuesses;

    } else {
      // if its not the first 3 rounds, use the average method
      ArrayList<Integer> aiGuesses = new ArrayList<>();
      AverageStrategy averageMethod = new AverageStrategy();
      StrategySystem system = new StrategySystem(averageMethod);

      aiGuesses.addAll(system.guess(pastTurns));

      return aiGuesses;

    }

  }

  @Override
  public ArrayList<Integer> hardGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'hardMethod'");
  }

  @Override
  public ArrayList<Integer> masterGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'masterMethod'");
  }

}
