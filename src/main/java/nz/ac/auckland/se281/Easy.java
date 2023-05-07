package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Easy implements DifficultyInterface {

    @Override
    public ArrayList<Integer> randomMethod(ArrayList<Integer> pastTurns, Integer round) {

        //creates an arraylist of the guesses which will be returned

        ArrayList<Integer> AiGuesses = new ArrayList<>();
        RandomStrategy randomMethod = new RandomStrategy();

        StrategySystem system = new StrategySystem(randomMethod);
        
        //the Ai's guesses using the random method are added to the AiGuesses arraylist
        AiGuesses.addAll(system.guess(pastTurns));
      
        return AiGuesses;
    }

    @Override
    public ArrayList<Integer> averageMethod(ArrayList<Integer> pastTurns, Integer round) {
        return pastTurns;

    }

    @Override
    public ArrayList<Integer> hardMethod(ArrayList<Integer> pastTurns, Integer round) {
        return pastTurns;
    }

    @Override
    public ArrayList<Integer> masterMethod(ArrayList<Integer> pastTurns, Integer round) {
        return pastTurns;
    }
    
}
