package nz.ac.auckland.se281;

import java.util.ArrayList;

public class AverageStrategy implements Strategy {

    @Override
    public ArrayList takeTurn(ArrayList<Integer> pastTurns) {
        int aiFingers=(Utils.getRandomNumber(1,5)); 
        double average=0;

        for( int i=0;  i<pastTurns.size(); i++){

            average=(int) pastTurns.get(i)+average;
        }
        average = average/pastTurns.size();
        average=Math.round(average);
        average=(int)average;
        int aiSum=(int) (aiFingers+average);
        ArrayList<Integer> guesses = new ArrayList<>();
        guesses.add(aiFingers);
        guesses.add(aiSum);
       
        return guesses;
        
        
    }

    
    
}
