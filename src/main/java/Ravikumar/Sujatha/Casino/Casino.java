package Ravikumar.Sujatha.Casino;

/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class Casino {

    Player player;
    Input input = new Input();
    AsciiArt art = new AsciiArt();

    public void startCasino(){
        art.displayAsciiArt();

        Display.displayWelcomeMessage();

        Display.displayMainMenu();
        int userInput = input.getUserInput();

        switch(userInput){
            case 1:
                addPlayer();
                BlackJack blackJack = new BlackJack();
                blackJack.playGame(player);
                break;
            case 2:
                System.exit(0);

        }

    }


    public void addPlayer(){
        player = new Player();
        System.out.println("How much money do you have?");
        double moneyInPlayerWallet = input.getAmount();
        player.setMoneyInWallet(moneyInPlayerWallet);

    }

}
