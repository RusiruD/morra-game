package nz.ac.auckland.se281;

import java.util.ArrayList;


public interface DifficultyInterface {

    //implements the methods for each difficulty that implements the interface
    
    ArrayList<Integer> randomGuessMethod(ArrayList<Integer> pastTurns, Integer round);

    ArrayList<Integer> averageGuessMethod(ArrayList<Integer> pastTurns, Integer round);
    ArrayList<Integer> hardGuessMethod(ArrayList<Integer> pastTurns,Integer round);
    ArrayList<Integer>masterGuessMethod(ArrayList<Integer> pastTurns,Integer round);
    
    
}
