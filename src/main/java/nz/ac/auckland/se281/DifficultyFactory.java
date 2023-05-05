package nz.ac.auckland.se281;

public class DifficultyFactory {
    public static DifficultyInterface  makeGuess(String difficulty){
       
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
                   return null; // don't learn thi

        }       





   }


}
