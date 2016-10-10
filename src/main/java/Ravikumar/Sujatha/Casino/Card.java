package Ravikumar.Sujatha.Casino;

/**
 * Created by sujatharavikumar on 10/1/16.
 */
public class Card {
    private int rank;
    private Deck.Suit suit;

    public Card(int rank, Deck.Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }


    public Deck.Suit getSuit() {
        return suit;
    }

}
