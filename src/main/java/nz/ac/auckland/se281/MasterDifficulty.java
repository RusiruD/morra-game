package nz.ac.auckland.se281;

import java.util.ArrayList;

public class MasterDifficulty implements DifficultyInterface {

    @Override
    public ArrayList<Integer> randomGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
        ArrayList<Integer> aiGuesses = new ArrayList<>();
        RandomStrategy master = new RandomStrategy();
        StrategySystem system = new StrategySystem(master);

        aiGuesses.addAll(system.guess(pastTurns));

        return aiGuesses;
    }

    @Override
    public ArrayList<Integer> averageGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
        // if its the first 3 rounds, use the random method
        if (round <= 3) {

            ArrayList<Integer> aiGuesses = randomGuessMethod(pastTurns, round);
            return aiGuesses;

        } // if its not the first 3 rounds, use the average method
        else {
            ArrayList<Integer> aiGuesses = new ArrayList<>();
            AverageStrategy master = new AverageStrategy();
            StrategySystem system = new StrategySystem(master);

            aiGuesses.addAll(system.guess(pastTurns));

            return aiGuesses;

        }
    }

    @Override
    public ArrayList<Integer> hardGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
        // if its the first 3 rounds, use the random method
        if (round <= 3) {

            ArrayList<Integer> aiGuesses = randomGuessMethod(pastTurns, round);
            return aiGuesses;
        }
        // if its not the first 3 rounds, use the top method
        else {

            ArrayList<Integer> aiGuesses = new ArrayList<>();
            TopStrategy master = new TopStrategy();
            StrategySystem system = new StrategySystem(master);

            aiGuesses.addAll(system.guess(pastTurns));

            return aiGuesses;

        }
    }

    public ArrayList<Integer> masterGuessMethod(ArrayList<Integer> pastTurns, Integer round) {
        // if its the first 3 rounds, use the random method
        if (round <= 3) {

            ArrayList<Integer> aiGuesses = randomGuessMethod(pastTurns, round);
            return aiGuesses;
        }
        // if its not the first 3 round alternate between the average and top strategys
        else if (round % 2 == 0) {
            if (round <= 3) {

                ArrayList<Integer> aiGuesses = randomGuessMethod(pastTurns, round);
                return aiGuesses;
            } else {

                ArrayList<Integer> aiGuesses = averageGuessMethod(pastTurns, round);
                return aiGuesses;

            }
        }

        else {

            ArrayList<Integer> aiGuesses = hardGuessMethod(pastTurns, round);
            return aiGuesses;

        }

    }
}
