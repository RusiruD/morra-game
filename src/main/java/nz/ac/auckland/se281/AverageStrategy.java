package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy implements Strategy {

  @Override
  public ArrayList<Integer> takeTurn(ArrayList<Integer> pastTurns) {
    // the ai guesses a random number of fingers between 1 and 5
    int aiFingers = (Utils.getRandomNumber(1, 5));
    double average = 0;
    // calculates the average fingers played in the past turns
    for (int i = 0; i < pastTurns.size(); i++) {

      average = (int) pastTurns.get(i) + average;
    }
    average = average / pastTurns.size();
    average = Math.round(average);
    average = (int) average;

    // ai guesses the sum by adding the average number of fingers played by the
    // human player to its finger guess
    int aiSum = (int) (aiFingers + average);
    ArrayList<Integer> guesses = new ArrayList<>();
    guesses.add(aiFingers);
    guesses.add(aiSum);

    return guesses;

  }

}
