package Ravikumar.Sujatha.Casino;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by sujatharavikumar on 10/9/16.
 */
public class DeckTest {

    @Test
    public void dealCardTest(){
        Deck deck = new Deck();
        Card card = deck.dealCard();
        Assert.assertEquals("The number of cards in the deck should be 51", 51, deck.deckOfCards.size());
    }

}
