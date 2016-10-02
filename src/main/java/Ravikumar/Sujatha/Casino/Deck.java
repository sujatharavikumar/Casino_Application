package Ravikumar.Sujatha.Casino;
import java.util.*;
/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class Deck {

    public enum Suit{Spades, Clubs, Hearts, Diamonds};


    public List<Card> deckOfCards = new ArrayList<Card>();

    public Deck(){

        for(int i=0; i<4; i++){
            for(int j=2; j<15; j++){
                deckOfCards.add(new Card(j, Suit.values()[i]));
            }
        }
    }


    public void shuffleDeck(){
        Collections.shuffle(deckOfCards);
    }


    public Card dealCard(){
        Card card = deckOfCards.get(0);
        deckOfCards.remove(0);
        return card;
    }


}
