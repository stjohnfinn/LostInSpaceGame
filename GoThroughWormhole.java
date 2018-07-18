public class GoThroughWormhole {
    public static void goThroughWormhole() {
        int randNum = (int)(Math.random()* 2.99);
        
        System.out.println("FLUMPF");
        
        switch(randNum) {
            case 0:
                System.out.println("You have landed in a large desert...hopefully on Earth.\n\n");
                System.out.println("\n\nLost In Space ");
                System.out.println("\n\nA game by Finn St John");
                System.out.println("To be continued...");
                System.exit(0);
            case 1:
                System.out.println("You have traveled to some stray corner of the universe. You die a slow, lonely death.");
                System.out.println("\n\nLost In Space ");
                System.out.println("\n\nA game by Finn St John");
                System.out.println("To be continued...");
                System.exit(0);
            case 2:
                System.out.println("You have warped to somewhere on the moon.");
                System.out.println("You die a slow, cold death.\n\n");
                System.out.println("\n\nLost In Space ");
                System.out.println("\n\nA game by Finn St John");
                System.out.println("To be continued...");
                System.exit(0);
        }
    }
    
    GoThroughWormhole() {};
}
