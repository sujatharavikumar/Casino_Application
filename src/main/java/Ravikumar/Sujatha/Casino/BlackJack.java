package Ravikumar.Sujatha.Casino;

/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class BlackJack {

    private Player blackJackPlayer, dealer;
    double betAmount;
    boolean playerTurn = true;
    boolean dealerTurn = true;
    Input input = new Input();
    Deck deck = new Deck();


    public void playGame(Player player){
        blackJackPlayer = player;
        dealer = new Player("Dealer");
        betAmount = bet();
        deal();
        Display.displayPlayerHand();
        blackJackPlayer.displayHand(blackJackPlayer);
        System.out.println();
        Display.displayDealerHand();
        dealer.displayHand(dealer);
        if(doesPlayerHaveAnotherTurn(blackJackPlayer)){
            hitOrStand();
            Display.displayPlayerHand();
            blackJackPlayer.displayHand(blackJackPlayer);
            System.out.println();
        }

        else
            findWinner();

    }


    public void findWinner(){
        double winningAmount = betAmount*2;
        int totalPlayerHandValue = getTotalHandValue(blackJackPlayer);
        int totalDealerHandValue = getTotalHandValue(dealer);
        int howFarIsPlayerFrom21 = 21 - totalPlayerHandValue;
        int howFarIsDealerFrom21 = 21 - totalDealerHandValue;

        if ((howFarIsPlayerFrom21 >= 0) && (howFarIsPlayerFrom21 < howFarIsDealerFrom21)) {
            System.out.println("\nPlayer Wins!!!");
            blackJackPlayer.addMoneyToWallet(winningAmount);
            blackJackPlayer.printMoneyInWallet();
        }
        else if ((howFarIsDealerFrom21 >= 0) && (howFarIsDealerFrom21 < howFarIsPlayerFrom21)) {
            System.out.println("\nDealer Wins!!!");
            blackJackPlayer.printMoneyInWallet();
        }
        else if ((howFarIsDealerFrom21 >= 0) && (howFarIsPlayerFrom21 >= 0) && (howFarIsDealerFrom21 == howFarIsPlayerFrom21)){
            System.out.println("\nGame ends in a Draw...");
            blackJackPlayer.addMoneyToWallet(betAmount);
            blackJackPlayer.printMoneyInWallet();
        }

    }


    public void hitOrStand(){
        boolean checkIfPlayerHasAnotherTurn;
        System.out.println("\nWhat do you wish to do?? Hit or Stand. Press H for Hit and S for Stand");
        char hitOrStandInput = input.getHitOrStand();
        switch(hitOrStandInput){
            case 'H':
                blackJackPlayer.addCardToHand(deck.dealCard());
                Display.displayPlayerHand();
                blackJackPlayer.displayHand(blackJackPlayer);
                System.out.println();
                checkIfPlayerHasAnotherTurn = doesPlayerHaveAnotherTurn(blackJackPlayer);
                if(checkIfPlayerHasAnotherTurn)
                    hitOrStand();
                break;
            case 'S':
                playerTurn = false;
                Display.displayPlayerHand();
                blackJackPlayer.displayHand(blackJackPlayer);
                Display.displayDealerHand();
                dealer.displayHand(dealer);
                doesDealerHaveAnotherTurn(dealer);
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


    public double bet(){
        System.out.println("How much do you want to bet?");
        double betAmount = input.getAmount();
        if (blackJackPlayer.getMoneyInWallet() >= betAmount){
            blackJackPlayer.removeMoneyFromWallet(betAmount);
            blackJackPlayer.printMoneyInWallet();
        }
        else
            System.out.println("You do not have enough money to bet. Decrease your bet amount.");
        return betAmount;
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


    public boolean doesPlayerHaveAnotherTurn(Player player){
        int totalHandValue = getTotalHandValue(player);
        if (totalHandValue == 21) {
            playerTurn = false;
            System.out.println("Player Wins!!!");
            return playerTurn;
        }
        else if(totalHandValue > 21) {
            playerTurn = false;
            System.out.println("Busted");
            player.printMoneyInWallet();
            return playerTurn;
        }
        else {
            hitOrStand();
            return playerTurn;
        }
    }


    public boolean doesDealerHaveAnotherTurn(Player player){
        int totalHandValue = getTotalHandValue(player);
        if (totalHandValue == 21) {
            dealerTurn = false;
            System.out.println("\nDealer wins!!");
            return dealerTurn;
        }
        else if (totalHandValue > 21) {
            dealerTurn = false;
            System.out.println("\nDealer Busted and Player wins..");
            blackJackPlayer.addMoneyToWallet(betAmount+betAmount);
            blackJackPlayer.printMoneyInWallet();
            return dealerTurn;
        }
        else if(totalHandValue < 17){
            dealerTurn = true;
            System.out.println("\nDealer wants a HIT...");
            dealer.addCardToHand(deck.dealCard());
            Display.displayDealerHand();
            dealer.displayHand(player);
            doesDealerHaveAnotherTurn(player);
            return dealerTurn;
        }
        else{
            dealerTurn = false;
            System.out.println("\nDealer Stands!!");
        }
        return dealerTurn;
    }

}
