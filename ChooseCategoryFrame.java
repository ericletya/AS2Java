import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseCategoryFrame extends JFrame {

    private String choice;
    private boolean actionFlag = false;

    ChooseCategoryFrame(String title){

        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        JButton button = new JButton("Hardness");
        gc.gridx = 0; gc.gridy = 0; gc.fill = GridBagConstraints.HORIZONTAL;
        add(button, gc);
        buttonPress(button);

        JButton button1 = new JButton("Specific gravity");
        gc.gridx = 0; gc.gridy = 1;
        add(button1, gc);
        buttonPress(button1);

        JButton button2 = new JButton("Cleavage");
        gc.gridx = 0; gc.gridy = 2;
        add(button2, gc);
        buttonPress(button2);

        JButton button3 = new JButton("Crustal abundance");
        gc.gridx = 0; gc.gridy = 3;
        add(button3, gc);
        buttonPress(button3);

        JButton button4 = new JButton("Economic value");
        gc.gridx = 0; gc.gridy = 4;
        add(button4, gc);
        buttonPress(button4);
    }
    private void buttonPress(JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = button.getText();
                actionFlag = true;
                ChooseCategoryFrame.super.setVisible(false);
            }
        });

    }

    public boolean isActionFlag() {
        return actionFlag;
    }

    public String getChoice() {
        return choice;
    }
}
