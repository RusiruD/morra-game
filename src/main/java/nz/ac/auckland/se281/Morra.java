package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Random;

import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  int rounds=0;
  String name="";
  
  public Morra() {
    
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name=options[0];
    rounds=0;
    ArrayList<Integer> pastTurns = new ArrayList<>();

    

  }

  ArrayList<Integer> pastTurns = new ArrayList<>();
  public void play() {
    

    rounds=rounds+1;
    
   
    MessageCli.START_ROUND.printMessage(Integer.toString(rounds));
    int valid=0;
    int fingers=0;
    int sum=0;
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
      
     
      
      
      /*DifficultyInterface diff=DifficultyFactory.makeGuess("Easy");
      ArrayList<Integer> AiGuesses = new ArrayList<>();
      AiGuesses.addAll(diff.randomMethod(pastTurns, rounds));*/

      DifficultyInterface diff=DifficultyFactory.makeGuess("Medium");
      ArrayList<Integer> AiGuesses = new ArrayList<>();
      AiGuesses.addAll(diff.averageMethod(pastTurns, rounds));
      
    



       
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis",Integer.toString(AiGuesses.get(0)),Integer.toString(AiGuesses.get(1)));
    
  if((AiGuesses.get(1)== (fingers + AiGuesses.get(0))) && AiGuesses.get(1)!=sum){
    MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");

 }
 else if((sum== (fingers + AiGuesses.get(0))) && sum!=AiGuesses.get(1)){
    MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
  }
  else{
MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
  }
  for(int i=0; i<pastTurns.size(); i++){
    System.out.println(pastTurns.get(i));
  }
  pastTurns.add(fingers);
  
   
    
  }

  public void showStats() {}
}
