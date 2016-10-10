package Ravikumar.Sujatha.Casino;

/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class Display {

    public static void displayWelcomeMessage(){
        System.out.println("\nWELCOME TO THE CASINO!!\n");

    }

    public static void displayMainMenu(){
        System.out.println("Choose a game:");
        System.out.println("1. Black Jack");
        System.out.println("2. Quit Casino");

    }

    public static void displayFirstRoundOfDeal(){
        System.out.println("First round of deal is done");
    }

    public static void displayPlayerHand(){
        System.out.println("******************************");
        System.out.println("Player hand:");
        System.out.println("******************************");

    }

    public static void displayDealerHand(){
        System.out.println("******************************");
        System.out.println("Dealer hand:");
        System.out.println("******************************");

    }


}
