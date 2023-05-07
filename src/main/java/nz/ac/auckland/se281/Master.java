package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Master implements DifficultyInterface{

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

    @Override
    public ArrayList<Integer> averageMethod(ArrayList<Integer> pastTurns, Integer round) {
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;

           
}
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
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;
        }
        else{
            ArrayList<Integer> AiGuesses = new ArrayList<>();
            TopStrategy master = new TopStrategy();
            StrategySystem system = new StrategySystem(master);
         
            AiGuesses.addAll(system.guess(pastTurns));
            
            return AiGuesses;


           

        }
    }

    public ArrayList<Integer> masterMethod(ArrayList<Integer> pastTurns, Integer round) {
        if (round<=3){
            ArrayList<Integer> AiGuesses = new ArrayList<>();
           
            AiGuesses=randomMethod(pastTurns, round);
            return AiGuesses;
        }
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

