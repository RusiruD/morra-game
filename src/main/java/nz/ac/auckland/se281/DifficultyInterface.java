package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Collection;

public interface DifficultyInterface {
    ArrayList<Integer> randomMethod(ArrayList<Integer> pastTurns, Integer round);

    ArrayList<Integer> averageMethod(ArrayList<Integer> pastTurns, Integer round);
    ArrayList<Integer> hardMethod(ArrayList<Integer> pastTurns,Integer round);
    ArrayList<Integer>masterMethod(ArrayList<Integer> pastTurns,Integer round);
    
    
}
