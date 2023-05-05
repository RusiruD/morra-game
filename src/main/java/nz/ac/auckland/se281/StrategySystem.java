package nz.ac.auckland.se281;

import java.util.ArrayList;

public class StrategySystem {
    private Strategy strategy;

    public StrategySystem(Strategy strategy) {
        this.strategy = strategy;
    }

   public void setStrategy(Strategy strategy){
    this.strategy=strategy;
   }

   public ArrayList guess(ArrayList<Integer> x){
    return strategy.takeTurn(x);
   }
   

    
}
