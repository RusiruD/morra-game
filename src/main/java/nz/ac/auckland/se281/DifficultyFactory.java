package nz.ac.auckland.se281;

public class DifficultyFactory {


    public static DifficultyInterface makeGuess(String difficulty){

        //depending on the difficulty input, return the corresponding difficulty class
        switch(difficulty){

              case "Easy":
                   return new Easy();
                   
               case "Medium":
                   return new Medium();

               case "Hard":
                   return new Hard();

                case "Master":
                    return new Master();

               default:
                   return null; // don't learn this

        }       





   }


}
