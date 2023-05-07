package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  // initialise variables
  protected int roundsPlayed = 0;
  protected String name = "";
  protected int gameLoaded = 0;

  protected int pointsTarget = 0;
  protected int difficultylevel = 0;
  protected int aiPoints = 0;
  protected int humanPoints = 0;
  protected ArrayList<Integer> pastTurns = new ArrayList<>();

  public Morra() {

  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    gameLoaded = 1;
    pointsTarget = pointsToWin;

    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name = options[0];
    roundsPlayed = 0;

    // depending on difficulty input, set the difficulty level
    if (difficulty.name().equals("EASY")) {
      difficultylevel = 1;
    } else if (difficulty.name().equals("MEDIUM")) {
      difficultylevel = 2;
    } else if (difficulty.name().equals("HARD")) {
      difficultylevel = 3;
    } else if (difficulty.name().equals("MASTER")) {
      difficultylevel = 4;
    }

  }

  public void play() {

    // if game is not loaded, print error message
    if (gameLoaded == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // iterate the roundsPlayed every time play is called
    roundsPlayed = roundsPlayed + 1;

    MessageCli.START_ROUND.printMessage(Integer.toString(roundsPlayed));
    int valid = 0;
    int fingers = 0;
    int sum = 0;
    aiPoints = 0;

    // keep asking the user till they give a valid input
    while (valid == 0) {
      MessageCli.ASK_INPUT.printMessage("Give <fingers> <sum> and press enter");
      String input = Utils.scanner.nextLine();
      String[] inputArray = input.split(" ");

      fingers = Integer.parseInt(inputArray[0]);
      sum = Integer.parseInt(inputArray[1]);

      // if a valid amount of fingers and sum is guessed by the user output the info
      // message.
      if (fingers >= 1 && fingers <= 5 && sum >= 1 && sum <= 10) {

        MessageCli.PRINT_INFO_HAND.printMessage(name, Integer.toString(fingers), Integer.toString(sum));
        valid = 1;

      }
      // if a invalid amount of fingers and sum is guessed by the user output an error
      // message.
      else {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }

    ArrayList<Integer> aiGuesses = new ArrayList<>();

    // depending on the difficulty level, call the appropriate method from the
    // difficulty interface
    if (difficultylevel == 1) {

      DifficultyInterface easyDifficulty = DifficultyFactory.makeGuess("Easy");
      aiGuesses = new ArrayList<Integer>();
      aiGuesses.addAll(easyDifficulty.randomGuessMethod(pastTurns, roundsPlayed));
    }

    if (difficultylevel == 2) {

      DifficultyInterface mediumDifficulty = DifficultyFactory.makeGuess("Medium");
      aiGuesses = new ArrayList<Integer>();

      aiGuesses.addAll(mediumDifficulty.averageGuessMethod(pastTurns, roundsPlayed));
    }
    if (difficultylevel == 3) {

      DifficultyInterface hardDifficulty = DifficultyFactory.makeGuess("Hard");
      aiGuesses = new ArrayList<Integer>();
      aiGuesses.addAll(hardDifficulty.hardGuessMethod(pastTurns, roundsPlayed));
    }
    if (difficultylevel == 4) {

      DifficultyInterface masterDifficulty = DifficultyFactory.makeGuess("Master");
      aiGuesses = new ArrayList<Integer>();
      aiGuesses.addAll(masterDifficulty.masterGuessMethod(pastTurns, roundsPlayed));
    }

    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(aiGuesses.get(0)),
        Integer.toString(aiGuesses.get(1)));
    // if the sum of the fingers guessed by the user plus the fingers guessed by the
    // ai is only equal to the sum guessed by the AI, the AI wins
    if ((aiGuesses.get(1) == (fingers + aiGuesses.get(0))) && aiGuesses.get(1) != sum) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");

      // if the AI wins the round and has the required number of points to win, print
      // the end game message and set gameLoaded to 0
      if (aiPoints + 1 == pointsTarget) {
        MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(roundsPlayed));
        gameLoaded = 0;
        return;
      }
      aiPoints = aiPoints + 1;

    }
    // if the sum of the fingers guessed by the user plus the fingers guessed by the
    // ai is only equal to the sum guessed by the user the user wins
    else if ((sum == (fingers + aiGuesses.get(0))) && sum != aiGuesses.get(1)) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");

      // if the user wins the round and has the required number of points to win,
      // print the end game message and set gameLoaded to 0
      if (humanPoints + 1 == pointsTarget) {
        MessageCli.END_GAME.printMessage(name, Integer.toString(roundsPlayed));
        gameLoaded = 0;
        return;
      }
      humanPoints = humanPoints + 1;
    } else {
      // if neither player guesses the correct sum or they both do the round is a
      // draw, no points awarded
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");

    }

    // add the fingers guessed by the user to the pastTurns arraylist
    pastTurns.add(fingers);
  }

  public void showStats() {
    // if game is not loaded, print error message
    if (gameLoaded == 0) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // print the number of rounds played, the number of points the user has and the
    // number of points the AI has and how many rounds they need to win
    MessageCli.PRINT_PLAYER_WINS.printMessage(name, Integer.toString(humanPoints),
        Integer.toString(pointsTarget - humanPoints));
    MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis", Integer.toString(aiPoints),
        Integer.toString(pointsTarget - aiPoints));

  }
}
