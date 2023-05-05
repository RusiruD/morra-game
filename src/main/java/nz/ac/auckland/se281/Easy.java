package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Easy implements DifficultyInterface {

    @Override
    public ArrayList<Integer> randomMethod(ArrayList<Integer> pastTurns, Integer round) {

        ArrayList<Integer> AiGuesses = new ArrayList<>();
        RandomStrategy master = new RandomStrategy();
        StrategySystem system = new StrategySystem(master);
     
        AiGuesses.addAll(system.guess(pastTurns));
        System.out.println(AiGuesses.get(0));
        System.out.println(AiGuesses.get(1));
        return AiGuesses;
    }
    
}
