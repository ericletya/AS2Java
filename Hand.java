import javax.swing.*;
import java.util.ArrayList;

public class Hand {
    private String name;
    private ArrayList<Card> cards;
    private boolean status;

    Hand(Deck deck, String name, boolean status){
        cards = new ArrayList<>();
        for (int i = 1; i<=8; i++){
            cards.add(deck.drawFromDeck());
        }
        this.name = name;
        this.status = status;
    }

    public void draw(Deck deck){
        cards.add(deck.drawFromDeck());
    }

    public Card useCard(int cardNumber) {
        Card card_for_use = cards.get(cardNumber - 1);
        cards.remove(cardNumber - 1);
        return card_for_use;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void display() {
        JFrame frame = new CardFrame("Hand", cards);
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setVisible(true);
    }
}