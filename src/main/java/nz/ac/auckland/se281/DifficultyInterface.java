package nz.ac.auckland.se281;

import java.util.ArrayList;


public interface DifficultyInterface {

    //implements the methods for each difficulty that implements the interface
    
    ArrayList<Integer> randomMethod(ArrayList<Integer> pastTurns, Integer round);

    ArrayList<Integer> averageMethod(ArrayList<Integer> pastTurns, Integer round);
    ArrayList<Integer> hardMethod(ArrayList<Integer> pastTurns,Integer round);
    ArrayList<Integer>masterMethod(ArrayList<Integer> pastTurns,Integer round);
    
    
}
