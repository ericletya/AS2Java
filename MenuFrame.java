import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFrame extends JFrame {
    private String choice;
    private boolean actionFlag;

    public MenuFrame(String title, int turn){

        super(title);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        JButton button = new JButton("Show hand");
        gc.gridx = 0; gc.gridy = 0; gc.weightx = 0.5; gc.fill = GridBagConstraints.HORIZONTAL;
        add(button, gc);
        buttonPress(button);

        JButton button1 = new JButton("Use a card");
        gc.gridx = 1; gc.gridy = 0; gc.weightx = 0.5; gc.fill = GridBagConstraints.HORIZONTAL;
        add(button1, gc);
        buttonPress(button1);

        JButton button3 = new JButton("Pass");
        gc.gridx = 2; gc.gridy = 0; gc.weightx = 0.5; gc.fill = GridBagConstraints.HORIZONTAL;
        if (turn > 0) add(button3, gc);
        buttonPress(button3);

        JButton button2 = new JButton("Show current card and attribute");
        gc.gridx = 0; gc.gridy = 1;
        gc.gridwidth = 3; gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 0.1;
        if (turn > 0) add(button2, gc);
        buttonPress(button2);
    }
    private void buttonPress(JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = button.getText();
                actionFlag = true;
                MenuFrame.super.setVisible(false);
            }
        });

    }

    public String getChoice() {
        return choice;
    }

    public boolean isActionFlag() {
        return actionFlag;
    }
}
