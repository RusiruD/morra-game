package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RandomStrategy implements Strategy {

  @Override
  public ArrayList takeTurn(ArrayList<Integer> pastTurns) {
    // the ai guesses a random number of fingers between 1 and 5
    int aiFingers = (Utils.getRandomNumber(1, 5));
    // the ai guesses a random sum between 1 greater than its finger guess and 5
    // greater than its finger guess
    int aiSum = (Utils.getRandomNumber(aiFingers + 1, aiFingers + 5));
    // the ai returns its guesses
    ArrayList<Integer> guesses = new ArrayList<>();
    guesses.add(aiFingers);
    guesses.add(aiSum);

    return guesses;

  }

}
