package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface Strategy {
  // takes in the past turns and returns the guesses
  ArrayList takeTurn(ArrayList<Integer> pastTurns);

}
