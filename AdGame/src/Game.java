import java.util.Scanner;

public class Game {
    Scanner scan = new Scanner(System.in);
    Player player;
    Location location;

    public void login()
    {
        System.out.println("Welcome to Adventure Game!");
        System.out.print("Write your Name: ");
        String playerName= scan.nextLine();
        player = new Player(playerName);
        player.selectChar();
        start();
    }
    public void start()
    {
       while(true)
       {
           System.out.println("\n-----------------------------------\n");
           System.out.println("Please choose a place");
           System.out.println("1-Safehouse-->There isn't enemy.");
           System.out.println("2-Cave-->Maybe you encounter a zombie.");
           System.out.println("3-River-->Maybe you encounter a bear.");
           System.out.println("4-Forest-->Maybe you encounter a vampire.");
           System.out.println("5-Shop-->You can buy tool.");
           System.out.print("Your choice:");
           int selLoc = scan.nextInt();
           while(selLoc<0 && selLoc>5)
           {
               System.out.print("Number must be valid!Select again.");
               selLoc= scan.nextInt();
           }
           switch(selLoc)
           {
               case 1:
                   location = new SafeHouse(player);
                   break;
               case 2:
                   location = new Cave(player);
                   break;
               case 3:
                   location = new River(player);
                   break;
               case 4:
                   location =  new Forest(player);
                   break;
               case 5:
                   location= new Shop(player);
                   break;

           }
           if(!location.getLocation())
           {
               System.out.println("GAME OVER!");
               break;
           }
       }
    }
}
