import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CardFrame extends JFrame {

    public CardFrame(String title, ArrayList<Card> cards){

        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        int yValue = 0;
        for (Card card: cards){
            JLabel label = new JLabel();
            gc.gridx = 0; gc.gridy = yValue; gc.weighty = 10;
            if (card instanceof MineralCard) label.setText(((MineralCard) card).getAttributes());
            else if(card instanceof SuperTrumpCard) label.setText(((SuperTrumpCard) card).getAttributes());
            add(label, gc);
            yValue++;
        }

    }
    public CardFrame(String title, String category, MineralCard card){

        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        JLabel label = new JLabel();
        gc.gridx = 0; gc.gridy = 0;
        label.setText(card.getAttributes());
        add(label, gc);

        JLabel label1 = new JLabel(category);
        gc.gridx = 0; gc.gridy = 1;
        add(label1, gc);
    }

}
