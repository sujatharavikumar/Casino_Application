package Ravikumar.Sujatha.Casino;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sujatharavikumar on 10/9/16.
 */
public class PlayerTest {

    @Test
    public void addCardToHandTest(){
        Player player = new Player();
        Deck deck = new Deck();
        player.addCardToHand(deck.dealCard());
        Assert.assertEquals("ArrayList hand should have a size of 1", 1, player.hand.size());
    }

    @Test
    public void addMoneyToWalletTest(){
        Player player = new Player();
        player.addMoneyToWallet(200);
        Assert.assertTrue(player.getMoneyInWallet() == 200);
    }

    @Test
    public void removeMoneyFromWalletTest(){
        Player player = new Player();
        player.addMoneyToWallet(200);
        player.removeMoneyFromWallet(100);
        Assert.assertTrue(player.getMoneyInWallet() == 100);
    }


}
