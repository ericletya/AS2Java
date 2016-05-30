import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberFrame extends JFrame {

    private int choice;
    private boolean actionFlag = false;

    public NumberFrame(String title){
        super(title);

        setLayout(new GridBagLayout());

        JLabel label = new JLabel("Choose number of players: ");

        JButton button1 = new JButton("3");
        buttonPress(button1);

        JButton button2 = new JButton("4");
        buttonPress(button2);

        JButton button3 = new JButton("5");
        buttonPress(button3);

        GridBagConstraints gc = new GridBagConstraints();

        gc.gridx = 0; gc.gridy = 0;
        add(label, gc);

        gc.gridx = 1; gc.gridy = 0; gc.gridwidth = 1;
        add(button1, gc);

        gc.gridx = 2; gc.gridy = 0;
        add(button2, gc);

        gc.gridx = 3; gc.gridy = 0;
        add(button3, gc);
    }

    private void buttonPress(JButton button){

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = Integer.parseInt(button.getText());
                actionFlag = true;
                NumberFrame.super.invalidate();
                NumberFrame.super.setVisible(false);
            }
        });

    }

    public int getChoice() {
        return choice;
    }

    public void setChoice(int choice) {
        this.choice = choice;
    }

    public boolean isActionFlag() {
        return actionFlag;
    }
}
