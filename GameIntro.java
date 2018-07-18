import java.util.Scanner;

//GAME INTRO FUNCTION

public class GameIntro {
    public static void gameIntro() {
        //pregame info
        
        Scanner input = new Scanner(System.in);
        
        String userInput = " ";
        
        System.out.println("\n\nLost In Space ");
        System.out.println("\n\nA game by Finn St John");
        System.out.print("Enter Start to begin the game....");
        userInput = input.nextLine();
        while(!userInput.equals("start") && !userInput.equals("exit")) {
            System.out.print("Enter Start to begin the game....");
            userInput = input.nextLine();
        } if(userInput.equals("exit")) {
            System.out.println("Exiting...");
            System.exit(0);
        }

        //game intro

        System.out.println("You are stranded on a ship in the middle of the Milky Way...");
        System.out.println("It is dark in the ship and you are unable to see anything.");
        System.out.println("You hear a robotic voice from above you");
        System.out.println("...");
        System.out.println("Hello, I am HAL, the ship's AI\nYou may ask me to do anything you'd like...");
    }
    
    GameIntro() {};
}
