package nz.ac.auckland.se281;

import java.util.ArrayList;


import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  int rounds=0;
  String name="";
  int game=0;
  int p=0;
  
  public Morra() {
    
  }
  int level=0;

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    game=1;
    p=pointsToWin;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name=options[0];
    rounds=0;
    if(difficulty.name().equals("EASY")){level=1;}
    else if(difficulty.name().equals("MEDIUM")){level=2;}
    else if(difficulty.name().equals("HARD")){level=3;}
    else if(difficulty.name().equals("MASTER")){level=4;}
    
    
    
    
    ArrayList<Integer> pastTurns = new ArrayList<>();

    

  }
  int aiPoints=0;
  int humanPoints=0;
  ArrayList<Integer> pastTurns = new ArrayList<>();
  public void play() {
    
    if(game==0){
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    
    rounds=rounds+1;
    
    
    MessageCli.START_ROUND.printMessage(Integer.toString(rounds));
    int valid=0;
    int fingers=0;
    int sum=0;
    aiPoints=0;
   
    while(valid==0){
    MessageCli.ASK_INPUT.printMessage("Give <fingers> <sum> and press enter");
    String input = Utils.scanner.nextLine();
    String[] input_array = input.split(" ");
    
      
    fingers=Integer.parseInt(input_array[0]);
    sum = Integer.parseInt(input_array[1]);
   
    if(fingers>=1 && fingers <=5 && sum>=1 && sum<=10){
      
        MessageCli.PRINT_INFO_HAND.printMessage(name, Integer.toString(fingers), Integer.toString(sum));
        valid=1;
        
      }else{
      MessageCli.INVALID_INPUT.printMessage();}}
      
     
      ArrayList<Integer> AiGuesses = new ArrayList<>();
      
      if(level==1){
        
      DifficultyInterface easyDifficulty=DifficultyFactory.makeGuess("Easy");
        AiGuesses = new ArrayList<Integer>();
        AiGuesses.addAll(easyDifficulty.randomMethod(pastTurns, rounds));
      }
      if(level==2){

      DifficultyInterface mediumDifficulty=DifficultyFactory.makeGuess("Medium");
       AiGuesses = new ArrayList<Integer>();
      
        AiGuesses.addAll(mediumDifficulty.averageMethod(pastTurns, rounds));
      }
      if(level==3){
      
     DifficultyInterface hardDifficulty=DifficultyFactory.makeGuess("Hard");
       AiGuesses = new ArrayList<Integer>();
      AiGuesses.addAll(hardDifficulty.hardMethod(pastTurns, rounds));
      }
      if(level==4){

      DifficultyInterface masterDifficulty=DifficultyFactory.makeGuess("Master");
      AiGuesses = new ArrayList<Integer>();
      AiGuesses.addAll(masterDifficulty.masterMethod(pastTurns, rounds));
      }
      


       
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis",Integer.toString(AiGuesses.get(0)),Integer.toString(AiGuesses.get(1)));
    
  if((AiGuesses.get(1)== (fingers + AiGuesses.get(0))) && AiGuesses.get(1)!=sum){
    MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    System.out.println(aiPoints);
      System.out.println(p);
    if(aiPoints+1==p){
      MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(rounds));
      game=0;
      return;
    }
    aiPoints=aiPoints+1;


 }
 else if((sum== (fingers + AiGuesses.get(0))) && sum!=AiGuesses.get(1)){
    MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    System.out.println(humanPoints);
    System.out.println(p);
    if(humanPoints+1==p){
      MessageCli.END_GAME.printMessage(name, Integer.toString(rounds));
      game=0;
      return;
    }
    humanPoints=humanPoints+1;
  }
  else{
MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");

  }
  
  pastTurns.add(fingers);}
  
   
    
  

  public void showStats() {
    if(game==0){
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
   
    MessageCli.PRINT_PLAYER_WINS.printMessage(name, Integer.toString(humanPoints),Integer.toString(p-humanPoints));
    MessageCli.PRINT_PLAYER_WINS.printMessage("Jarvis", Integer.toString(aiPoints),Integer.toString(p-aiPoints));

    
  }
}
