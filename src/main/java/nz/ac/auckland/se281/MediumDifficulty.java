package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MediumDifficulty implements DifficultyInterface{

    @Override
    public ArrayList<Integer> randomMethod(ArrayList<Integer> pastTurns, Integer round) {
        ArrayList<Integer> AiGuesses = new ArrayList<>();
        RandomStrategy randomMethod = new RandomStrategy();
        StrategySystem system = new StrategySystem(randomMethod);
     
        AiGuesses.addAll(system.guess(pastTurns));
        
        return AiGuesses;
    }
    @Override
    public ArrayList<Integer> averageMethod(ArrayList<Integer> pastTurns, Integer round){

        //if its the first 3 rounds, use the random method
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;

           
}
        else{
            //if its not the first 3 rounds, use the average method
            ArrayList<Integer> AiGuesses = new ArrayList<>();
            AverageStrategy averageMethod = new AverageStrategy();
            StrategySystem system = new StrategySystem(averageMethod);
     
            AiGuesses.addAll(system.guess(pastTurns));
        
            return AiGuesses;


           
        }
        
    }
    @Override
    public ArrayList<Integer> hardMethod(ArrayList<Integer> pastTurns, Integer round) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'hardMethod'");
    }
    @Override
    public ArrayList<Integer> masterMethod(ArrayList<Integer> pastTurns, Integer round) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'masterMethod'");
    }
    

    
   


    
    
}
