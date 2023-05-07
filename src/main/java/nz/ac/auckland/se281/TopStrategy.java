package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class TopStrategy implements Strategy{

    @Override
    public ArrayList takeTurn(ArrayList pastTurns) {
        int aiFingers=(Utils.getRandomNumber(1,5)); 
        //find the most common value in an array named pastTurns
        int maxCount=0;
        int maxFreq=0;
        for (int i = 0; i < pastTurns.size(); i++){
          int count = 0;
          for (int j = 0; j < pastTurns.size(); j++){
             if (pastTurns.get(i) == pastTurns.get(j)){
                count++;
             }
          }
         
          if (count > maxCount){
             maxCount = count;
             maxFreq = (int) pastTurns.get(i);
          }
       }
 
       
        
        
        
        //output the most common value
       
        int aiSum=(aiFingers+maxFreq); 
        ArrayList<Integer> guesses = new ArrayList<>();
        guesses.add(aiFingers);
        guesses.add(aiSum);
       
        return guesses;
        

    }}

