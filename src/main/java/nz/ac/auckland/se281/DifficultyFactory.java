package nz.ac.auckland.se281;

public class DifficultyFactory {

  public static DifficultyInterface makeGuess(String difficulty) {

    // depending on the difficulty input, return the corresponding difficulty class
    switch (difficulty) {

      case "Easy":
        return new EasyDifficulty();

      case "Medium":
        return new MediumDifficulty();

      case "Hard":
        return new HardDifficulty();

      case "Master":
        return new MasterDifficulty();

      default:
        return null; // don't learn this

    }

  }

}
