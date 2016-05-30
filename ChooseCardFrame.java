import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ChooseCardFrame extends JFrame {

    private int choice;
    private boolean actionFlag = false;

    public ChooseCardFrame(String title, ArrayList<Card> cards) {

        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        int buttonText = 1;
        int yValue1 = 0;
        for (Card card: cards){
            JButton button = new JButton(String.valueOf(buttonText));
            gc.gridx = 0; gc.gridy = yValue1; gc.weighty = 10; gc.anchor = GridBagConstraints.CENTER;
            add(button, gc);
            buttonPress(button);
            yValue1++;
            buttonText++;
        }

        int yValue2 = 0;
        for (Card card : cards) {
            JLabel label = new JLabel();
            gc.gridx = 1; gc.gridy = yValue2; gc.anchor = GridBagConstraints.CENTER;
            if (card instanceof MineralCard) label.setText(((MineralCard) card).getAttributes());
            else if (card instanceof SuperTrumpCard) label.setText(((SuperTrumpCard) card).getAttributes());
            add(label, gc);
            yValue2++;
        }
    }
    public void buttonPress(JButton button){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = Integer.parseInt(button.getText());
                actionFlag = true;
                ChooseCardFrame.super.setVisible(false);
            }
        });
    }

    public boolean isActionFlag() {
        return actionFlag;
    }

    public int getChoice() {
        return choice;
    }
}
