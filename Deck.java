import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        BufferedReader br = null;
        String line;
        String[] attributeValues;
        try{
            br = new BufferedReader(new FileReader("card.txt"));
        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage() + "File not found");
            System.exit(0);
        }
        try {
            while((line = br.readLine()) != null){
                attributeValues = line.split(",");
                String name = attributeValues[0];
                double hardness = Double.parseDouble(attributeValues[1]);
                double gravity = Double.parseDouble(attributeValues[2]);
                String cleavage = attributeValues[3];
                String crustal = attributeValues[4];
                String ecoValue = attributeValues[5];
                cards.add(new MineralCard(name, hardness, gravity, cleavage, crustal, ecoValue));
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage() + "Error reading file");
        }
        cards.add(new SuperTrumpCard("The Mineralogist", "Change trump category to 'Cleavage'"));
        cards.add(new SuperTrumpCard("The Miner", "Change trumps category to 'Economic Value'"));
        cards.add(new SuperTrumpCard("The Petrologist", "Change trumps category to 'Crustal Abundance'"));
        cards.add(new SuperTrumpCard("The Gemologist", "Change trumps category to 'Hardness'"));
        cards.add(new SuperTrumpCard("The Geophysicist", "Change trumps category to 'Specific Gravity' or throw 'Magnetite'"));
        cards.add(new SuperTrumpCard("The Geologist", "Change to trumps category of your choice"));
        shuffle();
    }

    public ArrayList<Card> shuffle(){
        Collections.shuffle(cards);
        return cards;
    }

    public Card drawFromDeck(){
        return cards.remove(cards.size()-1);
    }

    public int getTotalCards(){
        return cards.size();
    } 

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void display(){
        for (Card card: cards){
            System.out.println(card.getName());
        }
    }
}