package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Master implements DifficultyInterface{

    @Override
    public ArrayList<Integer> randomMethod(ArrayList<Integer> pastTurns, Integer round) {
        ArrayList<Integer> AiGuesses = new ArrayList<>();
        RandomStrategy master = new RandomStrategy();
        StrategySystem system = new StrategySystem(master);
     
        AiGuesses.addAll(system.guess(pastTurns));
        
        return AiGuesses;
    }

    @Override
    public ArrayList<Integer> averageMethod(ArrayList<Integer> pastTurns, Integer round) {
        // if its the first 3 rounds, use the random method
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;

           
}       //if its not the first 3 rounds, use the average method
        else{
            ArrayList<Integer> AiGuesses = new ArrayList<>();
            AverageStrategy master = new AverageStrategy();
            StrategySystem system = new StrategySystem(master);
     
            AiGuesses.addAll(system.guess(pastTurns));
        
            return AiGuesses;


           
        }
    }

    @Override
    public ArrayList<Integer> hardMethod(ArrayList<Integer> pastTurns, Integer round) {
        //if its the first 3 rounds, use the random method
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;
        }
        //if its not the first 3 rounds, use the top method
        else{

            ArrayList<Integer> AiGuesses = new ArrayList<>();
            TopStrategy master = new TopStrategy();
            StrategySystem system = new StrategySystem(master);
         
            AiGuesses.addAll(system.guess(pastTurns));
            
            return AiGuesses;


           

        }
    }

    public ArrayList<Integer> masterMethod(ArrayList<Integer> pastTurns, Integer round) {
        //if its the first 3 rounds, use the random method
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;
        }
        //if its not the first 3 round alternate between the average and top strategys
    else if(round % 2 == 0){
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;
}
        else{
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=averageMethod(pastTurns, round);
            return AiGuesses;
           


           
        }}

        else{
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=hardMethod(pastTurns, round);
            return AiGuesses;
           
        }

    }}

