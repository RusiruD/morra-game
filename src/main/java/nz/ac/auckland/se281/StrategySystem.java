package nz.ac.auckland.se281;

import java.util.ArrayList;

public class StrategySystem {
    private Strategy strategy;

    //constructor
    public StrategySystem(Strategy strategy) {
        this.strategy = strategy;
    }

   public void setStrategy(Strategy strategy){
    this.strategy=strategy;
   }

   //takes in the past turns and returns the guesses
   public ArrayList guess(ArrayList<Integer> pastTurns){
    return strategy.takeTurn(pastTurns);
   }
   

    
}
