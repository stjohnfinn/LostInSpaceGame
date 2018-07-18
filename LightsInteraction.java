import java.util.Scanner;

public class LostInSpace{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userInput = " ";
        String currentRoom = "Main Cabin";
        int turnCounter = 1;
        int thirst = 0;
        
        GoThroughWormhole gTW = new GoThroughWormhole();

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
        boolean hasGun = false;

        boolean isInSelfDestruct = false;
        boolean alienIsAlive = true;
        boolean playerHasOxygen = false;
        boolean isFridgeOpen = false;
        
        //INTRO TO THE GAME
        
        GameIntro.gameIntro();
        
        //LIGHTS INTERACTION
        
        LightsInteraction.turnOnLightsInteraction();

        //main game loop

        while(isRunning ) {
            System.out.println("You are in the " + currentRoom);

            //ROOMS
            //display info based on current room
            //room choices:
            //main cabin, kitchen, filtration room
            //bathroom, bedroom, storage room, fuel room
            
            //main cabin
            
            switch (currentRoom) {
                case "Main Cabin":
                    System.out.println("There is a door to the east and to the south.");
                    //only runs if player does not have the phone
                    
                    if(!hasPhone) {
                        System.out.println("There is also a phone on the ground. It is an interspace phone, able to transmit signal through a vacuum.");
                    }   System.out.println("The control deck is in this room, but it is broken into a few pieces.");
                    System.out.println("BUZZ BUZZ\nSparks are coming from the broken control deck.");
                    System.out.println("It looks as though something came through here and destroyed everything.");
                    break;
                case "Kitchen":
                    System.out.println("There are doors east, west, and south.");
                    //only runs if player does not have water
                    
                    if(!hasWater) {
                        System.out.println("There is an unopened bottle of water on the counter.");
                    }   System.out.println("There are several standard kitchen appliances still intact including an oven and a fridge.");
                    System.out.println("The stove and much of the counter, however are covered in some sort of steaming liquid.");
                    System.out.println("The liquid is a color you've never seen before.");
                    break;
                case "Filtration Room":
                    System.out.println("There are doors in all directions.");
                    System.out.println("There is an oxygen synthesis machine with a meter on the side.");
                    System.out.println("BEEP BEEP BEEP\nThe meter reads: '4% Oxygen, Find an Oxygen tank soon or you will die.");
                    System.out.println("There also remains the remnants of a water tank in the back corner of the room.\nMore signs of attack.");
                    //only runs if player does not have ammo
                    
                    if(!hasAmmo) {
                        System.out.println("9mm rounds are scattered all around the floor of this room");
                    }   break;
                case "Bathroom":
                    System.out.println("There are doors north and east.");
                    System.out.println("There is a toilet in the room that looks like it should still work");
                    System.out.println("The sink is half broken and water is spewing from a broken pipe.");
                    //only runs if player does not have helmet
                    
                    if(!hasHelmet) {
                        System.out.println("A working space suit helmet is sitting in the back corner of the room");
                    }   break;
                case "Bedroom":
                    System.out.println("There are doors north and east.");
                    System.out.println("There are 3 bunk beds, 2 of them are knocked over. Could be more signs of attack.");
                    System.out.println("There is also a cabinet at the back of the room.");
                    if(!hasSuit && hasHelmet) {
                        System.out.println("The rest of the space suit is lying in between the bunks of a toppled bed.");
                    } else if (!hasSuit && !hasHelmet) {
                        System.out.println("A space suit is laying between the bunks of a toppled bed. It is missing the helmet though.");
                    }   if(!hasKey) {
                        System.out.println("A small, shiny piece of metal catches your eye as it glimmers in the corner.");
                    }   if(!isInSelfDestruct) {
                        System.out.println("There is also a red button on the back wall. Below it, 'Press only in an emergency'");
                    }   break;
                case "Storage Room":
                    if(alienIsAlive && !hasGun) {
                        System.out.println("As you open the door, a blue light begins to shine through.");
                        System.out.println("You hear fast, loud footsteps behind you.");
                        System.out.println("The alien tears its claws through your feeble body");
                        System.out.println("You have died. But what does it matter, each and every human life is insignificant in this vast universe.");
                    } else if(alienIsAlive && hasGun) {
                        System.out.println("You hear fast, loud footsteps behind you.");
                        System.out.println("The alien flies toward you.");
                        
                        //must type kill or shoot or attack in two chances or dies
                        
                        System.out.print(">");
                        
                    } else if(!alienIsAlive) {
                        System.out.println("As you open the door, a blue light begins to shine through");
                        System.out.println("A cold wind brushes across your face as a wormhole is revealed on the back wall.");
                        System.out.println("This could be your way out.");
                        
                        //wormhole interaction
                        //remember to program chances of location like moon, earth, or random place in the universe
                        
                    }   break;
                case "Fuel Room":
                    System.out.println("There is a door to the west and a hallway to the south.");
                    System.out.println("Above the entrance to the hallway, a sign reads 'Filtration room'");
                    if(!hasGun) {
                        System.out.println("There is a gun lying on the floor to your left.");
                    }   System.out.println("A heavily dented fuel tank stands at the back to the room.");
                    System.out.println("There are 3 long, deep scratch marks in the floor. It looks like something with claws created them.");
                    
                    //inspect/search interaction to find note
                    break;
                default:
                    System.out.println("Error Line 142: Invalid currentRoom Value");
                    break;
            }
            
            //takes input from user for action
            
            while (true) {
                boolean hasDoneAction = false;
                boolean hasBeenDenied = false;
                
                System.out.print(">");
                userInput = input.nextLine();

                switch (userInput.toLowerCase()) {
                    
                    //GET ITEM ACTION
                    
                    case "grab":
                    case "get":
                    case "take":
                    case "pick up":
                    case "collect":
                        System.out.println("What would you like to " + userInput + "?");
                        System.out.print(">");
                        userInput = input.nextLine();
                        if((userInput.toLowerCase().equals("phone") || userInput.toLowerCase().equals("interspace phone")) && currentRoom.equals("Main Cabin") && !hasPhone) {
                            hasPhone = true;
                            System.out.println("You picked up the phone");
                            System.out.println("Maybe it can be used to get help. You just need to find the right number to call");
                        } if(currentRoom.equals("Kitchen")) {
                            if((userInput.toLowerCase().equals("potato") || userInput.toLowerCase().equals("the potato")) && isFridgeOpen == true) {
                                hasPotato = true;
                            }
                        
                            //ADD ELSE IF RIGHT HERE
                        
                        } else {
                            System.out.println("You can't pick that up.");
                        }
                        
                        break;
                    
                    //MOVE ACTION
                    
                    case "go":
                    case "move":
                    case "travel":
                        System.out.println("Where would you like to go?");
                        System.out.print(">");
                        userInput = input.nextLine();
                        switch(userInput.toLowerCase()) {
                            case "west":
                                switch(currentRoom) {
                                    case "Main Cabin":
                                    case "Bedroom":
                                    case "Bathroom":
                                        System.out.println("You can't move in that direction, there is a wall.");
                                        break;
                                    case "Filtration Room":
                                        System.out.println("You move west.");
                                        currentRoom = "Fuel Room";
                                        hasDoneAction = true;
                                        break;
                                    case "Storage Room":
                                        System.out.println("You are intrigued by the wormhole. It calls to you.");
                                        break;
                                    case "Fuel Room":
                                        System.out.println("You move west.");
                                        currentRoom = "Kitchen";
                                        hasDoneAction = true;
                                        break;
                                    case "Kitchen":
                                        System.out.println("You move west.");
                                        currentRoom = "Main Cabin";
                                        hasDoneAction = true;
                                        break;
                                    default:
                                        System.out.println("Error Line 157: Invalid currentRoom value.");
                                        break;
                                }
                                break;
                            case "east":
                                switch(currentRoom) {
                                    case "Filtration Room":
                                        System.out.println("You move east.");
                                        currentRoom = "Fuel Room";
                                        hasDoneAction = true;
                                        break;
                                    case "Bedroom":
                                        if(hasKey) {
                                            System.out.println("Unlocking door...");
                                            currentRoom = "Storage Room";
                                            hasDoneAction = true;
                                        } else {
                                            System.out.println("The door is locked by what looks like the strongest lock you've ever seen.");
                                            currentRoom = "Bedroom";
                                            hasDoneAction = true;
                                        }
                                        break;
                                    case "Bathroom":
                                        System.out.println("You move east.");
                                        currentRoom = "Filtration Room";
                                        hasDoneAction = true;
                                        break;
                                    case "Storage Room":
                                        GoThroughWormhole.goThroughWormhole();
                                        break;
                                    case "Fuel Room":
                                        System.out.println("You can't move in that direction, there is a wall.");
                                        break;
                                    case "Kitchen":
                                        System.out.println("You move east.");
                                        currentRoom = "Fuel Room";
                                        hasDoneAction = true;
                                        break;
                                    case "Main Cabin":
                                        System.out.println("You move east");
                                        currentRoom = "Kitchen";
                                        hasDoneAction = true;
                                        break;
                                    default:
                                        System.out.println("Error Line 157: Invalid currentRoom value.");
                                        break;
                                }
                                
                                break;
                            case "north":
                                switch(currentRoom) {
                                    case "Filtration Room":
                                        System.out.println("You move north.");
                                        currentRoom = "Kitchen";
                                        hasDoneAction = true;
                                        break;
                                    case "Bedroom":
                                        System.out.println("You move north.");
                                        currentRoom = "Filtration Room";
                                        hasDoneAction = true;
                                        break;
                                    case "Bathroom":
                                        System.out.println("You move north.");
                                        currentRoom = "Main Cabin";
                                        hasDoneAction = true;
                                        break;
                                    case "Main Cabin":
                                    case "Fuel Room":
                                    case "Storage Room":
                                    case "Kitchen":
                                        System.out.println("You can't move in that direction, there is a wall");
                                        break;
                                    default:
                                        System.out.println("Error Line 157: Invalid currentRoom value.");
                                        break;
                                }
                                break;
                            case "south":
                                switch(currentRoom) {
                                    case "Filtration Room":
                                        System.out.println("You move south.");
                                        currentRoom = "Bedroom";
                                        hasDoneAction = true;
                                        break;
                                    case "Bedroom":
                                    case "Bathroom":
                                    case "Storage Room":
                                        System.out.println("You can't move in that direction, there is a wall");
                                        break;
                                    case "Fuel Room":
                                        System.out.println("You move south.");
                                        currentRoom = "Filtration Room";
                                        hasDoneAction = true;
                                        break;
                                    case "Kitchen":
                                        System.out.println("You move south.");
                                        currentRoom = "Filtration Room";
                                        hasDoneAction = true;
                                        break;
                                    case "Main Cabin":
                                        System.out.println("You move south");
                                        currentRoom = "Bathroom";
                                        hasDoneAction = true;
                                        break;
                                    default:
                                        System.out.println("Error Line 157: Invalid currentRoom value.");
                                        break;
                                }
                                
                                break;
                            default:
                                System.out.println("You can't go in that direction.");
                                hasBeenDenied = true;
                                break;
                        }
                        break;
                        
                    //YELL ACTION
                        
                    case "scream":
                    case "yell":
                    case "holler":
                    case "call for help":
                        System.out.println("You call out for help.");
                        System.out.println("It's futile, no one will ever be able to hear you.");
                        break;
                    
                    //DEFAULT CASE
                        
                    default:
                        if(!hasBeenDenied)
                            System.out.println("You can't do that here.");
                        break;
                }
                
                if(hasDoneAction)
                    break;
            }
            
            //player must find oxygen

            turnCounter++;
            
            System.out.println("You have taken " + turnCounter + " turns.");
        }
    }
}

