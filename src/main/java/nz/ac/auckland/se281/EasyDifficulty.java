package nz.ac.auckland.se281;

import java.util.ArrayList;

public class EasyDifficulty implements DifficultyInterface {

    @Override
    public ArrayList<Integer> randomGuessMethod(ArrayList<Integer> pastTurns, Integer round) {

        //creates an arraylist of the guesses which will be returned

        ArrayList<Integer> aiGuesses = new ArrayList<>();
        RandomStrategy randomMethod = new RandomStrategy();

        StrategySystem system = new StrategySystem(randomMethod);
        
        //the Ai's guesses using the random method are added to the aiGuesses arraylist
        aiGuesses.addAll(system.guess(pastTurns));
      
        return aiGuesses;
    }

    @Override
    public ArrayList<Integer> averageGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
        return pastTurns;

    }

    @Override
    public ArrayList<Integer> hardGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
        return pastTurns;
    }

    @Override
    public ArrayList<Integer> masterGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
        return pastTurns;
    }
    
}
