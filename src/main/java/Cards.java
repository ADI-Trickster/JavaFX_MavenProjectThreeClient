import java.io.Serializable;

public class Cards implements Serializable {
    private String suit;
    private int value;
    private String cardImage;

    public Cards(String suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }
}