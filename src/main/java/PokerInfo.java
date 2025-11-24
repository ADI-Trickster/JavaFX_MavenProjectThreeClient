import java.io.Serializable;
import java.util.ArrayList;

class PokerInfo implements Serializable {

    private ArrayList<Cards> playerCards;
    private ArrayList<Cards> dealerCards;
    private int potAmount;
    private int anteBet;
    private int pairPlusBet;
    private boolean playerFolded;
    private boolean dealerQualifies;
    private int totalWinnings;
    private int gameOver;
    private String gameState;

    private String message; // say if player won or lost and how much

    public PokerInfo(){
        playerCards = new ArrayList<>();
        dealerCards = new ArrayList<>();
        gameState = "";
    }

    public boolean isHighQueenUp() {
        return dealerQualifies;
    }

    public void highQueenUp(boolean dealerQualifies) {
        this.dealerQualifies = dealerQualifies;
    }

    public ArrayList<Cards> getPlayerHand() { return playerCards; }
    public void setPlayerHand(ArrayList<Cards> playerHand) {
        this.playerCards = playerHand;
    }

    public ArrayList<Cards> getDealerHand() { return dealerCards; }
    public void setDealerHand(ArrayList<Cards> dealerHand) {
        this.dealerCards = dealerHand;
    }

    public int getAnteBet() { return anteBet; }
    public void setAnteBet(int anteBet) { this.anteBet = anteBet; }

    public boolean isPlayerFolded() { return playerFolded; }
    public void setPlayerFolded(boolean playerFolded) { this.playerFolded = playerFolded; }

    public int getPairPlusBet() { return pairPlusBet; }
    public void setPairPlusBet(int pairPlusBet) { this.pairPlusBet = pairPlusBet; }

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

    public String getGameState() { return gameState; }
    public void setGameState(String gameState) { this.gameState = gameState; }
}