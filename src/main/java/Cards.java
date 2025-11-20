public class Cards {
    private char suit;
    private int value;
    private String cardImage;

    public Cards(char suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public char getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}