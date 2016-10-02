package Ravikumar.Sujatha.Casino;

/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class BlackJack {

    private Player blackJackPlayer, dealer;
    boolean playerTurn = true;
    Input input = new Input();
    Deck deck = new Deck();


    public void playGame(Player player){
        blackJackPlayer = player;
        dealer = new Player("Dealer");
        bet();
        deal();
        Display.displayPlayerHand();
        blackJackPlayer.displayHand(blackJackPlayer);
        System.out.println();
        Display.displayDealerHand();
        dealer.displayHand(dealer);
        //boolean playerHasBlackJack = doesPlayerHaveAnotherTurn();
        if(doesPlayerHaveAnotherTurn()){
            hitOrStand();
            Display.displayPlayerHand();
            blackJackPlayer.displayHand(blackJackPlayer);
            System.out.println();
        }


        else
            System.out.println("Game Over");

    }



    public void hitOrStand(){
        boolean checkIfPlayerHasAnotherTurn;
        System.out.println("What do you wish to do?? Hit or Stand. Press H for Hit and S for Stand");
        char hitOrStandInput = input.getHitOrStand();
        switch(hitOrStandInput){
            case 'H':
                blackJackPlayer.addCardToHand(deck.dealCard());
                Display.displayPlayerHand();
                blackJackPlayer.displayHand(blackJackPlayer);
                System.out.println();
                checkIfPlayerHasAnotherTurn = doesPlayerHaveAnotherTurn();
                if(checkIfPlayerHasAnotherTurn)
                    hitOrStand();
                break;
            case 'S':
                playerTurn = false;
                break;
            default:
                System.out.println("Enter S or H");

        }
    }




    public void deal(){
        deck.shuffleDeck();
        blackJackPlayer.addCardToHand(deck.dealCard());
        blackJackPlayer.addCardToHand(deck.dealCard());
        deck.shuffleDeck();

        dealer.addCardToHand(deck.dealCard());
        dealer.addCardToHand(deck.dealCard());
        Display.displayFirstRoundOfDeal();
    }


    public void bet(){
        System.out.println("How much do you want to bet?");
        double betAmount = input.getAmount();
        if (blackJackPlayer.getMoneyInWallet() >= betAmount){
            blackJackPlayer.removeMoneyFromWallet(betAmount);
        }
        else
            System.out.println("You do not have enough money to bet. Decrease your bet amount.");
    }

    public int getTotalHandValue(Player player){
        int handTotal = 0;
        int aceValue = 11;

        for(int i=0; i<player.hand.size(); i++) {
            if (player.hand.get(i).getRank() <= 10 ){
                handTotal += player.hand.get(i).getRank();
            }
            else if (player.hand.get(i).getRank() == aceValue){
                handTotal += aceValue;
            }
            else if (player.hand.get(i).getRank() > 11){
                handTotal += 10;
            }
        }
        return handTotal;
    }


    public boolean doesPlayerHaveAnotherTurn(){
        int totalHandValue = getTotalHandValue(blackJackPlayer);
        if (totalHandValue == 21) {
            playerTurn = false;
            System.out.println("Player Wins!!!");
            return playerTurn;
        }
        else if(totalHandValue > 21) {
            playerTurn = false;
            System.out.println("Busted");
            return playerTurn;
        }
        else {
            hitOrStand();
            return playerTurn;
        }
    }

}
