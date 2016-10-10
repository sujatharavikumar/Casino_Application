package Ravikumar.Sujatha.Casino;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sujatharavikumar on 10/9/16.
 */
public class BlackJackTest {

    @Test
    public void betTest(){
        DummyUserInput dummyUserInput = new DummyUserInput();
        double moneyInWallet = dummyUserInput.getDummyAmountIntoPlayerWallet();
        double betAmount = dummyUserInput.getDummyBetAmount();
        double remainingMoneyInWallet = moneyInWallet - betAmount;
        Assert.assertTrue(remainingMoneyInWallet == 50);
    }


    @Test
    public void getTotalHandValueTest(){
       Player player = new Player();
       BlackJack blackJack = new BlackJack();
       Deck deck = new Deck();
       player.addCardToHand(new Card(2, Deck.Suit.Clubs));
       player.addCardToHand(new Card(5, Deck.Suit.Spades));
       Assert.assertEquals("Total hand value of the player should be 7", 7, blackJack.getTotalHandValue(player));
    }


    @Test
    public void doesPlayerHaveAnotherTurnTestWithHandValue21(){
        Player player = new Player();
        BlackJack blackJack = new BlackJack();
        Deck deck = new Deck();
        player.addCardToHand(new Card(11, Deck.Suit.Clubs));
        player.addCardToHand(new Card(10, Deck.Suit.Spades));
        boolean flag = blackJack.doesPlayerHaveAnotherTurn(player);
        Assert.assertEquals("The return value should be false", false, flag);
    }


    @Test
    public void doesPlayerHaveAnotherTurnTestWithHandValueGreaterThan21(){
        Player player = new Player();
        BlackJack blackJack = new BlackJack();
        Deck deck = new Deck();
        player.addCardToHand(new Card(11, Deck.Suit.Clubs));
        player.addCardToHand(new Card(10, Deck.Suit.Spades));
        player.addCardToHand(new Card(2, Deck.Suit.Hearts));
        boolean flag = blackJack.doesPlayerHaveAnotherTurn(player);
        Assert.assertEquals("The return value should be false", false, flag);

    }


    @Test
    public void doesDealerHaveAnotherTurnTestWithHandValue21(){
        Player dealer = new Player();
        BlackJack blackJack = new BlackJack();
        Deck deck = new Deck();
        dealer.addCardToHand(new Card(11, Deck.Suit.Clubs));
        dealer.addCardToHand(new Card(10, Deck.Suit.Spades));
        boolean flag = blackJack.doesDealerHaveAnotherTurn(dealer);
        Assert.assertEquals("The return value should be false", false, flag);

    }


    @Test
    public void doesDealerHaveAnotherTurnTestWithHandValueGreaterThan21(){
        Player dealer = new Player();
        BlackJack blackJack = new BlackJack();
        Deck deck = new Deck();
        dealer.addCardToHand(new Card(7, Deck.Suit.Clubs));
        dealer.addCardToHand(new Card(9, Deck.Suit.Spades));
        dealer.addCardToHand(new Card(6, Deck.Suit.Hearts));
        boolean flag = blackJack.doesPlayerHaveAnotherTurn(dealer);
        Assert.assertEquals("The return value should be false", false, flag);

    }



}
