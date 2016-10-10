package Ravikumar.Sujatha.Casino;
import java.util.*;
/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class Player {

    String name;
    private double moneyInWallet;
    List<Card> hand = new ArrayList<Card>();


    public Player(){

    }

    public Player(String name){
        this.name = name;
    }


    public double getMoneyInWallet() {
        return moneyInWallet;
    }

    public void setMoneyInWallet(double moneyInWallet) {
        this.moneyInWallet = moneyInWallet;
    }

    public void addMoneyToWallet(double money){
        setMoneyInWallet(moneyInWallet+money);
    }

    public void removeMoneyFromWallet(double money){
        setMoneyInWallet(moneyInWallet - money);
    }

    public void addCardToHand(Card card){
        hand.add(card);
    }

    public void displayHand(Player playerOrDealer){
            for(Card card : playerOrDealer.hand){
                if(card.getRank() == 11)
                    System.out.println("Ace of "+card.getSuit());
                else if (card.getRank() == 12)
                    System.out.println("Jack of "+card.getSuit());
                else if (card.getRank() == 13)
                    System.out.println("Queen of "+card.getSuit());
                else if (card.getRank() == 14)
                    System.out.println("King of "+card.getSuit());
                else
                    System.out.println(card.getRank()+" of "+card.getSuit());
            }

    }


    public void printMoneyInWallet(){
        System.out.println("Money in Player's wallet after the game: "+getMoneyInWallet());

    }



}
