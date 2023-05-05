package nz.ac.auckland.se281;

import java.util.ArrayList;


import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  int rounds=0;
  String name="";
  public Morra() {
    
  }

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    name=options[0];

  }

  
  public void play() {
    

    rounds=rounds+1;
    System.out.println(rounds);
    
    MessageCli.START_ROUND.printMessage(Integer.toString(rounds));
    int valid=0;
    while(valid==0){
    MessageCli.ASK_INPUT.printMessage("Give <fingers> <sum> and press enter");
    String input = Utils.scanner.nextLine();
    String[] input_array = input.split(" ");
    int fingers=Integer.parseInt(input_array[0]);
    int sum = Integer.parseInt(input_array[1]);
   
    if(fingers>=1 && fingers <=5 && sum>=1 && sum<=10){
      
        MessageCli.PRINT_INFO_HAND.printMessage(name, Integer.toString(fingers), Integer.toString(sum));
        valid=1;
      }else{
      MessageCli.INVALID_INPUT.printMessage();}}
    
    

   
    
  }

  public void showStats() {}
}
