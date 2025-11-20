//import javax.smartcardio.Card;
import java.io.Serializable;
import java.util.ArrayList;

class PokerInfo implements Serializable {

    private ArrayList<Cards> playerCards;
    private ArrayList<Cards> dealerCards;
    private int potAmount;
    private int playerBet;
    private int bigBlind;
    private int pairPlusBet;
    private boolean playerFolded;
    private int totalWinnings;
    private int gameOver;

    private String message;

    public PokerInfo(){
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
    }

    public ArrayList<Cards> getPlayerHand() { return playerCards; }
    public void setPlayerHand(ArrayList<Cards> playerHand) {
        this.playerCards = playerHand;
    }

    public ArrayList<Cards> getDealerHand() { return dealerCards; }
    public void setDealerHand(ArrayList<Cards> dealerHand) {
        this.dealerCards = dealerHand;
    }

    public int getPlayerBet() { return playerBet; }
    public void setPlayerBet(int playerBet) { this.playerBet = playerBet; }

    public boolean isPlayerFolded() { return playerFolded; }
    public void setPlayerFolded(boolean playerFolded) { this.playerFolded = playerFolded; }

    public int getBigBlind() { return bigBlind; }
    public void setBigBlind(int bigBlind) { this.bigBlind = bigBlind; }

    public void addCardToHand(Cards card) {
        playerCards.add(card);
    }

    public void clearPlayerCards() {
        playerCards.clear();
    }

    public void addDealerCard(Cards card) {
        dealerCards.add(card);
    }
    public void clearDealerCards() {
        dealerCards.clear();
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

}