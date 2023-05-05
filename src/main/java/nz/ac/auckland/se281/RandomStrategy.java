package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RandomStrategy implements Strategy{

    

    @Override
    public ArrayList takeTurn(ArrayList< Integer> pastTurns) {
        int aiFingers=(Utils.getRandomNumber(1,5)); 
        int aiSum=(Utils.getRandomNumber(aiFingers+1, aiFingers+5));
        ArrayList<Integer> guesses = new ArrayList<>();
        guesses.add(aiFingers);
        guesses.add(aiSum);
       
        return guesses;
        
        
    }
    
}
