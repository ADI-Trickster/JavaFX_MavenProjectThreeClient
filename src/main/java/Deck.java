import java.util.ArrayList;
import java.util.Collections;

public class Deck extends ArrayList<Cards> {
    // makes a new 52 card deck
    public Deck() {
        newDeck();
    }

    // Clears all cards and creates a new deck of 52 cards in random order.
    public void newDeck() {
        this.clear();
        char[] suits = {'H','D','S','C'};
        for (char suit : suits) {//adds each suit
            for (int value = 2; value < 15; value++) {// adds each cards from suit to deck
                this.add(new Cards(suit, value));
            }
        }
        Collections.shuffle(this); // shuffles cards for the game
    }
    //add shuffle

    public void shuffleDeck() {
        Collections.shuffle(this);
    }

    //add to get next 3 cards from array into hand
    public ArrayList<Cards> add3CardsFromDeck(){
        ArrayList<Cards> cards = new ArrayList<>();
        //add 3 cards
        for(int i = 0; i < 3; i++){
            cards.add(this.remove(0));
        }
        return cards;
    }


}