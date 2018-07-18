package com.company;
import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = " ";
        String currentRoom = " ";

        int turnCounter = 1;
        int thirst = 0;

        boolean isRunning = true;

        //pretty much the player's inventory

        boolean hasPhone = false;
        boolean hasNote = false;
        boolean hasKey = false;
        boolean hasHelmet = false;
        boolean hasSuit = false;
        boolean hasPotato = false;
        boolean hasWater = false;
        boolean hasAmmo = false;

        boolean canSee = false;

        //pregame info

        System.out.println("\n\nLost In Space™ ");
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
        slp(5000);
        System.out.println("...");
        slp(2000);
        System.out.println("Hello, I am HAL, the ship's AI\nYou may ask me to do anything you'd like...");
        currentRoom = "Main Cabin";

        //main game loop

        while(isRunning ) {
            System.out.println("You are in the " + currentRoom);

            //must turn the lights on before you can move on

            while(!canSee) {
                System.out.print(">");
                userInput = input.nextLine();
                if (userInput.toLowerCase().equals("turn on")) {
                    System.out.println("What would you like me to turn on?");
                    System.out.print(">");
                    userInput = input.nextLine();
                    if (userInput.toLowerCase().equals("the lights") || userInput.toLowerCase().equals("lights")) {
                        System.out.println("I have turned the lights on...");
                        slp(1000);
                        System.out.println("The entire ship is now lit and you can see clearly");
                        canSee = true;
                    }
                } else if(userInput.toLowerCase().equals("turn on lights") || userInput.toLowerCase().equals("turn on the lights") || userInput.toLowerCase().equals("turn the lights on")) {
                    System.out.println("I have turned the lights on...");
                    slp(1000);
                    System.out.println("The entire ship is now lit and you can see clearly");
                    canSee = true;
                } else {
                    System.out.println("You can't do that here");
                }
            }

            //System.out.print(">");
            //userInput = input.nextLine();

            currentRoom = "Main Cabin";

            //display info based on current room
            //room choices:
            //main cabin, kitchen, filtration room
            //bathroom, bedroom, storage room, fuel room

            //main cabin

            if(currentRoom.equals("Main Cabin")) {
                System.out.println("There is a door to the east and to the south.");

                //only runs if player does not have the phone

                if(!hasPhone) {
                    System.out.println("There is also a phone on the ground. It is an interspace phone, able to transmit signal through a vacuum.");
                }
                System.out.println("The control deck is in this room, but it is broken into a few pieces.");
                System.out.println("BUZZ BUZZ\nSparks are coming from the broken control deck.");
                System.out.println("It looks as though something came through here and destroyed everything.");



            }

            //kitchen

            else if(currentRoom.equals("Kitchen")) {
                System.out.println("There are doors east, west, and south.");

                //only runs if player does not have water

                if(!hasWater) {
                    System.out.println("There is an unopened bottle of water on the counter.");
                }
                System.out.println("There are several standard kitchen appliances still intact including an oven and a fridge.");
                System.out.println("The stove and much of the counter, however are covered in some sort of steaming liquid.");
                System.out.println("The liquid is a color you've never seen before.");



            }

            //filtration room

            else if(currentRoom.equals("Filtration Room")) {
                System.out.println("There are doors in all directions.");
                System.out.println("There is an oxygen synthesis machine with a meter on the side.");
                System.out.println("BEEP BEEP BEEP\nThe meter reads: '4% Oxygen, Find an Oxygen tank soon or you will die.");
                System.out.println("There also remains the remnants of a water tank in the back corner of the room.\nMore signs of attack.");

                //only runs if player does not have ammo

                if(!hasAmmo) {
                    System.out.println("9mm rounds are scattered all around the floor of this room");
                }



            }

            //bathroom

            else if(currentRoom.equals("Bathroom")) {
                System.out.println("There are doors north and east.")l;
                System.out.println("There is a toilet in the room that looks like it should still work");
                System.out.println("The sink is half broken and water is spewing from a broken pipe.");

                //only runs if player does not have helmet

                if(!hasHelmet) {
                    System.out.println("A working space suit helmet is sitting in the back corner of the room");
                }



            }

            //bedroom

            //FINISH THE BEDROOM

            else if(currentRoom.equals("Bedroom")) {
                System.out.println("There are doors north and east.");
                System.out.println("There are 3 bunk beds, 2 of them are knocked over. Could be more signs of attack.");
                System.out.println("There is also a cabinet at the back of the room.");
                if(!hasSuit && hasHelmet) {
                    System.out.println("The rest of the space suit is lying in between the bunks of a toppled bed.");
                } else if (!hasSuit && !hasHelmet) {
                    System.out.println("A space suit is laying between the bunks of a toppled bed. It is missing the helmet though.");
                }



            }

            //storage room

            else if(currentRoom.equals("Storage Room")) {

            }

            //fuel room

            else if(currentRoom.equals("Fuel Room")) {

            }

            //player must find oxygen







            turnCounter++;
        }
    }

    public static void slp(int mil) {
        try {
            Thread.sleep(mil);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
